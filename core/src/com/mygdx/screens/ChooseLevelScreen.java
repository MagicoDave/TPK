package com.mygdx.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.mygdx.menu.ChooseLevel;
import com.mygdx.menu.MainMenu;
import com.mygdx.tpk.TpkGame;

/**
 * Pantalla para selección de nivel
 * @see ChooseLevel
 */
public class ChooseLevelScreen implements Screen {

    ChooseLevel chooseLevel;
    OrthographicCamera camera;

    /**
     * Inicializa la screen con ChooseLevel
     * @param game referencia del juego
     */
    public ChooseLevelScreen(TpkGame game){
        chooseLevel = new ChooseLevel(game);

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 160, 288);
    }
    @Override
    public void show() {

    }

    /**
     * Renderiza los elementos de ChooseLevel y pone un fondo
     * @param delta
     */
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(242.0f/255.0f, 198.0f/255.0f, 75.0f/255.0f, 1.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        chooseLevel.act(delta);
        chooseLevel.draw();
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
        chooseLevel.dispose();
    }
}
