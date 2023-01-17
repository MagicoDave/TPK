package com.mygdx.actors.enemies;

import com.mygdx.gameworld.World;
import com.mygdx.helpers.Stats;

public class Mage extends Enemy{
    public Mage(World world) {
        super(world);

        this.hp = Stats.MAGE.hp;
        this.damage = Stats.MAGE.damage;
        this.speed = Stats.MAGE.speed;
        this.reward = Stats.MAGE.reward;
    }
}
