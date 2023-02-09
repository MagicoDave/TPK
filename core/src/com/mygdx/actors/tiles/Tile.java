package com.mygdx.actors.tiles;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.mygdx.actors.towers.Tower;

public class Tile extends Image {

    private Direction direction;
    private Type type;
    private Rectangle hitbox;

    private Tower tower;

    private boolean isSelected;

    Texture texture;
    TextureRegion currentFrame;
    Animation animation;

    float statetime;

    public Tile(Direction direction, Type type, Rectangle hitbox) {
        this.direction = direction;
        this.type = type;
        this.hitbox = hitbox;

        tower = null;

        isSelected = false;
        currentFrame = null;

        statetime = 0;
        texture = new Texture(Gdx.files.internal("ui/fundationSelected.png"));
        TextureRegion[] textures = {
                new TextureRegion(texture, 0, 0, 24, 24),
                new TextureRegion(texture, 24, 0, 24, 24),
                new TextureRegion(texture, 48, 0, 24, 24)
        };
        animation = new Animation(0.3f, textures);
        animation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);

    }

    public boolean isTouchDown(float screenX, float screenY) {
        if (hitbox.contains(screenX, screenY)) {
            return true;
        }
        return false;
    }

    public boolean isTouchUp(float screenX, float screenY) {
        if (hitbox.contains(screenX, screenY) /*&& isPressed*/) {
            return true;
        }

        return false;
    }

    @Override
    public void act(float delta){
        currentFrame = (TextureRegion) animation.getKeyFrame(statetime += delta, true);
        super.act(delta);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        if (type == Type.FUNDATION && isSelected){
            batch.draw(currentFrame, getX(), getY(), getWidth(), getHeight());
        }
    }

    public Direction getDirection() {
        return direction;
    }

    public Type getType() {
        return type;
    }

    public Rectangle getHitbox() {
        return hitbox;
    }

    public void setHitbox(Rectangle hitbox) {
        this.hitbox = hitbox;
    }

    public boolean isFundation() {
        if (type == Type.FUNDATION){
            return true;
        } else {
            return false;
        }
    }

    public Tower getTower() {
        return tower;
    }

    public void setTower(Tower tower) {
        this.tower = tower;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
