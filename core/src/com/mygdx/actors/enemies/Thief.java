package com.mygdx.actors.enemies;

import com.mygdx.gameworld.World;
import com.mygdx.helpers.Stats;

/**
 * Esta clase establece propiedades para el Enemy Thief
 */
public class Thief extends Enemy{
    /**
     * Inicializa un Enemy de tipo Thief con stats por defecto
     * @param world referencia del nivel
     * @param spawn referencia de la ubicación de spawn en el mapa
     */
    public Thief(World world, int spawn) {
        super(world, spawn);

        this.ID = 3;
        this.hp = Stats.THIEF.hp;
        this.damage = Stats.THIEF.damage;
        this.speed = Stats.THIEF.speed;
        this.reward = Stats.THIEF.reward;
    }
}
