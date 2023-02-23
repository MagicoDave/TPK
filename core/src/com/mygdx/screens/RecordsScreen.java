package com.mygdx.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.mygdx.menu.Records;
import com.mygdx.tpk.TpkGame;

/**
 * Pantalla para Records
 * @see Records
 */
public class RecordsScreen implements Screen {

    Records records;
    OrthographicCamera camera;

    /**
     * Inicializa la screen con Records
     * @param game referencia del juego
     */
    public RecordsScreen(TpkGame game){
        records = new Records(game);

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 160, 288);
    }
    @Override
    public void show() {

    }

    /**
     * Renderiza los elementos de Records y pone un fondo
     * @param delta
     */
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(242.0f/255.0f, 198.0f/255.0f, 75.0f/255.0f, 1.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        records.act(delta);
        records.draw();
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

    }

    /**
     * Gestión de recursos cuando no son necesarios
     */
    @Override
    public void dispose() {
        records.dispose();
    }
}
