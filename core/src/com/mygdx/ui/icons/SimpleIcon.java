package com.mygdx.ui.icons;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Align;

public class SimpleIcon extends Image {

    Texture texture;
    Label label;
    Animation animation;
    TextureRegion currentFrame;

    float statetime = 0;
    int height;

    public SimpleIcon (String texturePath, String text, int height){
        this.height = height;

        Skin skin = new Skin(Gdx.files.internal("skin/arcade-ui.json"));
        label = new Label(text, skin, "default");
        label.setAlignment(Align.left);
        label.setFontScale(0.3f);
        texture = new Texture(Gdx.files.internal(texturePath));
        currentFrame = null;
        TextureRegion[] textures = {
                new TextureRegion(texture, 0, 0, 24, 24),
                new TextureRegion(texture, 24, 0, 24, 24),
                new TextureRegion(texture, 48, 0, 24, 24)
        };
        animation = new Animation(0.3f, textures);
        animation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
    }

    public void setText(String text){
        label.setText(text);
    }

    @Override
    public void act(float delta){
        currentFrame = (TextureRegion) animation.getKeyFrame(statetime += delta, true);
        super.act(delta);
        //Gdx.app.log("Current frame: ", animation.getKeyFrame(delta, true).toString());
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        Gdx.app.log("Current frame: ", currentFrame.toString());
        batch.draw(currentFrame, getX(), getY(), height, height);
        label.setBounds( getX() + height + 2, getY(),height, height);
        label.draw(batch, parentAlpha);
    }

}
