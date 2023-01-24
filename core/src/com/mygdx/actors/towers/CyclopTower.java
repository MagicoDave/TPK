package com.mygdx.actors.towers;

import static com.mygdx.helpers.Stats.CYCLOP_TOWER;

import com.mygdx.actors.tiles.Tile;
import com.mygdx.gameworld.World;

/**
 * Esta clase gestiona las propiedades de la Tower CyclopTower
 */
public class CyclopTower extends Tower{
    public CyclopTower(World world, Tile fundation) {
        super(world, fundation);

        this.ID = 3;
        this.damage = CYCLOP_TOWER.damage;
        this.range = CYCLOP_TOWER.range;
        this.price = CYCLOP_TOWER.price;
        this.fireRate = CYCLOP_TOWER.fireRate;
        this.projectileSpeed = CYCLOP_TOWER.projectileSpeed;
        this.debuff = CYCLOP_TOWER.debuff;
    }
}
