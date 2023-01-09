package com.mygdx.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class GameRenderer {

    private GameWorld world;
    private OrthographicCamera camera;
    private ShapeRenderer shapeRenderer;

    private SpriteBatch batcher;

    /**
     * Inicializar variables en el constructor
     * @param world Referencia del GameWorld para actualizar el estado/posición de los elementos cada vez que se dibujan
     */
    public GameRenderer(GameWorld world){
        this.world = world;
        camera = new OrthographicCamera();
        camera.setToOrtho(true, 800, 480);
        batcher = new SpriteBatch();
        batcher.setProjectionMatrix(camera.combined);
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(camera.combined);
    }

    /**
     * Renderiza elementos según la tasa de refresco
     * @param delta Tasa de refresco
     * @param runTime En las animaciones, se usa para devolver el frame adecuado según el tiempo que lleve
     */
    public void render(float delta, float runTime){
        // Establece color verde y rellena el fondo con el
        Gdx.gl.glClearColor(0, 255, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }
}
