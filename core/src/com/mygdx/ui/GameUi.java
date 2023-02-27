package com.mygdx.ui;

import static com.mygdx.helpers.Stats.SHAKE_THRESHOLD;
import static com.mygdx.helpers.Stats.SOUND_VOLUME;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.mygdx.actors.tiles.Tile;
import com.mygdx.gameworld.World;
import com.mygdx.helpers.AssetLoader;
import com.mygdx.screens.MainMenuScreen;
import com.mygdx.ui.buttons.BuildTowerButton;
import com.mygdx.ui.buttons.Button;
import com.mygdx.ui.buttons.DestroyButton;
import com.mygdx.ui.buttons.RageButton;
import com.mygdx.ui.icons.SimpleIcon;

/**
 * Esta clase gestiona la IU y los inputs del jugador
 */
public class GameUi extends Stage{

    /**
     * Referencia del nivel
     */
    private final World world;

    /**
     * Array que contiene los botones del menú de construcción de torreta
     */
    public final Array<Button> buttons;

    /**
     * Array con el conjunto de fundaciones del nivel
     */
    private final Array<Tile> fundations;

    /**
     * Labels informativas del estado del juego y puntuación
     */
    private final Label score, ready, gameOver;

    /**
     * Iconos animados con label para vidas y oro
     */
    private final SimpleIcon lifes, gold;

    /**
     * Tabla interna
     */
    private Table t;

    /**
     * Tabla externa
     */
    private Table root;

    /**
     * Botón Rage
     */
    private RageButton rageButton;

    /**
     * Variable que almacena la disponibilidad del acelerómetro en el dispositivo
     */
    boolean accelerometerAvailability;
    /**
     * Variable que almacena la última vez que se actualizó la lectura del acelerómetro
     */
    long lastUpdate = 0;
    /**
     * Variable que almacena la última lectura del valor X del acelerómetro
     */
    float lastX = 0;
    /**
     * Variable que almacena la última lectura del valor Y del acelerómetro
     */
    float lastY = 0;
    /**
     * Variable que almacena la última lectura del valor Z del acelerómetro
     */
    float lastZ = 0;

    /**
     * Inicializa una nueva GameUi y coloca todos los componentes en posición
     * @param world referencia del mundo
     */
    public GameUi (final World world) {
        super(new StretchViewport(160,288));
        Gdx.input.setInputProcessor(this);
        this.world = world;

        buttons = new Array<Button>();
        fundations = world.fundationTiles;

        //Comprueba si el acelerómetro esta disponible
        accelerometerAvailability = Gdx.input.isPeripheralAvailable(Input.Peripheral.Accelerometer);
        Gdx.app.log("accelReady: ", accelerometerAvailability + "");

        //Labels y elementos informativos de la UI
        Skin skin = AssetLoader.skinArcade;
        ready = new Label(AssetLoader.myBundle.format("tapToStart"), skin, "default");
        ready.setBounds(70, 150, 10, 4);
        ready.setFontScale(0.5f);
        ready.setAlignment(Align.center);
        gameOver = new Label(AssetLoader.myBundle.format("gameOver"), skin, "default");
        gameOver.setBounds(30, 150, 20, 8);
        gameOver.setFontScale(0.6f);
        gameOver.setVisible(false);
        score = new Label(AssetLoader.myBundle.format("score", world.score), skin, "default");
        score.setBounds(105,270,10,4);
        score.setFontScale(0.3f);
        gold = new SimpleIcon("ui/gold.png", world.gold + "", 10);
        gold.setX(105);
        gold.setY(275);
        lifes = new SimpleIcon("ui/lifes.png", world.lifes + "", 10);
        lifes.setX(130);
        lifes.setY(275);
        addActor(ready);
        addActor(gameOver);
        addActor(score);
        addActor(gold);
        addActor(lifes);

        //Botón Rage
        rageButton = new RageButton(world);
        rageButton.setX(125);
        rageButton.setY(13);
        rageButton.setVisible(false);
        addActor(rageButton);

        //Eventos de toque para las fundations del world
        for (final Tile fundation: fundations) {
            fundation.setBounds(fundation.getHitbox().getX(), fundation.getHitbox().getY(), fundation.getHitbox().getWidth(), fundation.getHitbox().getHeight());
            fundation.addListener(new InputListener(){

                public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                    Gdx.app.log("Example", "touch started at (" + x + ", " + y + ")");
                    if (world.isRunning()){
                        fundation.isTouchDown(x, y);
                        TowerSelect(fundation);
                        AssetLoader.soundFundationSelected.play(SOUND_VOLUME);
                        return true;
                    }
                    return false;
                }

                public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                    Gdx.app.log("Example", "touch done at (" + x + ", " + y + ")");
                }

            });
            addActor(fundation);
        }

        //Eventos de toque para la pantalla que no sean en un fundation o button
        addListener(new InputListener(){

            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.log("Dedo abajo", "touch done at (" + x + ", " + y + ")");
                if (world.isReady()){
                    world.start();
                } else if (world.isGameOver() || world.isVictory()){
                    world.getGame().getMusic().stop();
                    world.getGame().setScreen(new MainMenuScreen(world.getGame()));
                }
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.log("Dedo arriba", "touch done at (" + x + ", " + y + ")");
                if (world.isRunning()){
                    boolean touchingF = false;
                    for (final Tile f: fundations){
                        if (f.isTouchUp(x, y)){
                            touchingF = true;
                        }
                    }

                    if (!touchingF){
                        Gdx.app.log("Dedo borrador", touchingF + "");
                        clearUI();
                    }
                }
            }

        });

    }

    /**
     * Detecta si se agita el móvil (Pulsa el RageButton)
     */
    public void shakeDetection(){
        if (accelerometerAvailability){

            float x = Gdx.input.getAccelerometerX();
            float y = Gdx.input.getAccelerometerY();
            float z = Gdx.input.getAccelerometerZ();

            long currentTimeMillis = System.currentTimeMillis();

            if (currentTimeMillis - lastUpdate > 200){
                lastUpdate = currentTimeMillis;
                float speed = x+y+z - lastX-lastY-lastZ;
                if (speed > SHAKE_THRESHOLD || speed < -SHAKE_THRESHOLD){
                    Gdx.app.log("shake", "shaked! speed: " + speed );
                    rageButton.rage();
                }
            }

            lastX = x;
            lastY = y;
            lastZ = z;
        }
    }

    /**
     * Actualiza los elementos de la UI
     * @param delta Tasa de refresco
     */
    public void update(float delta){
        switch (world.getCurrentState()){
            case READY:
                ready.setText(AssetLoader.myBundle.format("tapToStart"));
                break;
            case RUNNING:
                if (ready.isVisible()){
                    ready.setVisible(false);
                    rageButton.setVisible(true);
                }
                shakeDetection();
                break;
            case GAMEOVER:
                if (!gameOver.isVisible()){
                    gameOver.setVisible(true);
                    rageButton.setVisible(false);
                }
                gameOver.setText(AssetLoader.myBundle.format("gameOver", world.score));
                if (world.isHighScore()){
                    gameOver.setText(gameOver.getText() + AssetLoader.myBundle.format("highscore", world.highscore));
                }
                break;
            case VICTORY:
                if (!gameOver.isVisible()){
                    gameOver.setVisible(true);
                    rageButton.setVisible(false);
                }
                gameOver.setText(AssetLoader.myBundle.format("victory", world.score));
                if (world.isHighScore()){
                    gameOver.setText(gameOver.getText() + AssetLoader.myBundle.format("highscore", world.highscore));
                }
                break;
        }

        if(!world.isReady()){
            gold.setText(world.gold + "");
            score.setText(AssetLoader.myBundle.format("score", world.score));
            lifes.setText(world.lifes + "");
        }

    }

    /**
     * Limpia la interfaz de construcción de torres
     */
    public void clearUI(){
        for (Actor actor : this.getActors()){
            if (actor.getClass() == Table.class || actor.getClass() == Button.class){
                actor.remove();
            }
        }

        for (Tile fundation : fundations){
            fundation.setSelected(false);
        }

        t = new Table();
        root = new Table();
        buttons.clear();
    }

    /**
     * Despliega la interfaz para la construcción de torres
     * @param fundation La fundation en la cual se va a construir la torre
     */
    public void TowerSelect(Tile fundation){

        clearUI();
        fundation.setSelected(true);

        if (fundation.getTower() == null) {

            BuildTowerButton btb = new BuildTowerButton(this.world, 0, fundation);
            t.add(btb).pad(1);
            buttons.add(btb);

            btb = new BuildTowerButton(this.world, 1, fundation);
            t.add(btb).pad(1);
            buttons.add(btb);

            btb = new BuildTowerButton(this.world, 2, fundation);
            t.add(btb).pad(1);
            buttons.add(btb);

            btb = new BuildTowerButton(this.world, 3, fundation);
            t.add(btb).pad(1).row();
            buttons.add(btb);

            root.setFillParent(true);
            root.add(t).expand().left().bottom().padBottom(12).padLeft(12);
            addActor(root);

        } else {

            DestroyButton db = new DestroyButton(this.world, fundation);
            t.add(db).pad(1);
            buttons.add(db);

            root.setFillParent(true);
            root.add(t).expand().left().bottom().padBottom(12).padLeft(12);
            addActor(root);
        }

    }

}
