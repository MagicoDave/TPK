package com.mygdx.actors.enemies;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.mygdx.gameworld.World;

/**
 * Enemy
 *
 * Esta clase abstracta contiene las propiedades comunes de todos los enemigos
 */
public abstract class Enemy extends Image {

    protected World world;

    private Vector2 position = new Vector2(); //Como determinamos posición?
    int ID;
    int hp;
    int damage;
    int speed;
    int reward;
    boolean isAlive;

    public Enemy(World world){
        super();
        this.world = world;
        this.ID = ID;
        this.damage = damage;
        this.hp = hp;
        this.speed = speed;
        this.reward = reward;
        isAlive = true;
    }

}
