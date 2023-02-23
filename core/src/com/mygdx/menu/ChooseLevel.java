package com.mygdx.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageTextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.mygdx.gameworld.World;
import com.mygdx.helpers.AssetLoader;
import com.mygdx.screens.GameScreen;
import com.mygdx.tpk.TpkGame;

/**
 * Gestiona el menú de selección de nivel
 */
public class ChooseLevel extends Stage {

    TpkGame game;
    ImageTextButton btnLevel1, btnLevel2, btnLevel3, btnLevel4;

    /**
     * Inicializa el menú con todos los botones y elementos
     * @param game Referencia de game (necesaria para moverse entre pantallas)
     */
    public ChooseLevel(final TpkGame game){
        super(new StretchViewport(160,288));
        this.game = game;
        Gdx.input.setInputProcessor(this);

        Skin skin = AssetLoader.skinMother;
        ImageTextButton.ImageTextButtonStyle style = skin.get("default", ImageTextButton.ImageTextButtonStyle.class);

        Label label = new Label(AssetLoader.myBundle.format("selectLevel").toUpperCase(), skin, "giygas");
        label.setPosition(20, 200);
        label.setFontScale(0.5f);

        btnLevel1 = new ImageTextButton(AssetLoader.myBundle.format("river").toUpperCase(), style);
        btnLevel1.setPosition(40, 130);
        btnLevel1.addListener(new InputListener(){
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(new GameScreen(game, World.Level.LEVEL_1));
            }
        });

        btnLevel2 = new ImageTextButton(AssetLoader.myBundle.format("forest").toUpperCase(), style);
        btnLevel2.setPosition(40, 110);
        btnLevel2.addListener(new InputListener(){
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(new GameScreen(game, World.Level.LEVEL_2));
            }
        });

        btnLevel3 = new ImageTextButton(AssetLoader.myBundle.format("dungeon").toUpperCase(), style);
        btnLevel3.setPosition(40, 110);
        btnLevel3.addListener(new InputListener(){
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(new GameScreen(game, World.Level.LEVEL_3));
            }
        });

        btnLevel4 = new ImageTextButton(AssetLoader.myBundle.format("village").toUpperCase(), style);
        btnLevel4.setPosition(40, 110);
        btnLevel4.addListener(new InputListener(){
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(new GameScreen(game, World.Level.LEVEL_4));
            }
        });

        Table table = new Table();
        table.add(label).padBottom(40);
        table.row();
        table.add(btnLevel1);
        table.row();
        table.add(btnLevel2);
        table.row();
        table.add(btnLevel3);
        table.row();
        table.add(btnLevel4);
        table.setFillParent(true);
        table.center();

        addActor(table);
    }
}
