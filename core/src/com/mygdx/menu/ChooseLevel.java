package com.mygdx.menu;

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
import com.mygdx.screens.GameScreen;
import com.mygdx.tpk.TpkGame;

public class ChooseLevel extends Stage {

    TpkGame game;
    ImageTextButton btnLevel1, btnLevel2;

    public ChooseLevel(final TpkGame game){
        super(new StretchViewport(160,288));
        this.game = game;
        Gdx.input.setInputProcessor(this);

        Skin skin = AssetLoader.skinMother;
        ImageTextButton.ImageTextButtonStyle style = skin.get("default", ImageTextButton.ImageTextButtonStyle.class);

        Label label = new Label("SELECT LEVEL", skin, "giygas");
        label.setPosition(15, 200);
        label.setFontScale(0.5f);

        btnLevel1 = new ImageTextButton("Level 1", style);
        btnLevel1.setPosition(40, 130);
        btnLevel1.addListener(new InputListener(){
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                AssetLoader.getLevelCreator().setLevel(AssetLoader.level1);
                game.setScreen(new GameScreen());
            }
        });

        btnLevel2 = new ImageTextButton("Level 2", style);
        btnLevel2.setPosition(40, 110);
        btnLevel2.addListener(new InputListener(){
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                AssetLoader.getLevelCreator().setLevel(AssetLoader.level2);
                game.setScreen(new GameScreen());
            }
        });

        Table table = new Table();
        table.add(btnLevel1);
        table.row();
        table.add(btnLevel2);
        table.setFillParent(true);
        table.center().padTop(20);

        addActor(label);
        addActor(table);
    }
}
