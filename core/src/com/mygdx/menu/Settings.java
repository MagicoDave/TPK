package com.mygdx.menu;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.ImageTextButton;
import com.mygdx.tpk.TpkGame;

public class Settings extends Stage {

    TpkGame game;
    ImageButton btnEnglish, btnSpanish, btnGalician;

    public Settings(final TpkGame game){
        this.game = game;
    }
}
