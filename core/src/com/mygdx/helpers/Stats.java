package com.mygdx.helpers;

import com.badlogic.gdx.utils.Array;
import com.mygdx.actors.enemies.Barbarian;
import com.mygdx.actors.enemies.Enemy;
import com.mygdx.actors.enemies.Farmer;
import com.mygdx.actors.enemies.Mage;
import com.mygdx.actors.enemies.Thief;
import com.mygdx.actors.towers.Debuff;

import java.util.HashMap;

/**
 * Clase que almacena diversas constantes del juego para fácil acceso
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
    public static int BASE_BULLET_SPEED = 10;

    public static int TIME_BETWEEN_SPAWNS = 2;

    //Enemies and Tower ID reference:
    //
    //FARMER = 0
    //BARBARIAN = 1
    //THIEF = 2
    //MAGE = 3
    //
    //ARROW_TOWER = 0
    //WITCH_TOWER = 1
    //STICKY_TOWER = 2
    //CYCLOP_TOWER = 3

    //Waves
    public static int[] LEVEL_1_WAVE = {0,1,2,3};

    //Enemies
    public static EnemyStats FARMER = new EnemyStats(4, 1, 1, 1);
    public static EnemyStats BARBARIAN = new EnemyStats(15, 2, 1, 5);
    public static EnemyStats THIEF = new EnemyStats(6, 3, 2, 3);
    public static EnemyStats MAGE = new EnemyStats(4, 5, 1, 4);

    //Towers
    public static TowerStats ARROW_TOWER = new TowerStats(1, 64, 10, 300, 3, null);
    public static TowerStats WITCH_TOWER = new TowerStats(3, 64, 20, 2, 10, Debuff.FIRE);
    public static TowerStats STICKY_TOWER = new TowerStats(0, 64, 10, 2, 10, Debuff.SLOW);
    public static TowerStats CYCLOP_TOWER = new TowerStats(6, 64, 30, 1, 8, null);

    //Constructor EnemyStats
    public static class EnemyStats {
        public int hp, damage, speed, reward;

        public EnemyStats(int hp, int damage, int speed, int reward){
            this.hp = hp;
            this.damage = damage;
            this.speed = speed;
            this.reward = reward;
        }
    }

    //Constructor TowerStats
    public static class TowerStats {
        public int damage, range, price, fireRate, projectileSpeed;
        public Debuff debuff;

        public TowerStats(int damage, int range, int price, int fireRate, int projectileSpeed, Debuff debuff){
            this.damage = damage;
            this.range = range;
            this.price = price;
            this.fireRate = fireRate;
            this.projectileSpeed = projectileSpeed;
            this.debuff = debuff;
        }
    }
}
