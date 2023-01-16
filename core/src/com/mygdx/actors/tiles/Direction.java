package com.mygdx.actors.tiles;

public enum Direction {
    DOWN("DOWN",0,-1),
    RIGHT("RIGHT",1,0),
    UP("UP",0,1),
    LEFT("LEFT",-1,0);

    private final String value;
    private final int addToX, addToY;

    Direction(String value, int addToX, int addToY) {
        this.value = value;
        this.addToX = addToX;
        this.addToY = addToY;
    }

    public String getValue() {
        return value;
    }

    public int getAddToX() {
        return addToX;
    }

    public int getAddToY() {
        return addToY;
    }
}
