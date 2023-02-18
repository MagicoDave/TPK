package com.mygdx.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.mygdx.menu.ChooseLevel;
import com.mygdx.menu.MainMenu;
import com.mygdx.tpk.TpkGame;

public class ChooseLevelScreen implements Screen {

    ChooseLevel chooseLevel;
    OrthographicCamera camera;

    public ChooseLevelScreen(TpkGame game){
        chooseLevel = new ChooseLevel(game);

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 160, 288);
    }
    @Override
    public void show() {

    }

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

    @Override
    public void dispose() {
        chooseLevel.dispose();
    }
}
