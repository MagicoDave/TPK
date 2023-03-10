package com.mygdx.actors.towers;

import static com.mygdx.helpers.Stats.WITCH_TOWER;

import com.mygdx.actors.tiles.Tile;
import com.mygdx.gameworld.World;
import com.mygdx.helpers.AssetLoader;

/**
 * Esta clase gestiona las propiedades de la Tower WitchTower
 */
public class WitchTower extends Tower{

    /**
     * Crea una nueva WitchTower con los valores predeterminados
     * @param world Referencia del nivel
     * @param fundation Fundation en la cual se construye la torre
     */
    public WitchTower(World world, Tile fundation) {
        super(world, fundation);

        this.ID = 1;
        this.damage = WITCH_TOWER.damage;
        this.range = WITCH_TOWER.range;
        this.price = WITCH_TOWER.price;
        this.fireRate = WITCH_TOWER.fireRate;
        this.projectileSpeed = WITCH_TOWER.projectileSpeed;
        this.debuff = WITCH_TOWER.debuff;
    }
}
