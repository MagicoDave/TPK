package com.mygdx.helpers;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileSet;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

import java.util.Iterator;

/**
 * AssetLoader
 *
 * Esta clase gestiona el dibujo de recursos gráficos
 */
public class AssetLoader {

    public static TiledMap map;
    public static AssetManager manager;

    public static void load(){
        /*manager = new AssetManager();
        manager.setLoader(TiledMap.class, new TmxMapLoader());
        manager.load("maps/level1.txt", TiledMap.class);*/

        map = new TmxMapLoader().load("maps/level1.tmx");


    }

    public static void dispose(){
        map.dispose();
    }
}
