package com.mygdx.helpers;

import com.mygdx.actors.enemies.Enemy;
import com.mygdx.gameworld.World;

public class EnemyManager {

    private World world;

    public EnemyManager(World world){
        this.world = world;
    }

    public void update(float delta){
        for (Enemy enemy : world.enemiesInScreen) {
            enemy.move(delta);
        }
    }
}
