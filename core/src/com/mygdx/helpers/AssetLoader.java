package com.mygdx.helpers;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

/**
 * AssetLoader
 *
 * Esta clase gestiona la carga de assets
 */
public class AssetLoader {

    public static TiledMap level1;

    public static LevelCreator levelCreator;

    public static void load(){

        /*map = new TmxMapLoader().load("maps/level1.tmx");
        objectLayer = (TiledMapTileLayer) map.getLayers().get("Object Layer");
        MapObjects objects = objectLayer.getObjects();*/
        levelCreator = new LevelCreator();
        level1 = levelCreator.setLevel("maps/level1.tmx");

    }

    public static void dispose(){
        level1.dispose();
    }
}
