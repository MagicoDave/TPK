package com.mygdx.helpers;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Se usa para dibujar las capas del parallax del menú principal
 */
public class ParallaxLayer {
    Texture texture;
    float factor;
    Camera camera;

    /**
     * Inicia una capa del parallax
     * @param texture La textura que se usa para la capa
     * @param factor La velocidad del movimiento
     * @param camera La cámara de la pantalla
     */
    public ParallaxLayer(Texture texture, float factor, Camera camera){
        this.texture = texture;
        this.factor = factor;
        this.camera = camera;
        this.texture.setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.ClampToEdge);
    }

    /**
     * Renderiza la capa del parallax
     * @param batch El SpriteBatch que se usará para dibujar
     */
    public void render (SpriteBatch batch){
        int xOffset = (int) (camera.position.x * factor);
        TextureRegion region = new TextureRegion(texture);
        region.setRegionX(xOffset % (int) texture.getWidth());
        region.setRegionY(0);
        region.setRegionWidth((int) texture.getWidth());
        region.setRegionHeight((int) camera.viewportHeight);

//        region.setRegionWidth((int) camera.viewportWidth);
//        region.setRegionHeight((int) texture.getHeight());
//        region.setRegionX(xOffset % (int) texture.getWidth());
//        region.setRegionY(0);
        batch.draw(region, camera.position.x - camera.viewportWidth/2, camera.position.y - camera.viewportHeight/2);
    }
}
