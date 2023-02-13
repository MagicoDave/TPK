package com.mygdx.helpers;

import com.mygdx.actors.towers.Bullet;
import com.mygdx.actors.towers.Tower;
import com.mygdx.gameworld.World;

/**
 * Gestiona el comportamiento de las torres y las balas
 */
public class TowerManager {

    private World world;

    public TowerManager(World world){
        this.world = world;
    }

    public void update(float delta){

        //Borrar balas 'muertas'
        for (int i = 0; i < world.bulletsInScreen.size; i++) {
            Bullet e = world.bulletsInScreen.get(i);
            if (!e.isAlive()) {
                world.bulletsInScreen.removeIndex(i);
                i--;
            }
        }

        //Actualizar torres
        for (Tower tower : world.constructedTowers) {
            tower.update(delta);
        }

        //Actualizar balas
        for (Bullet bullet : world.bulletsInScreen) {
            bullet.update(delta);
        }
        
    }
}
