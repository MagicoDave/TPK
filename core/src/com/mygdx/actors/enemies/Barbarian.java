package com.mygdx.actors.enemies;

import com.mygdx.gameworld.World;
import com.mygdx.helpers.Stats;

/**
 * Esta clase establece propiedades para el Enemy Barbarian
 */
public class Barbarian extends Enemy{
    /**
     * Inicializa un Enemy de tipo Barbarian con stats por defecto
     * @param world referencia del nivel
     * @param spawn referencia de la ubicación de spawn en el mapa
     */
    public Barbarian(World world, int spawn) {
        super(world, spawn);

        this.ID = 1;
        this.hp = Stats.BARBARIAN.hp;
        this.damage = Stats.BARBARIAN.damage;
        this.speed = Stats.BARBARIAN.speed;
        this.reward = Stats.BARBARIAN.reward;
    }
}
