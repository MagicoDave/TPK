package com.mygdx.ui;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

/**
 * Esta clase permite crear imagenes animadas simples
 */
public class AnimatedImage extends Image {

    protected Animation animation = null;
    /**
     * Se usa para determinar el frame actual de la animación
     */
    private float stateTime = 0;

    /**
     * Inicializa la imagen a partir de parametros
     * @param animation La animación en cuestión
     */
    public AnimatedImage(Animation animation) {
        super((TextureRegion) animation.getKeyFrame(0)); //Se inicializa en el frame 0 de la animación
        this.animation = animation;
    }

    /**
     * Actualiza al frame adecuado de la animación
     * @param delta Tasa de refresco
     */
    @Override
    public void act(float delta)
    {
        ((TextureRegionDrawable)getDrawable()).setRegion((TextureRegion) animation.getKeyFrame(stateTime+=delta, true));
        super.act(delta);
    }
}
