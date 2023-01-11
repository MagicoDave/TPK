package com.mygdx.actors.enemies;

import com.badlogic.gdx.math.Vector2;

/**
 * Enemy
 *
 * Esta clase abstracta contiene las propiedades comunes de todos los enemigos
 */
public abstract class Enemy {

    private Vector2 position = new Vector2();
    int ID;
    float damage;
    float hp;
    float speed;
    float reward;
    boolean isAlive;
}
