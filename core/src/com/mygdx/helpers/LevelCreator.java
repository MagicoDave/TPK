package com.mygdx.helpers;

import static com.mygdx.actors.tiles.Direction.UP;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.math.Rectangle;

public class LevelCreator {

    private TiledMap map;

    public TiledMap setLevel(String path) {
        map = new TmxMapLoader().load(path);
        parseMetadataObjects(map.getLayers().get("Metadata").getObjects());
        parseDirectionObjects(map.getLayers().get("Directions").getObjects());
        return map;
    }

    private void parseMetadataObjects(MapObjects mapObjects) {
        for (MapObject mapObject : mapObjects) {

            if (mapObject instanceof RectangleMapObject && mapObject.getName() != null) {

                switch (mapObject.getName()) {
                    case "SPAWN":
                        break;
                    case "FINISH_LANE":
                        break;
                    case "FUNDATION":
                        break;
                    default:
                        break;
                }
            }
        }
    }

    private void parseDirectionObjects(MapObjects mapObjects) {
        for (MapObject mapObject : mapObjects) {

            if (mapObject instanceof RectangleMapObject && mapObject.getName() != null) {

                switch (mapObject.getName()) {
                    case "UP":
                        break;
                    case "RIGHT":
                        break;
                    case "DOWN":
                        break;
                    case "LEFT":
                        break;
                    default:
                        break;
                }
            }
        }
    }
}
