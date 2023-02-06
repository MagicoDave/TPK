package com.mygdx.actors.tiles;


import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.actors.towers.Tower;

public class Tile extends Actor {

    private Direction direction;
    private Type type;
    private Rectangle hitbox;

    private Tower tower;

    private boolean isPressed;

    public Tile(Direction direction, Type type, Rectangle hitbox) {
        this.direction = direction;
        this.type = type;
        this.hitbox = hitbox;

        tower = null;

        isPressed = false;
    }

    public boolean isTouchDown(float screenX, float screenY) {
        if (hitbox.contains(screenX, screenY)) {
            isPressed = true;
            return true;
        }
        return false;
    }

    public boolean isTouchUp(float screenX, float screenY) {
        if (hitbox.contains(screenX, screenY) /*&& isPressed*/) {
            isPressed = false;
            return true;
        }

        isPressed = false;
        return false;
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
