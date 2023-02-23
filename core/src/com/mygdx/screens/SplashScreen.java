package com.mygdx.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Align;
import com.mygdx.tpk.TpkGame;

/**
 * Pantalla de inicio cuando se abre el juego
 */
public class SplashScreen implements Screen {

    TpkGame game;
    Stage stage;
    Image image;
    Texture texture;
    /**
     * Se usa para no repetir el fadeOut del logo
     */
    boolean fadeOut = false;
    /**
     * Se usa para controlar el tiempo que lleva la pantalla en activo
     */
    float runTime = 0;

    /**
     * Inicializa SplashScreen con parámetros por defecto
     * @param game referencia de game para transición de pantallas
     */
    public SplashScreen(TpkGame game){
        stage = new Stage();
        this.game = game;

        image = new Image(texture = new Texture(Gdx.files.internal("splash/splash.png")));
        image.setSize(stage.getWidth()/2, stage.getWidth()/2);
        image.setPosition(stage.getWidth()/2, stage.getHeight()/2, Align.center);
        image.getColor().a = 0;
        image.addAction(Actions.fadeIn(2.0f));
        stage.addActor(image);

    }

    @Override
    public void show() {

    }

    /**
     * Renderiza los elementos de SplashScreen y pone un fondo
     * @param delta tasa de refresco
     */
    @Override
    public void render(float delta) {
        runTime += delta;
        //Fondo blanco
        Gdx.gl.glClearColor(255,255,255,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //Llamada a stage para que realice las acciones de sus actores y los dibuje
        stage.act();
        stage.draw();

        //Añade fade out a la imagen a los 4 segundos
        if (runTime > 4 && !fadeOut){
            image.addAction(Actions.fadeOut(2.0f));
            fadeOut = true;
        }
        //Se mueve a MainMenuScreen a los 6 segundos
        if (runTime > 6){
            game.setScreen(new MainMenuScreen(game));
        }
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
     * Disposición de recursos cuando no son necesarios
     */
    @Override
    public void dispose() {
        stage.dispose();
        texture.dispose();
    }
}
