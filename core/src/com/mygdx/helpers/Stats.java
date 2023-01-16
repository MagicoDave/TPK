package com.mygdx.helpers;

import com.mygdx.actors.enemies.Enemy;
import com.mygdx.actors.enemies.Farmer;

import java.util.HashMap;

/**
 * Clase que almacena diversas constantes del juego
 */
public class Stats {

    public static int START_HEALTH = 20;
    public static int START_GOLD = 0;

    //Enemies
    public static EnemyStats FARMER = new EnemyStats(10, 1, 1, 1);

    //Towers

    public static HashMap<Class<? extends Enemy>, EnemyStats> ALL_ENEMY_STATS = new HashMap<>();

    static {
        ALL_ENEMY_STATS.put(Farmer.class, FARMER);
    }

    public static class EnemyStats {
        private int hp, damage, speed, reward;

        public EnemyStats(int hp, int damage, int speed, int reward){
            this.hp = hp;
            this.damage = damage;
            this.speed = speed;
            this.reward = reward;
        }
    }


    public static class TowerStats {

    }
}
