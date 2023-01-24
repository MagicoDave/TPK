package com.mygdx.actors.towers;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.mygdx.actors.enemies.Enemy;
import com.mygdx.gameworld.World;

public class Bullet extends Image {

    private World world;
    private Tower tower;
    private Enemy target;

    private Vector2 position;
    private Vector2 moveVec;
    private int damage, speed;
    private Debuff debuff;

    public Bullet (World world, Tower tower, Enemy target){
        super();

        this.tower = tower;
        this.target = target;

        this.position = tower.getPosition();
        this.damage = tower.getDamage();
        this.speed = tower.getProjectileSpeed();
        this.debuff = tower.getDebuff();

    }

    public void update(){
        if (target.isAlive()){
            fly();
        } else {
            world.bulletsInScreen.removeValue(this, true);
        }
    }

    public void fly(){
        if (this.position.dst(target.getCenter()) <= speed){
            target.setDebuff(debuff);
            target.setHp(target.getHp() - damage);
        } else {
            moveVec.set(speed, 0);
            moveVec.setAngleRad((float) Math.atan2(target.getCenter().y - this.position.y, target.getCenter().x - this.position.x));
            position.add(moveVec);
        }
    }
}
