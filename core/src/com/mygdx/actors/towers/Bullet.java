package com.mygdx.actors.towers;

import static com.mygdx.helpers.Stats.BASE_BULLET_SPEED;

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
    private boolean alive;

    public Bullet (World world, Tower tower, Enemy target){
        super();

        this.world = world;
        this.tower = tower;
        this.target = target;

        this.position = tower.getPosition();
        this.setBounds(this.position.x, this.position.y, 12, 12);

        this.moveVec = new Vector2();
        this.damage = tower.getDamage();
        this.speed = tower.getProjectileSpeed();
        this.debuff = tower.getDebuff();

        this.alive = true;

    }

    public void update(float delta){
        if (target.isAlive()){
            fly(delta);
        } else {
            world.bulletsInScreen.removeValue(this, true);
        }
    }

    public void fly(float delta){
        if (this.position.dst(target.getCenter()) <= speed && this.alive) {
            target.setDebuff(debuff);
            target.setHp(target.getHp() - damage);
            this.alive = false;
        } else if (!alive) {
            world.bulletsInScreen.removeValue(this, true);
        } else {
            moveVec.set(BASE_BULLET_SPEED * speed * delta, 0);
            moveVec.setAngleRad((float) Math.atan2(target.getCenter().y - this.position.y, target.getCenter().x - this.position.x));
            position.add(moveVec);
        }
    }
}
