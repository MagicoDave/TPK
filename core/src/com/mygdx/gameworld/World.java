package com.mygdx.gameworld;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.mygdx.actors.enemies.Enemy;
import com.mygdx.actors.enemies.Farmer;
import com.mygdx.actors.tiles.Tile;
import com.mygdx.helpers.EnemyManager;
import com.mygdx.helpers.LevelCreator;


/**
 * Esta clase gestiona las reglas del juego en sí
 */
public class World extends Stage {

    private int score = 0;

    private float runTime = 0; // runTime lleva la cuenta del tiempo que un objeto lleva en una animación determinada

    private GameState currentState;
    public enum GameState{
        READY, RUNNING, GAMEOVER, HIGHSCORE
    }

    EnemyManager enemyManager;

    public Array<Enemy> enemiesInScreen = new Array<Enemy>();
    public Farmer testDummie;

    private Tile spawnPoint;
    public Tile finishPoint;
    public Array<Tile> roadTiles = new Array<Tile>();

    public World(LevelCreator levelCreator){

        spawnPoint = levelCreator.getSpawnTile();
        finishPoint = levelCreator.getFinishTile();
        roadTiles = levelCreator.getDirectionTiles();

        currentState = GameState.READY;
        testDummie = new Farmer(this);
        testDummie.setBounds(spawnPoint.getHitbox().getX(), spawnPoint.getHitbox().getY(), 16, 16);
        enemiesInScreen.add(testDummie);
        enemyManager = new EnemyManager(this);
    }

    /**
     * Actualiza el juego según su estado
     * @param delta Tasa de refresco
     */
    public void update(float delta){
        runTime += delta;
        enemyManager.update(delta);

        switch (currentState) {
            case READY:
            case RUNNING:
            case GAMEOVER:
            case HIGHSCORE:
            default:
                break;
        }
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
