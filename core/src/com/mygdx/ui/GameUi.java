package com.mygdx.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.mygdx.actors.tiles.Tile;
import com.mygdx.gameworld.World;
import com.mygdx.helpers.AssetLoader;
import com.mygdx.ui.buttons.BuildTowerButton;
import com.mygdx.ui.buttons.Button;
import com.mygdx.ui.buttons.DestroyButton;
import com.mygdx.ui.icons.SimpleIcon;

import sun.java2d.pipe.SpanShapeRenderer;

/**
 * Esta clase gestiona la IU y los inputs del jugador
 */
public class GameUi extends Stage{

    private final World world;
    public final Array<Button> buttons;
    private final Array<Tile> fundations;
    private final Label score, ready, gameOver;
    private final SimpleIcon lifes, gold;

    private Table t;
    private Table root;

    public GameUi (final World world) {
        super(new StretchViewport(160,288));

        Gdx.input.setInputProcessor(this);

        this.world = world;

        buttons = new Array<Button>();
        fundations = world.fundationTiles;

        Skin skin = new Skin(Gdx.files.internal("skin/arcade-ui.json"));

        ready = new Label(AssetLoader.myBundle.format("tapToStart"), skin, "default");
        ready.setBounds(10, 150, 10, 4);
        ready.setFontScale(0.5f);
        gameOver = new Label(AssetLoader.myBundle.format("gameOver"), skin, "default");
        gameOver.setBounds(30, 150, 20, 8);
        gameOver.setFontScale(0.6f);
        gameOver.setVisible(false);
        score = new Label(AssetLoader.myBundle.format("score", world.score), skin, "default");
        score.setBounds(110,280,10,4);
        score.setFontScale(0.3f);
//        gold = new Label(AssetLoader.myBundle.format("gold", world.gold), skin, "default");
//        gold.setBounds(110,270,10,4);
//        gold.setFontScale(0.3f);
//        lifes = new Label(AssetLoader.myBundle.format("lifes", world.lifes), skin, "default");
//        lifes.setBounds(110,260,10,4);
//        lifes.setFontScale(0.3f);
        gold = new SimpleIcon("ui/gold.png", world.gold + "", 10);
        gold.setX(110);
        gold.setY(265);
        lifes = new SimpleIcon("ui/lifes.png", world.lifes + "", 10);
        lifes.setX(110);
        lifes.setY(255);
        addActor(ready);
        addActor(gameOver);
        addActor(score);
        addActor(gold);
        addActor(lifes);

        for (final Tile fundation: fundations) {
            fundation.setBounds(fundation.getHitbox().getX(), fundation.getHitbox().getY(), fundation.getHitbox().getWidth(), fundation.getHitbox().getHeight());
            fundation.addListener(new InputListener(){

                public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                    Gdx.app.log("Example", "touch started at (" + x + ", " + y + ")");
                    if (world.isRunning()){
                        fundation.isTouchDown(x, y);
                        TowerSelect(fundation);
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

        addListener(new InputListener(){

            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                Gdx.app.log("Dedo abajo", "touch done at (" + x + ", " + y + ")");
                if (world.isReady()){
                    world.start();
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

    public void update(float delta){

        switch (world.getCurrentState()){
            case READY:
                ready.setText(AssetLoader.myBundle.format("tapToStart"));
                break;
            case RUNNING:
                if (ready.isVisible()){
                    ready.setVisible(false);
                }
                break;
            case GAMEOVER:
                if (!gameOver.isVisible()){
                    gameOver.setVisible(true);
                }
                gameOver.setText(AssetLoader.myBundle.format("gameOver", world.score));
                break;
            case VICTORY:
                if (!gameOver.isVisible()){
                    gameOver.setVisible(true);
                }
                gameOver.setText(AssetLoader.myBundle.format("victory", world.score));

                break;
            case HIGHSCORE:
                break;
        }

        if(!world.isReady()){
            gold.setText(world.gold + "");
            score.setText(AssetLoader.myBundle.format("score", world.score));
            lifes.setText(world.lifes + "");
        }

    }

    public void clearUI(){
        for (Actor actor : this.getActors()){
            if (actor.getClass() == Table.class || actor.getClass() == Button.class){
                actor.remove();
            }
        }

        t = new Table();
        root = new Table();
        buttons.clear();
    }

    public void TowerSelect(Tile fundation){

        clearUI();

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
