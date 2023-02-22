package com.mygdx.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.mygdx.menu.Credits;
import com.mygdx.tpk.TpkGame;

public class CreditsScreen implements Screen {

    Credits credits;
    OrthographicCamera camera;

    public CreditsScreen(TpkGame game){
        credits = new Credits(game);

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
        credits.act(delta);
        credits.draw();
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

    @Override
    public void dispose() {
        credits.dispose();
    }
}
