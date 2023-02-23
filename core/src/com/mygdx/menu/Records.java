package com.mygdx.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.mygdx.helpers.AssetLoader;
import com.mygdx.screens.MainMenuScreen;
import com.mygdx.tpk.TpkGame;

/**
 * Pantalla de records
 */
public class Records extends Stage {

    TpkGame game;
    Label record1, record2, record3, record4;
    Button btnBack;

    /**
     * Inicializa la pantalla de records con sus elementos
     * @param game referencia del game para moverse entre pantallas
     */
    public Records(final TpkGame game){
        super(new StretchViewport(160,288));

        this.game = game;
        Gdx.input.setInputProcessor(this);
        Skin skin = AssetLoader.skinMother;

        record1 = new Label(AssetLoader.myBundle.format("recordHighscore", 1, AssetLoader.preferences.getInteger("highScore_level1")).toUpperCase(), skin, "giygas");
        record1.setFontScale(0.3f);
        record2 = new Label(AssetLoader.myBundle.format("recordHighscore", 2, AssetLoader.preferences.getInteger("highScore_level2")).toUpperCase(), skin, "giygas");
        record2.setFontScale(0.3f);
        record3 = new Label(AssetLoader.myBundle.format("recordHighscore", 3, AssetLoader.preferences.getInteger("highScore_level3")).toUpperCase(), skin, "giygas");
        record3.setFontScale(0.3f);
        record4 = new Label(AssetLoader.myBundle.format("recordHighscore", 4, AssetLoader.preferences.getInteger("highScore_level4")).toUpperCase(), skin, "giygas");
        record4.setFontScale(0.3f);

        btnBack = new Button(AssetLoader.backArrow);
        btnBack.addListener(new InputListener(){
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(new MainMenuScreen(game));
            }
        });

        Table t = new Table();
        t.add(record1).row();
        t.add(record2).row();
        t.add(record3).row();
        t.add(record4).row();
        t.add(btnBack).padRight(50).padTop(50).width(20).height(20);
        t.setFillParent(true);
        t.center();

        addActor(t);
    }
}
