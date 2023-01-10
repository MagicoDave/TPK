package com.mygdx.helpers;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

/**
 * AssetLoader
 *
 * Esta clase gestiona el dibujo de recursos gráficos
 */
public class AssetLoader {

    private static TiledMap map;
    private static AssetManager manager;

    public static void load(){
        manager = new AssetManager();
        manager.setLoader(TiledMap.class, new TmxMapLoader());
        manager.load("maps/level1.txt", TiledMap.class);
    }

    public static void dispose(){
        manager.dispose();
    }
}
