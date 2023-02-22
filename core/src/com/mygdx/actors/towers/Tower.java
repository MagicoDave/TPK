package com.mygdx.actors.towers;

import static com.mygdx.helpers.Stats.RAGE_DURATION;
import static com.mygdx.helpers.Stats.SOUND_VOLUME;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.mygdx.actors.enemies.Enemy;
import com.mygdx.actors.tiles.Tile;
import com.mygdx.gameworld.World;
import com.mygdx.helpers.AssetLoader;

/**
 * Esta clase abstracta contiene las propiedades comunes de todas las torres
 */
public abstract class Tower extends Image {

    protected Vector2 position;

    protected int damage, range, price, projectileSpeed;
    protected float fireRate, cooldown;
    protected boolean enraged;
    protected float timeEnraged = 0;
    Debuff debuff;
    Enemy target;
    protected World world;
    protected Tile fundation;

    int ID;

    public Tower (World world, Tile fundation) {
        super();
        this.world = world;
        this.fundation = fundation;

        this.setBounds(fundation.getHitbox().getX(), fundation.getHitbox().getY(), fundation.getHitbox().getWidth(), fundation.getHitbox().getHeight());
        position = new Vector2();
        this.position.x = fundation.getHitbox().getX() + (fundation.getHitbox().getWidth() / 2);
        this.position.y = fundation.getHitbox().getY() + (fundation.getHitbox().getHeight() / 2);

        this.cooldown = 0;
        this.target = null;
    }

    /**
     * Actualiza el estado de la torre: Rage, adquirir target y disparar
     * @param delta Tasa de refresco
     */
    public void update (float delta) {
        if (isEnraged()){
            timeEnraged += delta;
            if (timeEnraged >= RAGE_DURATION) {
                setEnraged(false);
                timeEnraged = 0;
            }
        }
        adquireTarget();
        fire();
    }

    /**
     * La torre adquiere un nuevo objetivo si no hay ninguno valido (no tiene, está muerto o no está en rango)
     */
    public void adquireTarget(){

        if (world.enemiesInScreen.isEmpty()) return;
        if (target != null){
            Gdx.app.log("tower target in range?: ", target.inRange(this) + "");
        }
        if (target == null || !target.isAlive() || !target.inRange(this)){
            for (Enemy enemy: world.enemiesInScreen) {
                if (enemy.inRange(this)){
                    target = enemy;
                    Gdx.app.log("New tower target: ", target.toString());
                    return;
                }
            }
        }
    }

    /**
     * La torre dispara si existe un objetivo válido
     */
    public void fire(){

        if (target == null || !target.isAlive() || !target.inRange(this)){
            if (cooldown > 0){
                cooldown --;
            }
            return;
        }

        if (cooldown <=0){
            if (isEnraged()){
                cooldown = fireRate / 2;
            } else {
                cooldown = fireRate;
            }
            Gdx.app.log("tower fires to: ", target.toString());
            world.bulletsInScreen.add(new Bullet(world, this, target));
            switch (ID){
                case 0:
                    AssetLoader.soundArrow.play(SOUND_VOLUME);
                    break;
                case 1:
                    AssetLoader.soundWitch.play(SOUND_VOLUME);
                    break;
                case 2:
                    AssetLoader.soundSticky.play(SOUND_VOLUME);
                    break;
                case 3:
                    AssetLoader.soundCyclop.play(SOUND_VOLUME);
                    break;
            }
        } else {
            cooldown--;
        }
    }

    public Vector2 getPosition() {
        return position;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getPrice() {
        return price;
    }

    public float getFireRate() {
        return fireRate;
    }

    public void setFireRate(int fireRate) {
        this.fireRate = fireRate;
    }

    public int getProjectileSpeed() {
        return projectileSpeed;
    }

    public void setProjectileSpeed(int projectileSpeed) {
        this.projectileSpeed = projectileSpeed;
    }

    public boolean isEnraged() {
        return enraged;
    }

    public void setEnraged(boolean enraged) {
        this.enraged = enraged;
    }

    public Debuff getDebuff() {
        return debuff;
    }

    public void setDebuff(Debuff debuff) {
        this.debuff = debuff;
    }

    public Enemy getTarget() {
        return target;
    }

    public void setTarget(Enemy target) {
        this.target = target;
    }

    public World getWorld() {
        return world;
    }

    public Tile getFundation() {
        return fundation;
    }

    public int getID() {
        return ID;
    }

}
