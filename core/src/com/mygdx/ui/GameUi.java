package com.mygdx.ui;

import static com.mygdx.helpers.Stats.TIME_BETWEEN_SPAWNS;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
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
import com.mygdx.ui.buttons.BuildTowerButton;
import com.mygdx.ui.buttons.Button;

public class GameUi extends Stage {

    private final World world;
    public final Array<Button> buttons;
    private final Array<Tile> fundations;
    private final Label score;
    private final Label gold;
    private final Label lifes;

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
        gold.setText("Gold: " + world.gold);
        score.setText("Score: " + world.score);
        lifes.setText("Lifes: " + world.health);
    }

    public void TowerSelect(Tile fundation){

        Table t = new Table();

        BuildTowerButton btb = new BuildTowerButton(this.world, 0, fundation);
        t.add(btb).pad(2);
        buttons.add(btb);

        btb = new BuildTowerButton(this.world, 1, fundation);
        t.add(btb).pad(2).row();
        buttons.add(btb);

        btb = new BuildTowerButton(this.world, 2, fundation);
        t.add(btb).pad(2);
        buttons.add(btb);

        btb = new BuildTowerButton(this.world, 3, fundation);
        t.add(btb).pad(2).row();
        buttons.add(btb);

        Table root = new Table();
        root.setFillParent(true);
        root.add(t).expand().center().bottom().padBottom(5);
        addActor(root);
    }
}
