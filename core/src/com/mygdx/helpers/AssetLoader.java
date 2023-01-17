package com.mygdx.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;

/**
 * AssetLoader
 *
 * Esta clase gestiona la carga de assets
 */
public class AssetLoader {

    public static TiledMap level1;

    public static LevelCreator levelCreator;

    public static Texture farmer;
    public static TextureRegion farmer1, farmer2, farmer3, farmer4;
    public static Animation farmerAnimation;

    public static Texture arrowTower;
    public static TextureRegion arrowTower1, arrowTower2, arrowTower3, arrowTower4;
    public static Animation arrowTowerAnimation;

    public static void load(){

        levelCreator = new LevelCreator();
        level1 = levelCreator.setLevel("maps/level1.tmx");

        //Farmer
        farmer = new Texture(Gdx.files.internal("enemies/farmer.png"));
        farmer.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        farmer1 = new TextureRegion(farmer, 0, 0, 24, 24);
        farmer2 = new TextureRegion(farmer, 24, 0, 24, 24);
        farmer3 = new TextureRegion(farmer, 48, 0, 24, 24);
        farmer4 = new TextureRegion(farmer, 72, 0, 24, 24);
        TextureRegion[] farmers = {farmer1, farmer2, farmer3, farmer4};
        farmerAnimation = new Animation(0.1f, farmers);
        farmerAnimation.setPlayMode(Animation.PlayMode.LOOP);

        //ArrowTower
        arrowTower = new Texture(Gdx.files.internal("towers/arrowtower.png"));
        arrowTower.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        arrowTower1 = new TextureRegion(farmer, 0, 0, 24, 24);
        arrowTower2 = new TextureRegion(farmer, 24, 0, 24, 24);
        arrowTower3 = new TextureRegion(farmer, 48, 0, 24, 24);
        arrowTower4 = new TextureRegion(farmer, 72, 0, 24, 24);
        TextureRegion[] atowers = {arrowTower1, arrowTower2, arrowTower3, arrowTower4};
        arrowTowerAnimation = new Animation(0.06f, atowers);
        arrowTowerAnimation.setPlayMode(Animation.PlayMode.LOOP);
    }

    public static void dispose(){
        level1.dispose();

        farmer.dispose();

        arrowTower.dispose();
    }

    public static LevelCreator getLevelCreator() {
        return levelCreator;
    }
}
