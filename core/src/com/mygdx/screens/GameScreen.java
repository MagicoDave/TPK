package com.mygdx.screens;

import com.badlogic.gdx.Screen;
import com.mygdx.gameworld.Renderer;
import com.mygdx.gameworld.World;
import com.mygdx.helpers.AssetLoader;
import com.mygdx.helpers.LevelCreator;
import com.mygdx.tpk.TpkGame;
import com.mygdx.ui.GameUi;

/**
 * Clase que controla la pantalla de juego
 */
public class GameScreen implements Screen {

    private World world;
    private Renderer renderer;
    private GameUi gameUi;

    private float runTime = 0; // runTime lleva la cuenta del tiempo que un objeto lleva en una animación determinada

    /**
     * Inicializar variables en el constructor
     */
    public GameScreen(TpkGame game, World.Level level){
        world = new World(AssetLoader.getLevelCreator(), game, level);
        gameUi = new GameUi(world);
        renderer = new Renderer(world, AssetLoader.getLevelCreator().getMap());
    }

    @Override
    public void show() {

    }

    /**
     * Llama a GameWorld para que se actualice y a continuación a GameRenderer para que dibuje.
     * También actualiza runTime.
     * @param delta La tasa de refresco
     */
    @Override
    public void render(float delta) {
        runTime += delta;
        world.update(delta);
        renderer.render(delta, runTime);
        gameUi.act(delta);
        gameUi.draw();
        gameUi.update(delta);
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
        world.dispose();
        gameUi.dispose();
    }
}
