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

        this.position = new Vector2();
        this.position.x = tower.getX() + (tower.getWidth() / 2);
        this.position.y = tower.getY() + (tower.getHeight() / 2);
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
            alive = false;
        }
    }

    public void fly(float delta){
        if (this.position.dst(target.getCenter()) <= speed && alive) {
            target.setDebuff(debuff);
            target.setHp(target.getHp() - damage);
            this.alive = false;
        } else {
            moveVec.set(BASE_BULLET_SPEED * speed * delta, 0);
            moveVec.setAngleRad((float) Math.atan2(target.getCenter().y - this.position.y, target.getCenter().x - this.position.x));
            position.add(moveVec);
        }
    }

    public Vector2 getPosition() {
        return position;
    }

    public boolean isAlive() {
        return alive;
    }
}
