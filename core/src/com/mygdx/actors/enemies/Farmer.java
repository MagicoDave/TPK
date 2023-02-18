package com.mygdx.actors.enemies;

import com.mygdx.gameworld.World;
import com.mygdx.helpers.Stats;

/**
 * Esta clase establece propiedades para el Enemy Farmer
 */
public class Farmer extends Enemy{

    public Farmer(World world, int spawn) {
        super(world, spawn);

        this.ID = 0;
        this.hp = Stats.FARMER.hp;
        this.damage = Stats.FARMER.damage;
        this.speed = Stats.FARMER.speed;
        this.reward = Stats.FARMER.reward;
    }
}
