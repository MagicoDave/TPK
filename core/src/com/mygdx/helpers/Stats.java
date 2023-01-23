package com.mygdx.helpers;

import com.badlogic.gdx.utils.Array;
import com.mygdx.actors.enemies.Barbarian;
import com.mygdx.actors.enemies.Enemy;
import com.mygdx.actors.enemies.Farmer;
import com.mygdx.actors.enemies.Mage;
import com.mygdx.actors.enemies.Thief;

import java.util.HashMap;

/**
 * Clase que almacena diversas constantes del juego
 */
public class Stats {

    public static int START_HEALTH = 20;
    public static int START_GOLD = 0;
    public static int STAR_LOOT = 0;
    public static int START_MULTIPLIER = 1;
    public static int START_SCORE = 0;

    public static int BOOST_PRICE = 50;
    public static int POISON_PRICE = 30;

    public static int BASE_ENEMY_SPEED = 10;

    public static int TIME_BETWEEN_SPAWNS = 2;

    //Waves
    public static int[] LEVEL_1_WAVE = {0,0,0,1,2,3};

    //Enemies
    public static EnemyStats FARMER = new EnemyStats(4, 1, 1, 1);
    public static EnemyStats BARBARIAN = new EnemyStats(15, 2, 1, 5);
    public static EnemyStats THIEF = new EnemyStats(6, 3, 2, 3);
    public static EnemyStats MAGE = new EnemyStats(4, 5, 1, 4);

    //Towers
    public static TowerStats ARROW_TOWER = new TowerStats();


    /*public static HashMap<Class<? extends Enemy>, EnemyStats> ALL_ENEMY_STATS = new HashMap<>();

    static {
        ALL_ENEMY_STATS.put(Farmer.class, FARMER);
        ALL_ENEMY_STATS.put(Barbarian.class, BARBARIAN);
        ALL_ENEMY_STATS.put(Thief.class, THIEF);
        ALL_ENEMY_STATS.put(Mage.class, MAGE);
    }*/

    public static class EnemyStats {
        public int hp, damage, speed, reward;

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
