package com.mygdx.ui.buttons;

import static com.mygdx.helpers.Stats.RAGE_PRICE;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.mygdx.actors.towers.Tower;
import com.mygdx.gameworld.World;
import com.mygdx.helpers.AssetLoader;

/**
 * Este botón activa el modo Rage de las torretas construidas
 */
public class RageButton extends Button{

    Label labelCost;

    public RageButton(final World world) {
        super(world);

        Skin skin = AssetLoader.skinArcade;
        labelCost = new Label("", skin);
        labelCost.setBounds(this.getX(),this.getY(),this.getWidth(), (this.getHeight() * 0.75f));
        labelCost.setFontScale(0.3f);
        labelCost.setText(RAGE_PRICE);

        texture = new Texture(Gdx.files.internal("ui/rageButton.png"));

        addListener(new InputListener(){

            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                rage();
                return true;
            }

        });
    }

    /**
     * Activa el modo Rage de las torretas construidas
     */
    public void rage(){
        if (world.gold >= RAGE_PRICE && !world.constructedTowers.isEmpty()){
            for (Tower t : world.constructedTowers) {
                t.setEnraged(true);
            }
            world.gold -= RAGE_PRICE;
            Gdx.input.vibrate(new long[]{0, 200, 100, 200}, -1);
            AssetLoader.soundRage.play();
        }
    }

    /**
     * Dibuja el componente. Se sobreescribe para añadirle una label con el precio de la mejora que cambia de color según el oro disponible
     * @param batch El batch que se usa para dibujar el elemento
     * @param parentAlpha El alfa del elemento padre, que se multiplica con el del actor
     */
    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        labelCost.setBounds(this.getX() + 5,this.getY(),this.getWidth(), (this.getHeight() * 0.5f));
        if (world.gold < RAGE_PRICE){
            labelCost.setColor(Color.RED);
        } else {
            labelCost.setColor(Color.YELLOW);
        }
        labelCost.draw(batch, parentAlpha);
    }
}


