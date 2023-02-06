package com.mygdx.ui.buttons;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.gameworld.World;

/**
 * Clase base para botones, de esta clase heredan el resto de botones
 */
public abstract class Button extends Actor {

    World world;
    Texture texture;
    boolean isPressed = false;

    public Button(World world){
        this.world = world;
        texture = new Texture(Gdx.files.internal("bullets/redbullet.png")); //Textura placeholder para testear botones
        setBounds(0, 0, 20, 20);
    }

    public boolean isTouchDown(float screenX, float screenY) {
        Rectangle hitbox = new Rectangle(this.getX(), this.getY(), this.getWidth(), this.getHeight());
        if (hitbox.contains(screenX, screenY)) {
            isPressed = true;
            return true;
        }
        return false;
    }

    public boolean isTouchUp(float screenX, float screenY) {
        Rectangle hitbox = new Rectangle(this.getX(), this.getY(), this.getWidth(), this.getHeight());
        if (hitbox.contains(screenX, screenY) && isPressed) {
            isPressed = false;
            return true;
        }

        isPressed = false;
        return false;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(texture, getX(), getY(), getWidth(), getHeight());
    }

}
