package com.mygdx.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.mygdx.helpers.AssetLoader;
import com.mygdx.tpk.TpkGame;
import com.mygdx.ui.AnimatedImage;

/**
 * Pantalla con un pequeño tutorial de como jugar
 */
public class HowToPlay extends Stage {

    TpkGame game;
    Label htp0, htp1, towers, htp2, htp3, htp4, htp5, htp6, enemies, htp7, htp8, htp9, htp10, resources, htp11, htp12, htp13;
    AnimatedImage arrow, witch, sticky, cyclops, farmer, barbarian, thief, mage, gold, lifes;
    Image fundation, rageButton;

    /**
     * Inicializa la pantalla de tutorial con sus elementos
     * @param game referencia de game
     */
    public HowToPlay(TpkGame game){
        super(new StretchViewport(160,288));

        this.game = game;
        Gdx.input.setInputProcessor(this);
        Skin skin = AssetLoader.skinMother;

        htp0 = new Label(AssetLoader.myBundle.get("htp0").toUpperCase(), skin, "giygas");
        htp0.setFontScale(0.4f);
        towers = new Label(AssetLoader.myBundle.get("towers").toUpperCase(), skin, "giygas");
        towers.setFontScale(0.4f);
        enemies = new Label(AssetLoader.myBundle.get("enemies").toUpperCase(), skin, "giygas");
        enemies.setFontScale(0.4f);
        resources = new Label(AssetLoader.myBundle.get("resources").toUpperCase(), skin, "giygas");
        resources.setFontScale(0.4f);

        htp1 = new Label(AssetLoader.myBundle.get("htp1"), skin, "default");
        htp1.setFontScale(0.5f);
        htp1.setWrap(true);
        htp2 = new Label(AssetLoader.myBundle.get("htp2"), skin, "default");
        htp2.setFontScale(0.5f);
        htp2.setWrap(true);
        htp3 = new Label(AssetLoader.myBundle.get("htp3"), skin, "default");
        htp3.setFontScale(0.5f);
        htp3.setWrap(true);
        htp4 = new Label(AssetLoader.myBundle.get("htp4"), skin, "default");
        htp4.setFontScale(0.5f);
        htp4.setWrap(true);
        htp5 = new Label(AssetLoader.myBundle.get("htp5"), skin, "default");
        htp5.setFontScale(0.5f);
        htp5.setWrap(true);
        htp6 = new Label(AssetLoader.myBundle.get("htp6"), skin, "default");
        htp6.setFontScale(0.5f);
        htp6.setWrap(true);
        htp7 = new Label(AssetLoader.myBundle.get("htp7"), skin, "default");
        htp7.setFontScale(0.5f);
        htp7.setWrap(true);
        htp8 = new Label(AssetLoader.myBundle.get("htp8"), skin, "default");
        htp8.setFontScale(0.5f);
        htp8.setWrap(true);
        htp9 = new Label(AssetLoader.myBundle.get("htp9"), skin, "default");
        htp9.setFontScale(0.5f);
        htp9.setWrap(true);
        htp10 = new Label(AssetLoader.myBundle.get("htp10"), skin, "default");
        htp10.setFontScale(0.5f);
        htp10.setWrap(true);
        htp11 = new Label(AssetLoader.myBundle.get("htp11"), skin, "default");
        htp11.setFontScale(0.5f);
        htp11.setWrap(true);
        htp12 = new Label(AssetLoader.myBundle.get("htp12"), skin, "default");
        htp12.setFontScale(0.5f);
        htp12.setWrap(true);
        htp13 = new Label(AssetLoader.myBundle.get("htp13"), skin, "default");
        htp13.setFontScale(0.5f);
        htp13.setWrap(true);


    }
}
