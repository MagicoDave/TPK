package com.mygdx.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.mygdx.actors.tiles.Tile;
import com.mygdx.actors.towers.ArrowTower;
import com.mygdx.actors.towers.Tower;
import com.mygdx.gameworld.World;
import com.mygdx.ui.buttons.Button;

public class GameUi extends Stage {

    private final World world;
    private final Array<Button> buttons;
    private final Array<Tile> fundations;

    public GameUi (final World world) {
        super(new StretchViewport(160,288));

        Gdx.input.setInputProcessor(this);

        this.world = world;

        buttons = new Array<Button>();
        fundations = world.fundationTiles;

        for (final Tile fundation: fundations) {
            fundation.setBounds(fundation.getHitbox().getX(), fundation.getHitbox().getY(), fundation.getHitbox().getWidth(), fundation.getHitbox().getHeight());
            fundation.addListener(new InputListener(){

                public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                    Gdx.app.log("Example", "touch started at (" + x + ", " + y + ")");
                    ArrowTower t = new ArrowTower(world, fundation);
                    fundation.setTower(t);
                    world.constructedTowers.add(t);
                    return true;
                }

                public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                    Gdx.app.log("Example", "touch done at (" + x + ", " + y + ")");
                }

            });
            addActor(fundation);
        }
    }

    public void TowerSelect(Tile fundation){
        Table t = new Table();


    }
}
