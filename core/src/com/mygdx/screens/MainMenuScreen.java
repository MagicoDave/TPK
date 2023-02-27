package com.mygdx.screens;
;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.helpers.AssetLoader;
import com.mygdx.helpers.ParallaxLayer;
import com.mygdx.menu.ChooseLevel;
import com.mygdx.menu.MainMenu;
import com.mygdx.tpk.TpkGame;

/**
 * Pantalla para MainMenu
 * @see MainMenu
 */
public class MainMenuScreen implements Screen {

    /**
     * Contenidos de la pantalla Main Menu
     */
    MainMenu mainMenu;

    /**
     * Cámara
     */
    OrthographicCamera camera;

    /**
     * Herramienta de dibujo
     */
    SpriteBatch batch;

    /**
     * Renderiza las distintas capas del parallax
     */
    ParallaxLayer[] layers;

    /**
     * Inicializa la screen con MainMenu
     * @param game referencia del juego
     */
    public MainMenuScreen(TpkGame game){
        mainMenu = new MainMenu(game);
        batch = new SpriteBatch();

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 160, 288);

        layers = new ParallaxLayer[5];
        layers[0] = new ParallaxLayer(AssetLoader.pBack, 0f, camera);
        layers[1] = new ParallaxLayer(AssetLoader.pClouds, 0.1f, camera);
        layers[2] = new ParallaxLayer(AssetLoader.pFarMount, 0.2f, camera);
        layers[3] = new ParallaxLayer(AssetLoader.pCloseMount, 0.3f, camera);
        layers[4] = new ParallaxLayer(AssetLoader.pRaid, 0.8f, camera);
    }

    @Override
    public void show() {

    }

    /**
     * Renderiza los elementos de MainMenu y pone un fondo
     * @param delta
     */
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(242.0f/255.0f, 198.0f/255.0f, 75.0f/255.0f, 1.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        for (ParallaxLayer pl: layers) {
            pl.render(batch);
        }
        batch.end();

        mainMenu.act(delta);
        mainMenu.draw();
        camera.position.x += 1.0f + Gdx.graphics.getDeltaTime();
        camera.update();
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
        mainMenu.dispose();
    }
}
