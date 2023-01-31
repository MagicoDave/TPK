package com.mygdx.ui.buttons;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.mygdx.actors.tiles.Tile;
import com.mygdx.actors.towers.ArrowTower;
import com.mygdx.actors.towers.CyclopTower;
import com.mygdx.actors.towers.StickyTower;
import com.mygdx.actors.towers.Tower;
import com.mygdx.actors.towers.WitchTower;
import com.mygdx.gameworld.World;
import com.mygdx.helpers.AssetLoader;

public class BuildTowerButton extends Button{

    private int towerIndex;
    private Tile fundation;
    private Tower tower;
    private int towerCost;

    public BuildTowerButton (final World world, int towerIndex, final Tile fundation){
        super(world);
        this.towerIndex = towerIndex;
        this.fundation = fundation;

        switch (towerIndex){
            case 0:
                tower = new ArrowTower(world, fundation);
                texture = new Texture(Gdx.files.internal("buttons/arrowtowerButton.png"));
                break;
            case 1:
                tower = new WitchTower(world, fundation);
                texture = new Texture(Gdx.files.internal("buttons/witchtowerButton.png"));
                break;
            case 2:
                tower = new StickyTower(world, fundation);
                texture = new Texture(Gdx.files.internal("buttons/stickytowerButton.png"));
                break;
            case 3:
                tower = new CyclopTower(world, fundation);
                texture = new Texture(Gdx.files.internal("buttons/cyclopstowerButton.png"));
                break;
        }

        addListener(new InputListener(){

            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                if (world.gold >= tower.getPrice()){
                    if (fundation.getTower() != null){
                        world.constructedTowers.removeValue(fundation.getTower(), true);
                    }
                    fundation.setTower(tower);
                    world.constructedTowers.add(fundation.getTower());
                    world.gold -= tower.getPrice();
                }
                return true;
            }


            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {

            }
        });
    }

}
