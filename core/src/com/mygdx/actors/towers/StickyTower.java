package com.mygdx.actors.towers;

import static com.mygdx.helpers.Stats.STICKY_TOWER;

import com.badlogic.gdx.Gdx;
import com.mygdx.actors.enemies.Enemy;
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

    @Override
    public void adquireTarget(){

        if (world.enemiesInScreen.isEmpty()) return;
        if (target != null){
            Gdx.app.log("tower target in range?: ", target.inRange(this) + "");
        }
        if (target == null || !target.isAlive() || !target.inRange(this)){
            for (Enemy enemy: world.enemiesInScreen) {
                if (enemy.inRange(this) && enemy.getDebuff() == null){
                    target = enemy;
                    Gdx.app.log("New tower target: ", target.toString());
                    return;
                }
            }
            super.adquireTarget();
        }
    }

    @Override
    public void fire(){
        super.fire();
        target = null;
    }
}
