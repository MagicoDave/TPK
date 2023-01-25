package com.mygdx.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.mygdx.actors.enemies.Enemy;
import com.mygdx.actors.towers.Bullet;
import com.mygdx.actors.towers.Tower;
import com.mygdx.helpers.AssetLoader;

/**
 * Esta clase gestiona el dibujado de elementos
 */
public class Renderer {

    private World world;
    private OrthographicCamera camera;
    private ShapeRenderer shapeRenderer;
    private OrthogonalTiledMapRenderer tiledMapRenderer;

    private SpriteBatch batcher;

    private Animation farmerAnimation, barbarianAnimation, mageAnimation, thiefAnimation;
    private Animation arrowTowerAnimation, witchTowerAnimation, stickyTowerAnimation, cyclopTowerAnimation;
    private TextureRegion redBullet;

    /**
     * Inicializar variables en el constructor
     * @param world Referencia del GameWorld para actualizar el estado/posición de los elementos cada vez que se dibujan
     */
    public Renderer(World world, TiledMap map){
        this.world = world;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 160, 284);
        batcher = new SpriteBatch();
        batcher.setProjectionMatrix(camera.combined);
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(camera.combined);

        tiledMapRenderer = new OrthogonalTiledMapRenderer(map);

        farmerAnimation = AssetLoader.farmerAnimation;
        barbarianAnimation = AssetLoader.barbarianAnimation;
        mageAnimation = AssetLoader.mageAnimation;
        thiefAnimation = AssetLoader.thiefAnimation;

        arrowTowerAnimation = AssetLoader.arrowTowerAnimation;
        witchTowerAnimation = AssetLoader.witchTowerAnimation;
        stickyTowerAnimation = AssetLoader.stickyTowerAnimation;
        cyclopTowerAnimation = AssetLoader.cyclopTowerAnimation;

        redBullet = AssetLoader.redBullet1;
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

        batcher.begin();
        renderEnemies(runTime);
        renderTowers(runTime);
        renderBullets(runTime);
        batcher.end();
    }

    public void renderEnemies(float runTime){
        for (Enemy enemy: world.enemiesInScreen) {
            switch (enemy.getID()) {
                case 0:
                    batcher.draw(
                            (TextureRegion) farmerAnimation.getKeyFrame(runTime, true),
                            enemy.getX(),
                            enemy.getY(),
                            enemy.getWidth() / 2.0f,
                            enemy.getHeight() / 2.0f,
                            enemy.getWidth(),
                            enemy.getHeight(),
                            1,
                            1,
                            enemy.getRotation()
                    );
                    break;
                case 1:
                    batcher.draw(
                            (TextureRegion) barbarianAnimation.getKeyFrame(runTime, true),
                            enemy.getX(),
                            enemy.getY(),
                            enemy.getWidth() / 2.0f,
                            enemy.getHeight() / 2.0f,
                            enemy.getWidth(),
                            enemy.getHeight(),
                            1,
                            1,
                            enemy.getRotation()
                    );
                    break;
                case 2:
                    batcher.draw(
                            (TextureRegion) mageAnimation.getKeyFrame(runTime, true),
                            enemy.getX(),
                            enemy.getY(),
                            enemy.getWidth() / 2.0f,
                            enemy.getHeight() / 2.0f,
                            enemy.getWidth(),
                            enemy.getHeight(),
                            1,
                            1,
                            enemy.getRotation()
                    );
                    break;
                case 3:
                    batcher.draw(
                            (TextureRegion) thiefAnimation.getKeyFrame(runTime, true),
                            enemy.getX(),
                            enemy.getY(),
                            enemy.getWidth() / 2.0f,
                            enemy.getHeight() / 2.0f,
                            enemy.getWidth(),
                            enemy.getHeight(),
                            1,
                            1,
                            enemy.getRotation()
                    );
                    break;
            }
        }
    }

    public void renderTowers(float runTime){
        for (Tower tower: world.constructedTowers) {
            switch (tower.getID()) {
                case 0:
                    batcher.draw(
                            (TextureRegion) arrowTowerAnimation.getKeyFrame(runTime, true),
                            tower.getX(),
                            tower.getY(),
                            tower.getWidth() / 2.0f,
                            tower.getHeight() / 2.0f,
                            tower.getWidth(),
                            tower.getHeight(),
                            1,
                            1,
                            tower.getRotation()
                    );
                    break;
                case 1:
                    batcher.draw(
                            (TextureRegion) witchTowerAnimation.getKeyFrame(runTime, true),
                            tower.getX(),
                            tower.getY(),
                            tower.getWidth() / 2.0f,
                            tower.getHeight() / 2.0f,
                            tower.getWidth(),
                            tower.getHeight(),
                            1,
                            1,
                            tower.getRotation()
                    );
                    break;
                case 2:
                    batcher.draw(
                            (TextureRegion) stickyTowerAnimation.getKeyFrame(runTime, true),
                            tower.getX(),
                            tower.getY(),
                            tower.getWidth() / 2.0f,
                            tower.getHeight() / 2.0f,
                            tower.getWidth(),
                            tower.getHeight(),
                            1,
                            1,
                            tower.getRotation()
                    );
                    break;
                case 3:
                    batcher.draw(
                            (TextureRegion) cyclopTowerAnimation.getKeyFrame(runTime, true),
                            tower.getX(),
                            tower.getY(),
                            tower.getWidth() / 2.0f,
                            tower.getHeight() / 2.0f,
                            tower.getWidth(),
                            tower.getHeight(),
                            1,
                            1,
                            tower.getRotation()
                    );
                    break;
            }
        }
    }

    public void renderBullets(float runTime){
        for (Bullet bullet : world.bulletsInScreen){
            batcher.draw(
                    redBullet,
                    bullet.getX(),
                    bullet.getY(),
                    bullet.getWidth() / 2.0f,
                    bullet.getHeight() / 2.0f,
                    bullet.getWidth(),
                    bullet.getHeight(),
                    0.5f,
                    0.5f,
                    bullet.getRotation()
            );
        }
    }
}
