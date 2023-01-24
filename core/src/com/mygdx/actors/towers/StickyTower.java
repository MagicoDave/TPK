package com.mygdx.actors.towers;

import static com.mygdx.helpers.Stats.STICKY_TOWER;

import com.mygdx.actors.tiles.Tile;
import com.mygdx.gameworld.World;

/**
 * Esta clase gestiona las propiedades de la Tower StickyTower
 */
public class StickyTower extends Tower{
    public StickyTower(World world, Tile fundation) {
        super(world, fundation);

        this.ID = 2;
        this.damage = STICKY_TOWER.damage;
        this.range = STICKY_TOWER.range;
        this.price = STICKY_TOWER.price;
        this.fireRate = STICKY_TOWER.fireRate;
        this.projectileSpeed = STICKY_TOWER.projectileSpeed;
        this.debuff = STICKY_TOWER.debuff;
    }
}
