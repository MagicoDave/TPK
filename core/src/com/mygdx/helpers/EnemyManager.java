package com.mygdx.helpers;

import com.mygdx.actors.enemies.Enemy;
import com.mygdx.gameworld.World;

/**
 * Esta clase gestiona las actualizaciones de estado y comportamiento de los enemigos del nivel
 */
public class EnemyManager {

    private World world;

    /**
     * Constructor de la clase
     * @param world Referencia del nivel
     */
    public EnemyManager(World world){
        this.world = world;
    }

    /**
     * Actualiza (llama al método update) los enemigos en pantalla
     * @param delta Tasa de refresco
     */
    public void update(float delta){
        for (Enemy enemy : world.enemiesInScreen) {
            enemy.update(delta);
        }
    }
}
