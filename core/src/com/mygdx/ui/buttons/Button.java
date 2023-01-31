package com.mygdx.ui.buttons;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.gameworld.World;

public class Button extends Actor {

    World world;
    Texture texture;

    public Button(World world){
        this.world = world;
        texture = new Texture(Gdx.files.internal("bullets/redbullet.png"));
        setBounds(0, 0, 16, 16);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(texture, getX(), getY(), getWidth(), getHeight());
    }

}
