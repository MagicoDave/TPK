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

    public static Texture farmer, barbarian, mage, thief;
    public static TextureRegion farmer1, farmer2, farmer3, farmer4, barbarian1, barbarian2, barbarian3, barbarian4, mage1, mage2, mage3, mage4, thief1, thief2, thief3, thief4;
    public static Animation farmerAnimation, barbarianAnimation, mageAnimation, thiefAnimation;

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

        //Barbarian
        barbarian = new Texture(Gdx.files.internal("enemies/barbarian.png"));
        barbarian.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        barbarian1 = new TextureRegion(barbarian, 0, 0, 24, 24);
        barbarian2 = new TextureRegion(barbarian, 24, 0, 24, 24);
        barbarian3 = new TextureRegion(barbarian, 48, 0, 24, 24);
        barbarian4 = new TextureRegion(barbarian, 72, 0, 24, 24);
        TextureRegion[] barbarians = {barbarian1, barbarian2, barbarian3, barbarian4};
        barbarianAnimation = new Animation(0.1f, barbarians);
        barbarianAnimation.setPlayMode(Animation.PlayMode.LOOP);

        //Mage
        mage = new Texture(Gdx.files.internal("enemies/mage.png"));
        mage.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        mage1 = new TextureRegion(mage, 0, 0, 24, 24);
        mage2 = new TextureRegion(mage, 24, 0, 24, 24);
        mage3 = new TextureRegion(mage, 48, 0, 24, 24);
        mage4 = new TextureRegion(mage, 72, 0, 24, 24);
        TextureRegion[] mages = {mage1, mage2, mage3, mage4};
        mageAnimation = new Animation(0.1f, mages);
        mageAnimation.setPlayMode(Animation.PlayMode.LOOP);

        //Thief
        thief = new Texture(Gdx.files.internal("enemies/thief.png"));
        thief.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        thief1 = new TextureRegion(thief, 0, 0, 24, 24);
        thief2 = new TextureRegion(thief, 24, 0, 24, 24);
        thief3 = new TextureRegion(thief, 48, 0, 24, 24);
        thief4 = new TextureRegion(thief, 72, 0, 24, 24);
        TextureRegion[] thiefs = {thief1, thief2, thief3, thief4};
        thiefAnimation = new Animation(0.1f, thiefs);
        thiefAnimation.setPlayMode(Animation.PlayMode.LOOP);

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
