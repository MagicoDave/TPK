package com.mygdx.actors.enemies;

import com.mygdx.gameworld.World;
import com.mygdx.helpers.Stats;

public class Thief extends Enemy{

    public Thief(World world) {
        super(world);

        this.hp = Stats.THIEF.hp;
        this.damage = Stats.THIEF.damage;
        this.speed = Stats.THIEF.speed;
        this.reward = Stats.THIEF.reward;
    }
}
