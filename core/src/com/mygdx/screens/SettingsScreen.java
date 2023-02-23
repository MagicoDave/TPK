package com.mygdx.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.mygdx.menu.Settings;
import com.mygdx.tpk.TpkGame;

/**
 * Pantalla para Settings
 * @see Settings
 */
public class SettingsScreen implements Screen {

    OrthographicCamera camera;
    Settings settings;

    /**
     * Inicializa la pantalla con Settings
     * @param game referencia del juego
     */
    public SettingsScreen(TpkGame game){
        settings = new Settings(game);

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 160, 288);
    }

    @Override
    public void show() {

    }

    /**
     * Renderiza los elementos de Settings y pone un fondo
     * @param delta tasa de refresco
     */
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(242.0f/255.0f, 198.0f/255.0f, 75.0f/255.0f, 1.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        settings.update(delta);
        settings.act(delta);
        settings.draw();
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
        this.dispose();
    }

    /**
     * Gestión de recursos cuando no son necesarios
     */
    @Override
    public void dispose() {
        settings.dispose();
    }
}
