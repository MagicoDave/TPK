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
    public static int START_GOLD = 50;
    public static int STAR_LOOT = 0;
    public static int START_MULTIPLIER = 1;
    public static int START_SCORE = 0;

    public static int RAGE_PRICE = 50;

    public static int BASE_ENEMY_SPEED = 10;
    public static int BASE_BULLET_SPEED = 10;

    public static int TIME_BETWEEN_SPAWNS = 2;

    //Waves
    public static int[] LEVEL_1_WAVE = {0,0,0,0,1,1,0,0,1,1,2,2,0,0,2,3,3,3,0,0,1,1,1,1,3,3,3,0,2,2,2,2,1,1};

    //Enemies
    public static EnemyStats FARMER = new EnemyStats(4, 1, 1, 1); //ID: 0
    public static EnemyStats BARBARIAN = new EnemyStats(15, 2, 1, 5); //ID: 1
    public static EnemyStats THIEF = new EnemyStats(6, 3, 2, 3); //ID: 2
    public static EnemyStats MAGE = new EnemyStats(4, 5, 1, 4); //ID: 3

    //Towers
    public static TowerStats ARROW_TOWER = new TowerStats(1, 64, 10, 100, 6, null); //ID: 0
    public static TowerStats WITCH_TOWER = new TowerStats(4, 48, 20, 200, 5, null); //ID: 1
    public static TowerStats STICKY_TOWER = new TowerStats(1, 32, 15, 150, 5, Debuff.SLOW); //ID: 2
    public static TowerStats CYCLOP_TOWER = new TowerStats(8, 80, 30, 400, 4, null); //ID: 3

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
