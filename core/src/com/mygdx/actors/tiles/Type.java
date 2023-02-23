package com.mygdx.actors.tiles;

/**
 * Enumerado del tipo de Tiles existentes
 */
public enum Type {
    SPAWN("SPAWN"), //Punto de aparicion de los enemigos
    ROAD("ROAD"), //Punto de colisión/giro para los enemigos
    FINISH_LINE("FINISH_LINE"), //Punto de llegada para los enemigos
    FUNDATION("FUNDATION"); //Ubicación de construcción de torres

    private final String value;

    Type(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
