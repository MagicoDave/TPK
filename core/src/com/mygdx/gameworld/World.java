package com.mygdx.gameworld;

import static com.mygdx.helpers.Stats.LEVEL_1_WAVE;
import static com.mygdx.helpers.Stats.START_GOLD;
import static com.mygdx.helpers.Stats.START_HEALTH;
import static com.mygdx.helpers.Stats.START_SCORE;
import static com.mygdx.helpers.Stats.TIME_BETWEEN_SPAWNS;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.mygdx.actors.enemies.Enemy;
import com.mygdx.actors.tiles.Tile;
import com.mygdx.actors.towers.Bullet;
import com.mygdx.actors.towers.Tower;
import com.mygdx.helpers.EnemyManager;
import com.mygdx.helpers.LevelCreator;
import com.mygdx.helpers.TowerManager;
import com.mygdx.helpers.WaveManager;
import com.mygdx.ui.GameUi;


/**
 * Esta clase gestiona las reglas del juego en sí
 */
public class World extends Stage {

    public int score, lifes, gold;

    private float runTime = 0; // runTime lleva la cuenta del tiempo que un objeto lleva en una animación determinada

    private GameState currentState;
    public enum GameState{
        READY, RUNNING, GAMEOVER, VICTORY, HIGHSCORE
    }

    EnemyManager enemyManager;
    WaveManager waveManager;
    TowerManager towerManager;

    public Array<Enemy> enemiesInScreen = new Array<Enemy>();
    public Array<Tower> constructedTowers = new Array<Tower>();
    public Array<Bullet> bulletsInScreen = new Array<Bullet>();

    public Tile spawnPoint;
    public Tile finishPoint;
    public Array<Tile> roadTiles;
    public Array<Tile> fundationTiles;

    float timeSinceLastSpawn = 0;

    public World(LevelCreator levelCreator){

        score = START_SCORE;
        lifes = START_HEALTH;
        gold = START_GOLD;

        spawnPoint = levelCreator.getSpawnTile();
        finishPoint = levelCreator.getFinishTile();
        roadTiles = levelCreator.getDirectionTiles();
        fundationTiles = levelCreator.getFundationTiles();

        currentState = GameState.READY;

        enemyManager = new EnemyManager(this);
        waveManager = new WaveManager(this, LEVEL_1_WAVE);
        towerManager = new TowerManager(this);

    }

    /**
     * Actualiza el juego según su estado (@currentState)
     * @param delta Tasa de refresco
     */
    public void update(float delta){

        runTime += delta;

        switch (currentState) {
            case READY:
                break;
            case RUNNING:
                timeSinceLastSpawn += delta;
                enemyManager.update(delta);
                towerManager.update(delta);
                if (timeSinceLastSpawn >= TIME_BETWEEN_SPAWNS){
                    waveManager.spawn();
                    timeSinceLastSpawn = 0;
                }
                if (lifes <= 0){
                    currentState = GameState.GAMEOVER;
                }
                if (waveManager.isEmpty() && enemiesInScreen.isEmpty()){
                    currentState = GameState.VICTORY;
                }
                break;
            case GAMEOVER:
            case VICTORY:
            case HIGHSCORE:
            default:
                break;
        }
    }

    public GameState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(GameState currentState) {
        this.currentState = currentState;
    }

    public boolean isReady() {
        return currentState == GameState.READY;
    }

    public boolean isGameOver() {
        return currentState == GameState.GAMEOVER;
    }

    public boolean isRunning() {
        return currentState == GameState.RUNNING;
    }

    public boolean isHighScore() {
        return currentState == GameState.HIGHSCORE;
    }

    public void start() {
        currentState = GameState.RUNNING;
    }
}
