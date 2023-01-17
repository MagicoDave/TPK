package com.mygdx.actors.tiles;


import com.badlogic.gdx.math.Rectangle;

public class Tile {

    private Direction direction;
    private Type type;
    private Rectangle hitbox;

    public Tile(Direction direction, Type type, Rectangle hitbox) {
        this.direction = direction;
        this.type = type;
        this.hitbox = hitbox;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Rectangle getHitbox() {
        return hitbox;
    }

    public void setHitbox(Rectangle hitbox) {
        this.hitbox = hitbox;
    }
}
