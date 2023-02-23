package com.mygdx.menu;

import static com.mygdx.helpers.Stats.MUSIC_VOLUME;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageTextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.mygdx.helpers.AssetLoader;
import com.mygdx.screens.ChooseLevelScreen;
import com.mygdx.screens.CreditsScreen;
import com.mygdx.screens.HowToPlayScreen;
import com.mygdx.screens.RecordsScreen;
import com.mygdx.screens.SettingsScreen;
import com.mygdx.tpk.TpkGame;
import com.mygdx.ui.AnimatedImage;

/**
 * Clase del menú principal
 */
public class MainMenu extends Stage {

    TpkGame game;
    ImageTextButton btnStart, btnOptions, btnRecords, btnCredits, btnHowToPlay;
    AnimatedImage witch;

    /**
     * Inicializa el menú principal con todos sus elementos
     * @param game referencia del game para moverse entre pantallas
     */
    public MainMenu(final TpkGame game){
        super(new StretchViewport(160,288));
        this.game = game;
        Gdx.input.setInputProcessor(this);
        Skin skin = AssetLoader.skinMother;
        ImageTextButton.ImageTextButtonStyle style = skin.get("default", ImageTextButton.ImageTextButtonStyle.class);

        Label label = new Label(AssetLoader.myBundle.format("gameFullName").toUpperCase(), skin, "giygas");
        label.setFontScale(0.5f);

        witch = new AnimatedImage(AssetLoader.witchTowerAnimation);
        witch.setSize(60, 60);

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
                game.setScreen(new SettingsScreen(game));
            }
        });

        btnRecords = new ImageTextButton(AssetLoader.myBundle.format("records").toUpperCase(), style);
        btnRecords.setPosition(40, 110);
        btnRecords.addListener(new InputListener(){
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(new RecordsScreen(game));
            }
        });

        btnCredits = new ImageTextButton(AssetLoader.myBundle.format("credits").toUpperCase(), style);
        btnCredits.setPosition(40,90);
        btnCredits.addListener(new InputListener(){
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(new CreditsScreen(game));
            }
        });

        btnHowToPlay = new ImageTextButton(AssetLoader.myBundle.format("howtoplay").toUpperCase(), style);
        btnHowToPlay.setPosition(40,90);
        btnHowToPlay.addListener(new InputListener(){
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(new HowToPlayScreen(game));
            }
        });

        Table table = new Table();
        table.add(label);
        table.row();
        table.add(witch).padTop(10).padBottom(10);
        table.row();
        table.add(btnStart);
        table.row();
        table.add(btnOptions);
        table.row();
        table.add(btnRecords);
        table.row();
        table.add(btnCredits);
        table.row();
        table.add(btnHowToPlay);
        table.setFillParent(true);
        table.center();

        addActor(table);

        //Se incializa la música del menú principal
        game.setMusic(AssetLoader.musicMainMenu);
        game.getMusic().setLooping(true);
        game.getMusic().play();
        game.getMusic().setVolume(MUSIC_VOLUME);

    }

}
