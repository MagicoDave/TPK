package com.mygdx.actors.towers;

import static com.mygdx.helpers.Stats.ARROW_TOWER;

import com.mygdx.actors.tiles.Tile;
import com.mygdx.gameworld.World;
import com.mygdx.helpers.AssetLoader;

/**
 * Esta clase gestiona las propiedades de la Tower Arrowtower
 */
public class ArrowTower extends Tower{
    public ArrowTower (World world, Tile fundation){
        super(world, fundation);

        this.ID = 0;
        this.damage = ARROW_TOWER.damage;
        this.range = ARROW_TOWER.range;
        this.price = ARROW_TOWER.price;
        this.fireRate = ARROW_TOWER.fireRate;
        this.projectileSpeed = ARROW_TOWER.projectileSpeed;
        this.debuff = ARROW_TOWER.debuff;
    }
}
