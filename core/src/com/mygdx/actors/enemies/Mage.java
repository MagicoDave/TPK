package com.mygdx.actors.enemies;

import com.mygdx.gameworld.World;
import com.mygdx.helpers.Stats;

/**
 * Esta clase establece propiedades para el Enemy Mage
 */
public class Mage extends Enemy{
    /**
     * Inicializa un Enemy de tipo Mage con stats por defecto
     * @param world referencia del nivel
     * @param spawn referencia de la ubicación de spawn en el mapa
     */
    public Mage(World world, int spawn) {
        super(world, spawn);

        this.ID = 2;
        this.hp = Stats.MAGE.hp;
        this.damage = Stats.MAGE.damage;
        this.speed = Stats.MAGE.speed;
        this.reward = Stats.MAGE.reward;
    }
}
