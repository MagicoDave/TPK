package com.mygdx.actors.enemies;

import com.mygdx.gameworld.World;
import com.mygdx.helpers.Stats;

public class Barbarian extends Enemy{
    public Barbarian(World world) {
        super(world);

        this.hp = Stats.BARBARIAN.hp;
        this.damage = Stats.BARBARIAN.damage;
        this.speed = Stats.BARBARIAN.speed;
        this.reward = Stats.BARBARIAN.reward;
    }
}
