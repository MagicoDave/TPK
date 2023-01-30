package com.mygdx.ui.buttons;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.mygdx.actors.tiles.Tile;
import com.mygdx.actors.towers.Tower;
import com.mygdx.gameworld.World;

public class BuildTowerButton extends Button{

    private int towerIndex;
    private Tile fundation;
    private Tower tower;
    private int towerCost;

    public BuildTowerButton (final World world, int towerIndex, Tile fundation){
        super(world);
        this.towerIndex = towerIndex;
        this.fundation = fundation;

        switch (towerIndex){
            //TODO
        }

        addListener(new InputListener(){

            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                //if (world.gold >= )
                //TODO
                BuildTower();
                return true;
            }


            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {

            }
        });
    }

    public void BuildTower(){

    }
}
