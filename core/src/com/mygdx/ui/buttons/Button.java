package com.mygdx.ui.buttons;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.gameworld.World;

public class Button extends Actor {

    World world;

    public Button(World world){
        this.world = world;
        setBounds(0, 0, 16, 16);
    }
}
