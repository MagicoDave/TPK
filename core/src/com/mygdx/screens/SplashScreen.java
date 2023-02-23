package com.mygdx.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.StretchViewport;

/**
 * Pantalla de inicio cuando se abre el juego
 */
public class SplashScreen implements Screen {

    Stage stage;
    Texture texture;

    float runTime = 0;

    /**
     * Carga los recursos de la SplashScreen
     */
    @Override
    public void show() {
        stage = new Stage();
        stage.setViewport(new StretchViewport(160,288));

        final Image image = new Image(texture = new Texture(Gdx.files.internal("splash/splash.png")));
        image.setSize(100, 100);
        image.setPosition(stage.getWidth()/2, stage.getHeight()/2, Align.center);
        stage.addActor(image);
    }

    /**
     * Renderiza los elementos de SplashScreen y pone un fondo
     * @param delta tasa de refresco
     */
    @Override
    public void render(float delta) {
        runTime += delta;

        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act();
        stage.draw();
        
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        dispose();
    }

    /**
     * Gestión de recursos cuando no son necesarios
     */
    @Override
    public void dispose() {
        stage.dispose();
        texture.dispose();
    }
}
