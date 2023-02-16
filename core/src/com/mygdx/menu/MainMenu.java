package com.mygdx.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageTextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.mygdx.helpers.AssetLoader;
import com.mygdx.screens.ChooseLevelScreen;
import com.mygdx.screens.GameScreen;
import com.mygdx.tpk.TpkGame;


public class MainMenu extends Stage {

    TpkGame game;
    ImageTextButton btnStart, btnOptions, btnCredits;

    public MainMenu(final TpkGame game){
        super(new StretchViewport(160,288));
        this.game = game;
        Gdx.input.setInputProcessor(this);
        
        Skin skin = AssetLoader.skinMother;
        ImageTextButton.ImageTextButtonStyle style = skin.get("default", ImageTextButton.ImageTextButtonStyle.class);

        Label label = new Label(AssetLoader.myBundle.format("gameFullName").toUpperCase(), skin, "giygas");
        label.setPosition(15, 200);
        label.setFontScale(0.5f);

        btnStart = new ImageTextButton(AssetLoader.myBundle.format("start").toUpperCase(), style);
        btnStart.setPosition(40, 130);
        btnStart.addListener(new InputListener(){
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(new ChooseLevelScreen(game));
            }
        });

        btnOptions = new ImageTextButton(AssetLoader.myBundle.format("options").toUpperCase(), style);
        btnOptions.setPosition(40, 110);
        btnOptions.addListener(new InputListener(){
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {

            }
        });

        btnCredits = new ImageTextButton(AssetLoader.myBundle.format("credits").toUpperCase(), style);
        btnCredits.setPosition(40,90);
        btnCredits.addListener(new InputListener(){
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {

            }
        });

        Table table = new Table();
        table.add(btnStart);
        table.row();
        table.add(btnOptions);
        table.row();
        table.add(btnCredits);
        table.setFillParent(true);
        table.center().padTop(20);

        addActor(label);
        addActor(table);

        game.setMusic(AssetLoader.musicMainMenu);
        game.getMusic().setLooping(true);
        game.getMusic().play();
    }

}
