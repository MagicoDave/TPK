package com.mygdx.ui;

import static com.mygdx.helpers.Stats.TIME_BETWEEN_SPAWNS;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.mygdx.actors.tiles.Tile;
import com.mygdx.actors.towers.ArrowTower;
import com.mygdx.actors.towers.Tower;
import com.mygdx.gameworld.World;
import com.mygdx.helpers.AssetLoader;
import com.mygdx.ui.buttons.BuildTowerButton;
import com.mygdx.ui.buttons.Button;
import com.mygdx.ui.buttons.DestroyButton;

public class GameUi extends Stage {

    private final World world;
    public final Array<Button> buttons;
    private final Array<Tile> fundations;
    private final Label score;
    private final Label gold;
    private final Label lifes;

    private Table t;
    private Table root;

    public GameUi (final World world) {
        super(new StretchViewport(160,288));

        Gdx.input.setInputProcessor(this);

        this.world = world;

        buttons = new Array<Button>();
        fundations = world.fundationTiles;

        Skin skin = new Skin(Gdx.files.internal("skin/arcade-ui.json"));

        score = new Label("Score: " + world.score, skin, "default");
        score.setBounds(110,280,10,4);
        score.setFontScale(0.3f);
        gold = new Label("Gold: " + world.gold, skin, "default");
        gold.setBounds(110,270,10,4);
        gold.setFontScale(0.3f);
        lifes = new Label("Lifes: " + world.health, skin, "default");
        lifes.setBounds(110,260,10,4);
        lifes.setFontScale(0.3f);
        addActor(score);
        addActor(gold);
        addActor(lifes);

        for (final Tile fundation: fundations) {
            fundation.setBounds(fundation.getHitbox().getX(), fundation.getHitbox().getY(), fundation.getHitbox().getWidth(), fundation.getHitbox().getHeight());
            fundation.addListener(new InputListener(){

                public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                    Gdx.app.log("Example", "touch started at (" + x + ", " + y + ")");
                    TowerSelect(fundation);
                    return true;
                }

                public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                    Gdx.app.log("Example", "touch done at (" + x + ", " + y + ")");
                }

            });
            addActor(fundation);
        }
    }

    public void update(float delta){
        //gold.setText("Gold: " + world.gold);
        gold.setText(AssetLoader.myBundle.format("gold", world.gold));
        score.setText(AssetLoader.myBundle.format("score", world.score));
        lifes.setText(AssetLoader.myBundle.format("lifes", world.health));
    }

    public void TowerSelect(Tile fundation){

        for (Actor actor : this.getActors()){
            if (actor.getClass() == Table.class || actor.getClass() == Button.class){
                actor.remove();
            }
        }

        t = new Table();
        root = new Table();
        buttons.clear();

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
