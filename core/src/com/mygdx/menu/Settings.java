package com.mygdx.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.ImageTextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.mygdx.helpers.AssetLoader;
import com.mygdx.screens.ChooseLevelScreen;
import com.mygdx.tpk.TpkGame;

public class Settings extends Stage {

    TpkGame game;
    ImageTextButton btnMusic, btnSound;
    ImageButton btnEnglish, btnSpanish, btnGalician;

    public Settings(final TpkGame game){
        super(new StretchViewport(160,288));

        this.game = game;
        Gdx.input.setInputProcessor(this);
        Skin skin = AssetLoader.skinMother;
        ImageTextButton.ImageTextButtonStyle style = skin.get("default", ImageTextButton.ImageTextButtonStyle.class);

        Label label = new Label(AssetLoader.myBundle.format("gameFullName").toUpperCase(), skin, "giygas");
        label.setFontScale(0.5f);

        btnMusic = new ImageTextButton(AssetLoader.myBundle.format("start").toUpperCase(), style);
        btnMusic.setPosition(40, 130);
        btnMusic.addListener(new InputListener(){
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(new ChooseLevelScreen(game));
            }
        });

        btnSound = new ImageTextButton(AssetLoader.myBundle.format("start").toUpperCase(), style);
        btnSound.setPosition(40, 130);
        btnSound.addListener(new InputListener(){
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(new ChooseLevelScreen(game));
            }
        });

        Table table = new Table();
        table.add(label).padBottom(40);
        table.row();
        table.add();
        table.row();
        table.add();
        table.row();
        table.add();
        table.setFillParent(true);
        table.setDebug(true);
        table.center();

        addActor(table);

        game.setMusic(AssetLoader.musicMainMenu);
        game.getMusic().setLooping(true);
        game.getMusic().play();
    }
}
