package com.mygdx.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.mygdx.helpers.AssetLoader;
import com.mygdx.screens.MainMenuScreen;
import com.mygdx.tpk.TpkGame;

/**
 * Pantalla de créditos
 */
public class Credits extends Stage {

    TpkGame game;
    ScrollPane scroll;
    Label heada, headb, headc, headd, heade, headf, bodya, bodyb, bodyc, bodyd, bodye, bodyf, headz, bodyz;
    Button btnBack;

    /**
     * Inicializa la pantalla de créditos con todos sus elementos
     * @param game Referencia de game para moverse entre pantallas
     */
    public Credits(final TpkGame game){
        super(new StretchViewport(160,288));

        this.game = game;
        Gdx.input.setInputProcessor(this);
        Skin skin = AssetLoader.skinMother;

        headz = new Label(AssetLoader.myBundle.get("creditsZ").toUpperCase(), skin, "giygas");
        headz.setFontScale(0.4f);
        bodyz = new Label(AssetLoader.myBundle.get("creditsz"), skin, "default");
        bodyz.setFontScale(0.5f);
        heada = new Label(AssetLoader.myBundle.get("creditsA").toUpperCase(), skin, "giygas");
        heada.setFontScale(0.4f);
        bodya = new Label(AssetLoader.myBundle.get("creditsa"), skin, "default");
        bodya.setFontScale(0.5f);
        headb = new Label(AssetLoader.myBundle.get("creditsB").toUpperCase(), skin, "giygas");
        headb.setFontScale(0.4f);
        bodyb = new Label(AssetLoader.myBundle.get("creditsb"), skin, "default");
        bodyb.setFontScale(0.5f);
        headc = new Label(AssetLoader.myBundle.get("creditsC").toUpperCase(), skin, "giygas");
        headc.setFontScale(0.4f);
        bodyc = new Label(AssetLoader.myBundle.get("creditsc"), skin, "default");
        bodyc.setFontScale(0.5f);
        headd = new Label(AssetLoader.myBundle.get("creditsD").toUpperCase(), skin, "giygas");
        headd.setFontScale(0.4f);
        bodyd = new Label(AssetLoader.myBundle.get("creditsd"), skin, "default");
        bodyd.setFontScale(0.5f);
        heade = new Label(AssetLoader.myBundle.get("creditsE").toUpperCase(), skin, "giygas");
        heade.setFontScale(0.4f);
        bodye = new Label(AssetLoader.myBundle.get("creditse"), skin, "default");
        bodye.setFontScale(0.5f);
        headf = new Label(AssetLoader.myBundle.get("creditsF").toUpperCase(), skin, "giygas");
        headf.setFontScale(0.4f);
        bodyf = new Label(AssetLoader.myBundle.get("creditsf"), skin, "default");
        bodyf.setFontScale(0.5f);

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

        t.add(btnBack).left().top().width(20).height(20).padBottom(20);
        t.row();
        t.add(headz).row();
        t.add(bodyz).row();
        t.add(heada).row();
        t.add(bodya).row();
        t.add(headb).row();
        t.add(bodyb).row();
        t.add(headc).row();
        t.add(bodyc).row();
        t.add(headd).row();
        t.add(bodyd).row();
        t.add(heade).row();
        t.add(bodye).row();
        t.add(headf).row();
        t.add(bodyf).row();

        scroll = new ScrollPane(t);

        root.add(scroll);
        root.setFillParent(true);
        addActor(root);


    }
}
