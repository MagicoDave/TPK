package com.mygdx.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.mygdx.helpers.AssetLoader;
import com.mygdx.screens.MainMenuScreen;
import com.mygdx.tpk.TpkGame;
import com.mygdx.ui.AnimatedImage;
import com.mygdx.ui.icons.SimpleIcon;

/**
 * Pantalla con un pequeño tutorial de como jugar
 */
public class HowToPlay extends Stage {

    TpkGame game;
    Label htp0, htp1, towers, htp2, htp3, htp4, htp5, htp6, enemies, htp7, htp8, htp9, htp10, resources, htp11, htp12, htp13;
    AnimatedImage arrow, witch, sticky, cyclops, farmer, barbarian, thief, mage;
    SimpleIcon gold, lifes;
    Image fundation, rageButton;
    Button btnBack;

    /**
     * Inicializa la pantalla de tutorial con sus elementos
     * @param game referencia de game
     */
    public HowToPlay(final TpkGame game){
        super(new StretchViewport(160,288));

        this.game = game;
        Gdx.input.setInputProcessor(this);
        Skin skin = AssetLoader.skinMother;

        arrow = new AnimatedImage(AssetLoader.arrowTowerAnimation);
        witch = new AnimatedImage(AssetLoader.witchTowerAnimation);
        sticky = new AnimatedImage(AssetLoader.stickyTowerAnimation);
        cyclops = new AnimatedImage(AssetLoader.cyclopTowerAnimation);
        farmer = new AnimatedImage(AssetLoader.farmerAnimation);
        barbarian = new AnimatedImage(AssetLoader.barbarianAnimation);
        thief = new AnimatedImage(AssetLoader.thiefAnimation);
        mage = new AnimatedImage(AssetLoader.mageAnimation);
        gold = new SimpleIcon("ui/gold.png", "", 10);
        lifes = new SimpleIcon("ui/lifes.png", "", 10);
        rageButton = new Image(new Texture(Gdx.files.internal("ui/rageButton.png")));
        fundation = new Image(AssetLoader.fundation);

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

        btnBack = new Button(AssetLoader.backArrow);
        btnBack.addListener(new InputListener(){
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                game.setScreen(new MainMenuScreen(game));
            }
        });

        Table root = new Table();
        Table t = new Table();
        t.add(btnBack).width(20).height(20).left().row();
        t.add(htp0).row();
        t.add(htp1).width(150f).row();
        t.add(towers).row();
        Table t1 = new Table();
        t1.add(fundation).width(20).height(20).padRight(5);
        t1.add(htp2).width(125f).row();
        t.add(t1).row();
        Table t2 = new Table();
        t2.add(arrow).width(20).height(20).padRight(5);
        t2.add(htp3).width(125f).row();
        t.add(t2).row();
        Table t3 = new Table();
        t3.add(witch).width(20).height(20).padRight(5);
        t3.add(htp4).width(125f).row();
        t.add(t3).row();
        Table t4 = new Table();
        t4.add(sticky).width(20).height(20).padRight(5);
        t4.add(htp5).width(125f).row();
        t.add(t4).row();
        Table t5 = new Table();
        t5.add(cyclops).width(20).height(20).padRight(5);
        t5.add(htp6).width(125f).row();
        t.add(t5).row();
        t.add(enemies).row();
        Table t6 = new Table();
        t6.add(farmer).width(20).height(20).padRight(5);
        t6.add(htp7).width(125f).row();
        t.add(t6).row();
        Table t7 = new Table();
        t7.add(barbarian).width(20).height(20).padRight(5);
        t7.add(htp8).width(125f).row();
        t.add(t7).row();
        Table t8 = new Table();
        t8.add(thief).width(20).height(20).padRight(5);
        t8.add(htp9).width(125f).row();
        t.add(t8).row();
        Table t9 = new Table();
        t9.add(mage).width(20).height(20).padRight(5);
        t9.add(htp10).width(125f).row();
        t.add(t9).row();
        t.add(resources).row();
        Table t10 = new Table();
        t10.add(gold).width(20).height(20).padRight(5);
        t10.add(htp11).width(125f).row();
        t.add(t10).row();
        Table t11 = new Table();
        t11.add(lifes).width(20).height(20).padRight(5);
        t11.add(htp12).width(125f).row();
        t.add(t11).row();
        Table t12 = new Table();
        t12.add(rageButton).width(20).height(20).padRight(5);
        t12.add(htp13).width(125f).row();
        t.add(t12).row();

        ScrollPane scrollPane = new ScrollPane(t);
        root.add(scrollPane);
        root.setFillParent(true);
        root.setDebug(false);
        addActor(root);
    }
}
