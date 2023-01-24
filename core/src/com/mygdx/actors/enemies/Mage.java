package com.mygdx.actors.enemies;

import com.mygdx.gameworld.World;
import com.mygdx.helpers.Stats;

/**
 * Esta clase establece propiedades para el Enemy Mage
 */
public class Mage extends Enemy{
    public Mage(World world) {
        super(world);

        this.ID = 2;
        this.hp = Stats.MAGE.hp;
        this.damage = Stats.MAGE.damage;
        this.speed = Stats.MAGE.speed;
        this.reward = Stats.MAGE.reward;
    }
}
