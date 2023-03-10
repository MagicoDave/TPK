package com.mygdx.ui.buttons;

import static com.mygdx.helpers.Stats.SOUND_VOLUME;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.mygdx.actors.tiles.Tile;
import com.mygdx.gameworld.World;
import com.mygdx.helpers.AssetLoader;

/**
 * Botón de destruir torre
 */
public class DestroyButton extends Button{

    private Tile fundation;
    private World world;

    /**
     * Inicializa un botón de destruir torre
     * @param world referencia del nivel
     * @param fundation fundation de la torre a destruir
     */
    public DestroyButton(final World world, final Tile fundation) {
        super(world);

        texture = new Texture(Gdx.files.internal("buttons/destroytowerButton.png"));
        this.fundation = fundation;

        addListener(new InputListener(){

            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                if (fundation.getTower() != null){
                    world.gold += fundation.getTower().getPrice() / 2;
                    world.constructedTowers.removeValue(fundation.getTower(), true);
                    fundation.setTower(null);
                    AssetLoader.soundDestroyTower.play(SOUND_VOLUME);
                    return true;
                }
                return false;
            }


            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {

            }
        });
    }
}
