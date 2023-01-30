package com.mygdx.helpers;

import com.badlogic.gdx.utils.Array;
import com.mygdx.actors.enemies.Barbarian;
import com.mygdx.actors.enemies.Enemy;
import com.mygdx.actors.enemies.Farmer;
import com.mygdx.actors.enemies.Mage;
import com.mygdx.actors.enemies.Thief;
import com.mygdx.gameworld.World;

/**
 * Esta clase gestiona la aparición de oleadas en el nivel
 */
public class WaveManager {

    private World world;
    private Array<Enemy> array;

    public WaveManager(World world, int[] wave){
        this.world = world;
        setWave(wave);
    }

    /**
     * Spawnea el siguente enemigo de la oleada al nivel
     */
    public void spawn(){
        if (array.size > 0){
            this.world.enemiesInScreen.add(array.first());
            array.removeIndex(0);
        }

    }

    public Array<Enemy> getWave() {
        return array;
    }

    /**
     * Establece la oleada (wave)
     * @param wave Un array de ints con las referencias del tipo de cada enemigo de la oleada. Consultar Stats para ver las referencias (ID)
     */
    public void setWave(int[] wave) {

        array = new Array<Enemy>();

        for (int i = 0; i < wave.length; i++) {
            switch (wave[i]) {
                case 0:
                    array.add(new Farmer(world));
                    break;
                case 1:
                    array.add(new Barbarian(world));
                    break;
                case 2:
                    array.add(new Mage(world));
                    break;
                case 3:
                    array.add(new Thief(world));
                    break;
            }
        }
    }
}
