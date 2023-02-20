package com.mygdx.ui.buttons;

import static com.mygdx.helpers.Stats.SOUND_VOLUME;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.mygdx.actors.tiles.Tile;
import com.mygdx.actors.towers.ArrowTower;
import com.mygdx.actors.towers.CyclopTower;
import com.mygdx.actors.towers.StickyTower;
import com.mygdx.actors.towers.Tower;
import com.mygdx.actors.towers.WitchTower;
import com.mygdx.gameworld.World;
import com.mygdx.helpers.AssetLoader;

public class BuildTowerButton extends Button{

    private Tile fundation;
    private Tower tower;
    private int towerCost;
    private Label labelCost;

    public BuildTowerButton (final World world, int towerIndex, final Tile fundation){
        super(world);
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

        towerCost = tower.getPrice();
        Skin skin = AssetLoader.skinArcade;
        labelCost = new Label("", skin);
        labelCost.setBounds(this.getX(),this.getY(),this.getWidth(), (this.getHeight() * 0.75f));
        labelCost.setFontScale(0.3f);
        labelCost.setText(towerCost);

        addListener(new InputListener(){

            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                if (world.gold >= towerCost){
                    if (fundation.getTower() != null){
                        world.constructedTowers.removeValue(fundation.getTower(), true);
                    }
                    fundation.setTower(tower);
                    world.constructedTowers.add(fundation.getTower());
                    world.gold -= towerCost;
                    AssetLoader.soundBuiltTower.play(SOUND_VOLUME);
                }
                return true;
            }

        });
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        labelCost.setBounds(this.getX() + 5,this.getY(),this.getWidth(), (this.getHeight() * 0.5f));
        if (world.gold < towerCost){
            labelCost.setColor(Color.RED);
        } else {
            labelCost.setColor(Color.YELLOW);
        }
        labelCost.draw(batch, parentAlpha);
    }

}
