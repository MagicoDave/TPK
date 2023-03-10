package com.mygdx.gameworld;

import static com.mygdx.helpers.Stats.LEVEL_1_WAVE;
import static com.mygdx.helpers.Stats.LEVEL_2_WAVE;
import static com.mygdx.helpers.Stats.LEVEL_3_WAVE;
import static com.mygdx.helpers.Stats.LEVEL_4_WAVE;
import static com.mygdx.helpers.Stats.MUSIC_VOLUME;
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
import com.mygdx.helpers.AssetLoader;
import com.mygdx.helpers.EnemyManager;
import com.mygdx.helpers.LevelCreator;
import com.mygdx.helpers.TowerManager;
import com.mygdx.helpers.WaveManager;
import com.mygdx.tpk.TpkGame;


/**
 * Esta clase gestiona el nivel del juego
 */
public class World extends Stage {

    /**
     * Puntuación, vidas, oro y record
     */
    public int score, lifes, gold, highscore;

    /**
     * runTime lleva la cuenta del tiempo que un objeto lleva en una animación determinada
     */
    private float runTime = 0;

    /**
     * Referencia a la clase principal, utilizada para moverse entre pantallas y gestionar la música
     */
    private TpkGame game;

    /**
     * El estado actual del juego
     * @see GameState
     */
    private GameState currentState;

    /**
     * El estado del juego.
     * READY: El estado inicial de preparación, a la espera del input del jugador para comenzar el nivel
     * RUNNING: El estado normal de funcionamiento, los enemigos se mueven y las torres disparan
     * GAMEOVER: El estado que se alcanza cuando las vidas llegan a cero
     * VICTORY: El estado que se alcanza cuando se eliminan todos los enemigos
     */
    public enum GameState{
        READY, RUNNING, GAMEOVER, VICTORY
    }

    /**
     * Nivel seleccionado
     */
    private Level level;

    /**
     * Enumerado de niveles del juego
     */
    public enum Level{
        LEVEL_1, LEVEL_2, LEVEL_3, LEVEL_4
    }

    EnemyManager enemyManager;
    WaveManager waveManager;
    TowerManager towerManager;

    /**
     * Array de enemigos vivos que han hecho spawn en el nivel
     */
    public Array<Enemy> enemiesInScreen = new Array<Enemy>();
    /**
     * Array de torres construidas en el nivel
     */
    public Array<Tower> constructedTowers = new Array<Tower>();
    /**
     * Array de balas disparadas y en activo del nivel
     */
    public Array<Bullet> bulletsInScreen = new Array<Bullet>();

    /**
     * Array de puntos de spawn del nivel
     */
    public Array<Tile> spawnPoint;
    /**
     * Tile de final del recorrido de los enemigos
     */
    public Tile finishPoint;
    /**
     * Array de tiles de tipo ROAD del nivel
     */
    public Array<Tile> roadTiles;
    /**
     * Array de tiles de tipo FUNDATION del nivel
     */
    public Array<Tile> fundationTiles;

    /**
     * Se utiliza para medir cuanto tiempo ha pasado desde la aparición del último enemigo
     */
    float timeSinceLastSpawn = 0;

    /**
     * Inicializa un nuevo World a partir del mapa y el nivel que se le pasan
     * @param levelCreator El generador del mapa del nivel seleccionado
     * @param game Referencia del game
     * @param level El nivel seleccinado
     */
    public World(LevelCreator levelCreator, TpkGame game, Level level){
        this.game = game;
        this.level = level;

        //Se inicializan puntuación, vidas y oro a valores predeterminados
        score = START_SCORE;
        lifes = START_HEALTH;
        gold = START_GOLD;

        //Se detiene la música del menu, y en función del nivel se carga el mapa, la música y la puntuación record
        game.getMusic().stop();
        switch (level){
            case LEVEL_1:
                AssetLoader.getLevelCreator().setLevel(AssetLoader.level1);
                game.setMusic(AssetLoader.musicLevel1);
                highscore = AssetLoader.preferences.getInteger("highScore_level1");
                break;
            case LEVEL_2:
                AssetLoader.getLevelCreator().setLevel(AssetLoader.level2);
                game.setMusic(AssetLoader.musicLevel2);
                highscore = AssetLoader.preferences.getInteger("highScore_level2");
                break;
            case LEVEL_3:
                AssetLoader.getLevelCreator().setLevel(AssetLoader.level3);
                game.setMusic(AssetLoader.musicLevel3);
                highscore = AssetLoader.preferences.getInteger("highScore_level3");
                break;
            case LEVEL_4:
                AssetLoader.getLevelCreator().setLevel(AssetLoader.level4);
                game.setMusic(AssetLoader.musicLevel4);
                highscore = AssetLoader.preferences.getInteger("highScore_level4");
                break;
        }
        game.getMusic().setLooping(true);
        game.getMusic().setVolume(MUSIC_VOLUME);

        //En función de los datos del mapa, se guardan los objetos importantes del mismo
        spawnPoint = levelCreator.getSpawnTile();
        finishPoint = levelCreator.getFinishTile();
        roadTiles = levelCreator.getDirectionTiles();
        fundationTiles = levelCreator.getFundationTiles();

        //Se escoge la oleada de enemigos correspondiente al nivel
        switch (level){
            case LEVEL_1:
                waveManager = new WaveManager(this, LEVEL_1_WAVE);
                break;
            case LEVEL_2:
                waveManager = new WaveManager(this, LEVEL_2_WAVE);
                break;
            case LEVEL_3:
                waveManager = new WaveManager(this, LEVEL_3_WAVE);
                break;
            case LEVEL_4:
                waveManager = new WaveManager(this, LEVEL_4_WAVE);
                break;
        }

        //Se prepara el juego a la espera del input del jugador (ready) y se crean los manager
        //para las torres y los enemigos
        currentState = GameState.READY;
        enemyManager = new EnemyManager(this);
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
                game.getMusic().play();
                timeSinceLastSpawn += delta;
                enemyManager.update(delta);
                towerManager.update(delta);
                if (timeSinceLastSpawn >= TIME_BETWEEN_SPAWNS){
                    waveManager.spawn();
                    if (level == Level.LEVEL_4){
                        waveManager.spawn();
                    }
                    timeSinceLastSpawn = 0;
                }
                if (lifes <= 0){
                    score += gold;
                    currentState = GameState.GAMEOVER;
                }
                if (waveManager.isEmpty() && enemiesInScreen.isEmpty()){
                    score += gold;
                    if (lifes == 20){
                        score *= 2;
                    } else if (lifes < 20 && lifes >= 17) {
                        score = (int)(score * 1.5);
                    }
                    currentState = GameState.VICTORY;
                }
                break;
            case GAMEOVER:
                saveHighscore();
            case VICTORY:
                saveHighscore();
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

    public boolean isVictory() {
        return currentState == GameState.VICTORY;
    }

    public boolean isRunning() {
        return currentState == GameState.RUNNING;
    }

    public boolean isHighScore() {
        return score > highscore;
    }

    public void start() {
        currentState = GameState.RUNNING;
    }

    public TpkGame getGame() {
        return game;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    /**
     * Si se bate el anterior record del nivel (highscore), se guarda el nuevo valor
     */
    public void saveHighscore(){
        if (isHighScore()){
            switch (level){
                case LEVEL_1:
                    AssetLoader.preferences.putInteger("highScore_level1", score);
                    break;
                case LEVEL_2:
                    AssetLoader.preferences.putInteger("highScore_level2", score);
                    break;
                case LEVEL_3:
                    AssetLoader.preferences.putInteger("highScore_level3", score);
                    break;
                case LEVEL_4:
                    AssetLoader.preferences.putInteger("highScore_level4", score);
                    break;
            }
            AssetLoader.preferences.flush();
        }
    }
}
