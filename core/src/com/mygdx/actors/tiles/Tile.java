package com.mygdx.actors.tiles;


import com.badlogic.gdx.math.Rectangle;
import com.mygdx.actors.towers.Tower;

public class Tile {

    private Direction direction;
    private Type type;
    private Rectangle hitbox;

    private Tower tower;

    public Tile(Direction direction, Type type, Rectangle hitbox) {
        this.direction = direction;
        this.type = type;
        this.hitbox = hitbox;

        tower = null;
    }

    public void onClick(){
        if (type == Type.FUNDATION && tower == null){
            
        }

        if (type == Type.FUNDATION && tower != null){

        }
    }

    public Direction getDirection() {
        return direction;
    }

    public Type getType() {
        return type;
    }

    public Rectangle getHitbox() {
        return hitbox;
    }

    public void setHitbox(Rectangle hitbox) {
        this.hitbox = hitbox;
    }

    public boolean isFundation() {
        if (type == Type.FUNDATION){
            return true;
        } else {
            return false;
        }
    }

    public Tower getTower() {
        return tower;
    }

    public void setTower(Tower tower) {
        this.tower = tower;
    }
}
