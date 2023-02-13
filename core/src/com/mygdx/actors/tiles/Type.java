package com.mygdx.actors.tiles;

/**
 * Enumerado del tipo de Tiles existentes
 */
public enum Type {
    SPAWN("SPAWN"),
    ROAD("ROAD"),
    FINISH_LINE("FINISH_LINE"),
    FUNDATION("FUNDATION");

    private final String value;

    Type(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
