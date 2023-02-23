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

    /**
     * Vidas iniciales
     */
    public static int START_HEALTH = 20;

    /**
     * Oro inicial
     */
    public static int START_GOLD = 50;

    /**
     * Puntuación incial
     */
    public static int START_SCORE = 0;

    /**
     * Coste del Rage
     */
    public static int RAGE_PRICE = 10;

    /**
     * Duración del Rage
     */
    public static int RAGE_DURATION = 5;

    /**
     * Velocidad base de los enemigos
     */
    public static int BASE_ENEMY_SPEED = 10;

    /**
     * Velocidad base de los proyectiles
     */
    public static int BASE_BULLET_SPEED = 10;

    /**
     * Tiempo que pasa entre que aparece un enemigo y el siguiente
     */
    public static int TIME_BETWEEN_SPAWNS = 2;

    /**
     * Aceleración mínima para detectar si se ha agitado el móvil
     */
    public static int SHAKE_THRESHOLD = 15;

    /**
     * Volumen de la música
     */
    public static float MUSIC_VOLUME;

    /**
     * Volumen del sonido
     */
    public static float SOUND_VOLUME;

    //Waves
    public static int[] LEVEL_1_WAVE = {0,0,0,0,1,1,0,0,1,1,2,2,0,0,2,3,3,3,0,0,1,1,1,1,3,3,3,0,2,2,2,2,1,1};
    public static int[] LEVEL_2_WAVE = {0,0,0,2,3,3,0,0,0,2,1,1,1,2,3,3,1,1,1,2,3,3,0,0,0,2,0,0,0,2,3,3,1,1,1,2};
    public static int[] LEVEL_3_WAVE = {0,0,0,3,3,1,2,2,1,0,0,0,3,3,1,2,2,1,0,0,0,3,3,1,2,2,1,0,0,0,3,3,1,2,2,1,0,0,0,3,3,1,2,2,1};
    public static int[] LEVEL_4_WAVE = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};

    //Enemies
    public static EnemyStats FARMER = new EnemyStats(4, 1, 1, 1); //ID: 0
    public static EnemyStats BARBARIAN = new EnemyStats(15, 2, 1, 5); //ID: 1
    public static EnemyStats MAGE = new EnemyStats(4, 5, 1, 4); //ID: 2
    public static EnemyStats THIEF = new EnemyStats(6, 3, 2, 3); //ID: 3

    //Towers
    public static TowerStats ARROW_TOWER = new TowerStats(1, 64, 10, 100, 6, null); //ID: 0
    public static TowerStats WITCH_TOWER = new TowerStats(4, 48, 20, 200, 5, null); //ID: 1
    public static TowerStats STICKY_TOWER = new TowerStats(1, 48, 15, 150, 5, Debuff.SLOW); //ID: 2
    public static TowerStats CYCLOP_TOWER = new TowerStats(8, 80, 30, 300, 4, null); //ID: 3

    /**
     * Esta clase hace de plantilla para almacenar las estadísticas de los enemigos
     */
    public static class EnemyStats {
        public int hp, damage, speed, reward;

        /**
         * Construye una nueva plantilla de estadísticas para un enemigo a partir de parámetros
         * @param hp Vida
         * @param damage Daño
         * @param speed Multiplicador de velocidad
         * @param reward Cantidad de oro al morir
         */
        public EnemyStats(int hp, int damage, int speed, int reward){
            this.hp = hp;
            this.damage = damage;
            this.speed = speed;
            this.reward = reward;
        }
    }

    /**
     * Esta clase hace de plantilla para almacenar las estadísticas de las torres
     */
    public static class TowerStats {
        public int damage, range, price, fireRate, projectileSpeed;
        public Debuff debuff;

        /**
         * Construye una nueva plantilla de estadísticas para una torre a partir de parámetros
         * @param damage Daño
         * @param range Alcance
         * @param price Precio de construcción
         * @param fireRate Frecuencia de disparo
         * @param projectileSpeed Velocidad de proyectil
         * @param debuff Si aplica algún debuff
         */
        public TowerStats(int damage, int range, int price, int fireRate, int projectileSpeed, Debuff debuff){
            this.damage = damage;
            this.range = range;
            this.price = price;
            this.fireRate = fireRate;
            this.projectileSpeed = projectileSpeed;
            this.debuff = debuff;
        }
    }

    /**
     * Silencia o vuelve a dar volumen a la música
     * @param on true - con volumen; false - silenciado
     * @return El volumen de la música (0 para silenciar)
     */
    public static float musicOn(boolean on){
        if (on){
            MUSIC_VOLUME = 1.0f;
        } else {
            MUSIC_VOLUME = 0.0f;
        }
        return MUSIC_VOLUME;
    }

    /**
     * Silencia o vuelve a dar volumen a los efectos de sonido
     * @param on true - con volumen; false - silenciado
     * @return El volumen de la música (0 para silenciar)
     */
    public static float soundOn(boolean on){
        if (on){
            SOUND_VOLUME = 0.5f;
        } else {
            SOUND_VOLUME = 0.0f;
        }
        return SOUND_VOLUME;
    }
}
