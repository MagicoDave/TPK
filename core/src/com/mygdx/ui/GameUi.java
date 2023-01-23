package com.mygdx.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.mygdx.gameworld.World;
import com.mygdx.ui.buttons.Button;

import java.util.ArrayList;

public class GameUi extends Stage {

    private final World world;
    private final Table table;
    private final ArrayList<Button> buttons = new ArrayList<>();

    public GameUi (World world) {
        super(new FitViewport(160, 280));

        Gdx.input.setInputProcessor(this);

        this.world = world;

        /*Table root = new Table();
        root.setFillParent(true);*/

        table = new Table();


    }

}
