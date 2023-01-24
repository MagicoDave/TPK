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

    public static Texture arrowTower, witchTower, stickyTower, cyclopTower;
    public static TextureRegion arrowTower1, arrowTower2, arrowTower3, arrowTower4, witchTower1, witchTower2, witchTower3, witchTower4, stickyTower1, stickyTower2, stickyTower3, stickyTower4, cyclopTower1, cyclopTower2, cyclopTower3, cyclopTower4;
    public static Animation arrowTowerAnimation, witchTowerAnimation, stickyTowerAnimation, cyclopTowerAnimation;

    public static Texture redBullet;
    public static TextureRegion redBullet1;

    public static void load(){

        //Levels
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
        arrowTower1 = new TextureRegion(arrowTower, 0, 0, 24, 24);
        arrowTower2 = new TextureRegion(arrowTower, 24, 0, 24, 24);
        arrowTower3 = new TextureRegion(arrowTower, 48, 0, 24, 24);
        arrowTower4 = new TextureRegion(arrowTower, 72, 0, 24, 24);
        TextureRegion[] atowers = {arrowTower1, arrowTower2, arrowTower3, arrowTower4};
        arrowTowerAnimation = new Animation(0.1f, atowers);
        arrowTowerAnimation.setPlayMode(Animation.PlayMode.LOOP);

        //WitchTower
        witchTower = new Texture(Gdx.files.internal("towers/witchtower.png"));
        witchTower.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        witchTower1 = new TextureRegion(witchTower, 0, 0, 24, 24);
        witchTower2 = new TextureRegion(witchTower, 24, 0, 24, 24);
        witchTower3 = new TextureRegion(witchTower, 48, 0, 24, 24);
        witchTower4 = new TextureRegion(witchTower, 72, 0, 24, 24);
        TextureRegion[] wtowers = {witchTower1, witchTower2, witchTower3, witchTower4};
        witchTowerAnimation = new Animation(0.1f, wtowers);
        witchTowerAnimation.setPlayMode(Animation.PlayMode.LOOP);

        //StickyTower
        stickyTower = new Texture(Gdx.files.internal("towers/stickytower.png"));
        stickyTower.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        stickyTower1 = new TextureRegion(stickyTower, 0, 0, 24, 24);
        stickyTower2 = new TextureRegion(stickyTower, 24, 0, 24, 24);
        stickyTower3 = new TextureRegion(stickyTower, 48, 0, 24, 24);
        stickyTower4 = new TextureRegion(stickyTower, 72, 0, 24, 24);
        TextureRegion[] stowers = {stickyTower1, stickyTower2, stickyTower3, stickyTower4};
        stickyTowerAnimation = new Animation(0.1f, stowers);
        stickyTowerAnimation.setPlayMode(Animation.PlayMode.LOOP);

        //CyclopTower
        cyclopTower = new Texture(Gdx.files.internal("towers/cycloptower.png"));
        cyclopTower.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        cyclopTower1 = new TextureRegion(cyclopTower, 0, 0, 24, 24);
        cyclopTower2 = new TextureRegion(cyclopTower, 24, 0, 24, 24);
        cyclopTower3 = new TextureRegion(cyclopTower, 48, 0, 24, 24);
        cyclopTower4 = new TextureRegion(cyclopTower, 72, 0, 24, 24);
        TextureRegion[] ctowers = {cyclopTower1, cyclopTower2, cyclopTower3, cyclopTower4};
        cyclopTowerAnimation = new Animation(0.1f, ctowers);
        cyclopTowerAnimation.setPlayMode(Animation.PlayMode.LOOP);

        //Redbullet
        redBullet = new Texture(Gdx.files.internal("bullets/redbullet.png"));
        redBullet.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        redBullet1 = new TextureRegion(redBullet, 0, 0, 24, 24);
    }

    public static void dispose(){
        level1.dispose();

        farmer.dispose();
        barbarian.dispose();
        thief.dispose();
        mage.dispose();

        arrowTower.dispose();
        witchTower.dispose();
        stickyTower.dispose();
        cyclopTower.dispose();
    }

    public static LevelCreator getLevelCreator() {
        return levelCreator;
    }
}
