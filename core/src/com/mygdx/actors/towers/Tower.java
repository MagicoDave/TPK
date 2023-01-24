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

    protected int damage, range, price, fireRate, projectileSpeed;
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

    public void setPrice(int price) {
        this.price = price;
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

    public void setID(int ID) {
        this.ID = ID;
    }

    /*Tower(Tower model){
        this.position.set(model.position);
        this.damage = model.damage;
        this.debuff = new Debuff(model.debuff);
        this.range = model.range;
        this.projectileSpeed = model.projectileSpeed;
        this.cost = model.cost;
        this.fireRate = model.fireRate;
        this.ID = model.ID;
        this.projectileSize = model.projectileSize;
        this.projectileColor = model.projectileColor.cpy();
    }*/

//    Tower(float x, float y, int ID){
//        this.position.x = x + 15;
//        this.position.y = y + 15;
//        setToTower(ID);
//    }
//
//    public void setToTower(int ID) {
//        this.ID = ID;
//        if (ID == 1) {
//            damage = 25;
//            debuff.damage = 0;
//            debuff.duration = 60;
//            debuff.speedmulti = 1;
//            projectileSpeed = 5;
//            //fireRate = 0.5f;
//            range = 300;
//            //projectileColor.set(Color.RED);
//            //projectileSize = 3;
//        } else if (ID == 2) {
//            damage = 0;
//            debuff.damage = 0.05f;
//            debuff.duration = 60;
//            debuff.speedmulti = 0.2f;
//            projectileSpeed = 1;
//            fireRate = 1;
//            range = 150;
//            //projectileColor.set(Color.CYAN);
//            //projectileSize = 5;
//        } else if (ID == 3) {
//            damage = 0;
//            debuff.damage = 0.2f;
//            debuff.duration = 60;
//            debuff.speedmulti = 0.7f;
//            //projectileSpeed = 1f;
//            fireRate = 30;
//            range = 100;
//            //projectileColor.set(Color.ORANGE);
//            //projectileSize = 8;
//        } else if (ID == 4) {
//            //damage = 0.5f;
//            debuff.damage = 0.05f;
//            debuff.duration = 60;
//            debuff.speedmulti = 0.7f;
//            projectileSpeed = 10;
//            fireRate = 30;
//            range = 300;
//            //projectileColor.set(Color.YELLOW);
//            //projectileSize = 2;
//        } else if (ID == 5) {
//            damage = 0;
//            debuff.damage = 0f;
//            debuff.duration = 600;
//            debuff.speedmulti = 0f;
//            //projectileSpeed = 2f;
//            //fireRate = 0.3f;
//            range = 1000;
//            //projectileColor.set(Color.YELLOW);
//        }


}
