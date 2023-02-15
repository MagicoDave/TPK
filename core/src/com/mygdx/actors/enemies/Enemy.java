package com.mygdx.actors.enemies;

import static com.mygdx.helpers.Stats.BASE_ENEMY_SPEED;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.mygdx.actors.tiles.Direction;
import com.mygdx.actors.tiles.Tile;
import com.mygdx.actors.towers.Debuff;
import com.mygdx.actors.towers.Tower;
import com.mygdx.gameworld.World;
import com.mygdx.helpers.AssetLoader;

/**
 * Esta clase abstracta contiene las propiedades comunes de todos los enemigos
 */
public abstract class Enemy extends Image {

    /**
     * Referencia del World
     */
    protected World world;

    /**
     * Según el valor, el enemigo se mueve en una dirección u otra
     */
    Direction direction;

    /**
     * Estadísticas:
     * ID: Identificador de subclase (Farmer = 0, Barbarian = 1, Mage = 2, Thief = 3)
     * hp: Puntos de vida
     * damage: Vidas que pierde el jugador si el enemigo llega al final
     * speed: Multiplicador de velocidad
     * reward: Cantidad de oro que da al morir
     */
    protected int ID, hp, damage, speed, reward;

    /**
     *
     */
    protected Debuff debuff;
    protected float timeDebuffed = 0;

    protected boolean alive;

    public Enemy(World world){
        super();

        this.world = world;

        this.direction = Direction.DOWN;
        this.setBounds(world.spawnPoint.getHitbox().getX(), world.spawnPoint.getHitbox().getY(), 16, 16);

        alive = true;
    }

    /**
     * Actualiza el estado del enemigo en el mundo, la posición, debuffs y si está vivo o muerto
     * @param delta Tasa de refresco
     */
    public void update(float delta){
        if (hp <= 0){
            alive = false;
            world.gold += reward;
            world.score += reward;
            AssetLoader.soundDead.play();
            world.enemiesInScreen.removeValue(this, true);
        } else {
            if (debuff != null){
                timeDebuffed += delta;
                //Gdx.app.log("I have a debuff: ", debuff.getValue() + ". Time with debuff: " + timeDebuffed + ". debuff duration: " + debuff.getDuration() + ". Delta: " + delta);
                if (timeDebuffed >= debuff.getDuration()) {
                    debuff = null;
                }
            }
            move(delta);
        }
    }

    /**
     * Mueve al enemigo en función de la direction, comprueba colisiones y si ha llegado al final del recorrido
     * @param delta Tasa de refresco
     */
    public void move(float delta){

        float totalSpeed = BASE_ENEMY_SPEED * speed * delta;
        if (debuff != null){
            totalSpeed = totalSpeed / debuff.getSpeedDivider();
        }

        switch (direction){
            case UP:
                this.setY(this.getY() + totalSpeed);
                break;
            case DOWN:
                this.setY(this.getY() - totalSpeed);
                break;
            case LEFT:
                this.setX(this.getX() - totalSpeed);
                break;
            case RIGHT:
                this.setX(this.getX() + totalSpeed);
                break;
        }

        for (Tile tile: world.roadTiles) {
            if (this.getCenter().x >= tile.getHitbox().x
                && this.getCenter().x <= tile.getHitbox().x + tile.getHitbox().width
                && this.getCenter().y >= tile.getHitbox().y
                && this.getCenter().y <= tile.getHitbox().y + tile.getHitbox().height)
            {
                if (tile.getDirection() != null){
                    this.direction = tile.getDirection();
                }
            }
        }

        if (this.getCenter().x >= world.finishPoint.getHitbox().x
                && this.getCenter().x <= world.finishPoint.getHitbox().x + world.finishPoint.getHitbox().width
                && this.getCenter().y >= world.finishPoint.getHitbox().y + world.finishPoint.getHitbox().height / 2
                && this.getCenter().y <= world.finishPoint.getHitbox().y + world.finishPoint.getHitbox().height)
        {
            alive = false;
            world.lifes -= damage;
            world.enemiesInScreen.removeValue(this, true);
            Gdx.input.vibrate(500);
        }
    }

    public float getTimeDebuffed() {
        return timeDebuffed;
    }

    public void setTimeDebuffed(float timeDebuffed) {
        this.timeDebuffed = timeDebuffed;
    }

    /**
     * Comprueba si está en rango de tiro de una torre determinada
     * @param tower La torre con la que se comprueba el rango
     * @return true si está dentro del rango, false en caso contrario
     */
    public boolean inRange(Tower tower){
        if (getCenter().dst(tower.getPosition()) <= tower.getRange()){
            Gdx.app.log("Distance: ", this.getCenter().dst(tower.getPosition()) + "");
            return true;
        } else {
            return false;
        }
    }

    /**
     * Obtiene el punto central del cuerpo
     * @return Un vector con el punto central
     */
    public Vector2 getCenter(){
        return new Vector2(this.getX() + this.getWidth() / 2, this.getY() + this.getHeight() / 2);
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    public Debuff getDebuff() {
        return debuff;
    }

    public void setDebuff(Debuff debuff) {
        this.debuff = debuff;
    }

    public boolean isAlive(){
        return alive;
    }
}
