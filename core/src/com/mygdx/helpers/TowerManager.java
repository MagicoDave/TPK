package com.mygdx.helpers;

import com.mygdx.actors.towers.Bullet;
import com.mygdx.actors.towers.Tower;
import com.mygdx.gameworld.World;

public class TowerManager {

    private World world;

    public TowerManager(World world){
        this.world = world;
    }

    public void update(float delta){
        for (Tower tower : world.constructedTowers) {
            tower.adquireTarget();
            tower.fire();
        }


        for (Bullet bullet : world.bulletsInScreen) {
            bullet.update(delta);
        }


    }
}
