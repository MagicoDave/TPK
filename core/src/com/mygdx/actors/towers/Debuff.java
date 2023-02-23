package com.mygdx.actors.towers;

/**
 * Esta clase gestiona los efectos especiales que pueden sufrir los enemigos
 */
public enum Debuff {
    SLOW("SLOW", 6, 0, 2), //Ralentiza a los enemigos
    FIRE("FIRE", 4, 1, 1); //Hace daño cada segundo mientras dura (Idea de futuro, no implementado)

    private final String value;
    private final int duration, damage, speedDivider;

    /**
     * Inicializa un nuevo debuff a parámetros
     * @param value Tipo de debuff (SLOW o FIRE)
     * @param duration La duración en segundos del debuff
     * @param damage El daño cada segundo (si tiene)
     * @param speedDivider El valor por el cual se divide la velocidad del enemigo (Por 1 si no hay ralentización)
     */
    Debuff(String value, int duration, int damage, int speedDivider){
        this.value = value;
        this.duration = duration;
        this.damage = damage;
        this.speedDivider = speedDivider;
    }

    public String getValue() {
        return value;
    }

    public int getDuration() {
        return duration;
    }

    public int getDamage() {
        return damage;
    }

    public int getSpeedDivider() {
        return speedDivider;
    }
}
