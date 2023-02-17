package com.mygdx.actors.enemies;

import com.mygdx.gameworld.World;
import com.mygdx.helpers.Stats;

/**
 * Esta clase establece propiedades para el Enemy Thief
 */
public class Thief extends Enemy{

    public Thief(World world, int spawn) {
        super(world, spawn);

        this.ID = 3;
        this.hp = Stats.THIEF.hp;
        this.damage = Stats.THIEF.damage;
        this.speed = Stats.THIEF.speed;
        this.reward = Stats.THIEF.reward;
    }
}
