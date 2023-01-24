package com.mygdx.actors.towers;

public enum Debuff {
    SLOW("SLOW", 3, 0, 2),
    FIRE("FIRE", 4, 1, 1);

    private final String value;
    private final int duration, damage, speedDivider;


    Debuff(String value, int duration, int damage, int speedDivider){
        this.value = value;
        this.duration = duration;
        this.damage = damage;
        this.speedDivider = speedDivider;
    }
}
