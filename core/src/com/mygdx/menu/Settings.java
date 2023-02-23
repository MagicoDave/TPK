package com.mygdx.menu;


import static com.mygdx.helpers.Stats.MUSIC_VOLUME;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ImageTextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.mygdx.helpers.AssetLoader;
import com.mygdx.helpers.Stats;
import com.mygdx.screens.MainMenuScreen;
import com.mygdx.tpk.TpkGame;

/**
 * Pantalla de opciones
 */
public class Settings extends Stage {

    TpkGame game;
    Label lblTitle, lblLanguage;
    ImageTextButton btnMusic, btnSound, btnApply;
    boolean music, sound;
    Button btnEnglish, btnSpanish, btnGalician;
    String language;

    /**
     * Inicializa la pantalla de opciones con sus elementos
     * @param game referencia del game para moverse entre pantallas
     */
    public Settings(final TpkGame game){
        super(new StretchViewport(160,288));

        this.game = game;
        Gdx.input.setInputProcessor(this);
        Skin skin = AssetLoader.skinMother;
        ImageTextButton.ImageTextButtonStyle style = skin.get("default", ImageTextButton.ImageTextButtonStyle.class);

        music = AssetLoader.preferences.getBoolean("music");
        sound = AssetLoader.preferences.getBoolean("sound");
        language = AssetLoader.preferences.getString("language");

        lblTitle = new Label(AssetLoader.myBundle.format("settings").toUpperCase(), skin, "giygas");
        lblTitle.setFontScale(0.5f);

        btnMusic = new ImageTextButton(AssetLoader.myBundle.format("music", music).toUpperCase(), style);
        btnMusic.addListener(new InputListener(){
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                if (music){
                    music = false;
                } else {
                    music = true;
                }
                Stats.musicOn(music);
                game.getMusic().setVolume(MUSIC_VOLUME);
            }
        });

        btnSound = new ImageTextButton(AssetLoader.myBundle.format("sound", sound).toUpperCase(), style);
        btnSound.addListener(new InputListener(){
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                if (sound){
                    sound = false;
                } else {
                    sound = true;
                }
                Stats.soundOn(sound);
            }
        });

        lblLanguage = new Label(AssetLoader.myBundle.format("language").toUpperCase(), skin, "giygas");
        lblLanguage.setFontScale(0.5f);

        btnEnglish = new Button(AssetLoader.flagEN);
        btnEnglish.addListener(new InputListener(){
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                AssetLoader.myBundle = AssetLoader.enBundle;
                language = "EN";
            }
        });

        btnSpanish = new Button(AssetLoader.flagES);
        btnSpanish.addListener(new InputListener(){
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                AssetLoader.myBundle = AssetLoader.esBundle;
                language = "ES";
            }
        });

        btnGalician = new Button(AssetLoader.flagGL);
        btnGalician.addListener(new InputListener(){
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                AssetLoader.myBundle = AssetLoader.glBundle;
                language = "GL";
            }
        });

        btnApply = new ImageTextButton(AssetLoader.myBundle.format("apply").toUpperCase(), style);
        btnApply.addListener(new InputListener(){
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                //Se guardan todas las preferencias seleccionadas
                AssetLoader.preferences.putBoolean("music", music);
                AssetLoader.preferences.putBoolean("sound", sound);
                AssetLoader.preferences.putString("language", language);
                AssetLoader.preferences.flush();
                game.setScreen(new MainMenuScreen(game));
            }
        });

        Table table = new Table();
        table.add(lblTitle).padBottom(20);
        table.row();
        table.add(btnMusic);
        table.row();
        table.add(btnSound);
        table.row();
        table.add(lblLanguage);
        table.row();

        Table subtable = new Table();
        subtable.add(btnEnglish).width(20).height(20).padLeft(5).padRight(5);
        subtable.add(btnSpanish).width(20).height(20).padLeft(5).padRight(5);
        subtable.add(btnGalician).width(20).height(20).padLeft(5).padRight(5).row();

        table.add(subtable);
        table.row();
        table.add(btnApply).padTop(20);
        table.setFillParent(true);
        table.center();

        addActor(table);
    }

    /**
     * Actualiza los elementos de la UI (por ejemplo, cuando se cambia el idioma)
     * @param delta Tasa de refresco
     */
    public void update(float delta){
        lblTitle.setText(AssetLoader.myBundle.format("settings").toUpperCase());
        lblLanguage.setText(AssetLoader.myBundle.format("language").toUpperCase());

        btnMusic.setText(AssetLoader.myBundle.format("music", music).toUpperCase());
        btnSound.setText(AssetLoader.myBundle.format("sound", sound).toUpperCase());
        btnApply.setText(AssetLoader.myBundle.format("apply").toUpperCase());
    }
}
