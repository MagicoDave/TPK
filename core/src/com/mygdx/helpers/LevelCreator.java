package com.mygdx.helpers;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

public class LevelCreator {

    private TiledMap map;

    public TiledMap setLevel(String path) {
        map = new TmxMapLoader().load(path);
        parseMapObjects(map.getLayers().get("Object Layer").getObjects());
        return map;
    }

    private void parseMapObjects(MapObjects mapObjects) {
        for (MapObject mapObject : mapObjects) {

            if (mapObject instanceof RectangleMapObject && mapObject.getName() != null) {

                switch (mapObject.getName()) {

                }
            }
        }
    }
}
