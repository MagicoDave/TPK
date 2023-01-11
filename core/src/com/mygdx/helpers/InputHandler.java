package com.mygdx.helpers;

import com.badlogic.gdx.InputProcessor;
import com.mygdx.gameworld.World;

/**
 * InputHandler
 *
 * Esta clase gestiona los inputs del usuario
 *
 * Igual no termina siendo necesaria
 */
public class InputHandler implements InputProcessor {

    private World world;

    public InputHandler(World world, float scaleFactorX, float scaleFactorY){
        this.world = world;
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
