package com.mygdx.actors.towers;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.mygdx.actors.enemies.Enemy;
import com.mygdx.actors.tiles.Tile;
import com.mygdx.gameworld.World;

/**
 * Tower
 *
 * Esta clase abstracta contiene las propiedades comunes de todas las torres
 */
public abstract class Tower extends Image {

    protected Vector2 position;

    protected int damage, range, price, fireRate, projectileSpeed, cooldown;
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
        this.position.x = fundation.getHitbox().getX() + (fundation.getHitbox().getWidth() / 2);
        this.position.y = fundation.getHitbox().getY() + (fundation.getHitbox().getHeight() / 2);

        this.cooldown = 0;
    }

    public void adquireTarget(){

        if (world.enemiesInScreen.isEmpty()) return;

        if (target != null && !target.inRange(this)){
            target = null;
        } else {
            for (Enemy enemy: world.enemiesInScreen) {
                if (enemy.inRange(this) && target == null){
                    target = enemy;
                }
            }
        }
    }

    public void fire(){

        if (target == null) return;

        if (cooldown <=0){
            cooldown = fireRate;
            world.bulletsInScreen.add(new Bullet(world, this, target));
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

    public int getFireRate() {
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
