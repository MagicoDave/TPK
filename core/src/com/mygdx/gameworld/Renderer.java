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
import com.mygdx.actors.towers.Debuff;
import com.mygdx.actors.towers.Tower;
import com.mygdx.helpers.AssetLoader;
import com.mygdx.ui.GameUi;
import com.mygdx.ui.buttons.Button;

/**
 * Esta clase gestiona el dibujado de elementos
 */
public class Renderer {

    private World world;
    private OrthographicCamera camera;
    private ShapeRenderer shapeRenderer;
    private OrthogonalTiledMapRenderer tiledMapRenderer;

    private SpriteBatch batcher;

    private Animation farmerAnimation, farmerSlowedAnimation, barbarianAnimation, barbarianSlowedAnimation, mageAnimation, mageSlowedAnimation, thiefAnimation, thiefSlowedAnimation;
    private Animation arrowTowerAnimation, witchTowerAnimation, stickyTowerAnimation, cyclopTowerAnimation;
    private TextureRegion redBullet;

    /**
     * Inicializar variables en el constructor
     * @param world Referencia del GameWorld para actualizar el estado/posición de los elementos cada vez que se dibujan
     */
    public Renderer(World world, TiledMap map){
        this.world = world;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 160, 288);
        batcher = new SpriteBatch();
        batcher.setProjectionMatrix(camera.combined);
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(camera.combined);

        tiledMapRenderer = new OrthogonalTiledMapRenderer(map);

        farmerAnimation = AssetLoader.farmerAnimation;
        barbarianAnimation = AssetLoader.barbarianAnimation;
        mageAnimation = AssetLoader.mageAnimation;
        thiefAnimation = AssetLoader.thiefAnimation;

        farmerSlowedAnimation = AssetLoader.farmerSlowedAnimation;
        barbarianSlowedAnimation = AssetLoader.barbarianSlowedAnimation;
        mageSlowedAnimation = AssetLoader.mageSlowedAnimation;
        thiefSlowedAnimation = AssetLoader.thiefSlowedAnimation;

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
        switch (world.getLevel()){
            case LEVEL_1:
                Gdx.gl.glClearColor(0, 255, 0, 1);
                break;
            case LEVEL_2:
                Gdx.gl.glClearColor(12.0f/255.0f, 46.0f/255.0f, 0.0f, 1);
                break;
        }
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

    /**
     * Renderización de los enemigos
     * @param runTime En las animaciones, se usa para devolver el frame adecuado según el tiempo que lleve
     */
    public void renderEnemies(float runTime){
        for (Enemy enemy: world.enemiesInScreen) {
            Animation animation = null;
            switch (enemy.getID()) {
                case 0:
                    if (enemy.getDebuff() == Debuff.SLOW){
                        animation = farmerSlowedAnimation;
                    } else {
                        animation = farmerAnimation;
                    }
                    break;
                case 1:
                    if (enemy.getDebuff() == Debuff.SLOW){
                        animation = barbarianSlowedAnimation;
                    } else {
                        animation = barbarianAnimation;
                    }
                    break;
                case 2:
                    if (enemy.getDebuff() == Debuff.SLOW){
                        animation = mageSlowedAnimation;
                    } else {
                        animation = mageAnimation;
                    }
                    break;
                case 3:
                    if (enemy.getDebuff() == Debuff.SLOW){
                        animation = thiefSlowedAnimation;
                    } else {
                        animation = thiefAnimation;
                    }
                    break;
            }
            if (enemy.getDebuff() == Debuff.SLOW){
                animation.setFrameDuration(0.2f);
            } else {
                animation.setFrameDuration(0.1f);
            }
            batcher.draw(
                    (TextureRegion) animation.getKeyFrame(runTime, true),
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
        }
    }

    /**
     * Renderizado de las torres
     * @param runTime En las animaciones, se usa para devolver el frame adecuado según el tiempo que lleve
     */
    public void renderTowers(float runTime){
        for (Tower tower: world.constructedTowers) {
            Animation animation = null;
            switch (tower.getID()) {
                case 0:
                    animation = arrowTowerAnimation;
                    break;
                case 1:
                    animation = witchTowerAnimation;
                    break;
                case 2:
                    animation = stickyTowerAnimation;
                    break;
                case 3:
                    animation = cyclopTowerAnimation;
                    break;
            }
            if (tower.isEnraged()){
                animation.setFrameDuration(0.05f);
            } else {
                animation.setFrameDuration(0.1f);
            }
            batcher.draw(
                    (TextureRegion) animation.getKeyFrame(runTime, true),
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
        }
    }

    /**
     * Renderizado de los proyectiles de las torres
     * @param runTime En las animaciones, se usa para devolver el frame adecuado según el tiempo que lleve
     */
    public void renderBullets(float runTime){
        for (Bullet bullet : world.bulletsInScreen){
            batcher.draw(
                    redBullet,
                    bullet.getPosition().x,
                    bullet.getPosition().y,
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
