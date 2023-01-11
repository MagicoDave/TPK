package com.mygdx.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class Renderer {

    private World world;
    private OrthographicCamera camera;
    private ShapeRenderer shapeRenderer;
    private OrthogonalTiledMapRenderer tiledMapRenderer;

    private SpriteBatch batcher;

    /**
     * Inicializar variables en el constructor
     * @param world Referencia del GameWorld para actualizar el estado/posición de los elementos cada vez que se dibujan
     */
    public Renderer(World world, TiledMap map){
        this.world = world;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 160, 280);
        camera.position.set(80, 100, 0);
        batcher = new SpriteBatch();
        batcher.setProjectionMatrix(camera.combined);
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(camera.combined);

        tiledMapRenderer = new OrthogonalTiledMapRenderer(map);
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

        camera.update();

        tiledMapRenderer.render();
        tiledMapRenderer.setView(camera);
    }
}
