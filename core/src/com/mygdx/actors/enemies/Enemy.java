package com.mygdx.actors.enemies;

import static com.mygdx.helpers.Stats.BASE_ENEMY_SPEED;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.mygdx.actors.tiles.Direction;
import com.mygdx.actors.tiles.Tile;
import com.mygdx.gameworld.World;

/**
 * Enemy
 *
 * Esta clase abstracta contiene las propiedades comunes de todos los enemigos
 */
public abstract class Enemy extends Image {

    protected World world;

    private Vector2 position = new Vector2(); //Como determinamos posición?
    Direction direction;

    int ID, hp, damage, speed, reward;

    private Rectangle hitbox;

    boolean isAlive;

    public Enemy(World world){
        super();

        this.world = world;

        //this.position =
        this.direction = Direction.DOWN;

        this.hitbox = new Rectangle();

        this.ID = ID;
        this.damage = damage;
        this.hp = hp;
        this.speed = speed;
        this.reward = reward;

        isAlive = true;
    }

    public void move(float delta){
        switch (direction){
            case UP:
                this.setY(this.getY() + (BASE_ENEMY_SPEED * speed * delta));
                break;
            case DOWN:
                this.setY(this.getY() + (-BASE_ENEMY_SPEED * speed * delta));
                break;
            case LEFT:
                position.x += -10 * delta;
                this.setX(this.getX() + (-BASE_ENEMY_SPEED * speed * delta));
                break;
            case RIGHT:
                position.x += 10 * delta;
                this.setX(this.getX() + (BASE_ENEMY_SPEED * speed * delta));
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
            // Hacer que desaparezca
        }
    }

    public Vector2 getCenter(){
        return new Vector2(this.getX() + this.getWidth() / 2, this.getY() + this.getHeight() / 2);
    }

}
