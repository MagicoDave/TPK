package com.mygdx.helpers;

import static com.mygdx.actors.tiles.Direction.DOWN;
import static com.mygdx.actors.tiles.Direction.LEFT;
import static com.mygdx.actors.tiles.Direction.RIGHT;
import static com.mygdx.actors.tiles.Direction.UP;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.mygdx.actors.tiles.Direction;
import com.mygdx.actors.tiles.Tile;
import com.mygdx.actors.tiles.Type;

public class LevelCreator {

    private TiledMap map;

    private Array<Tile> directionTiles = new Array<Tile>();
    private Array<Tile> fundationTiles = new Array<Tile>();

    private Tile spawnTile;
    private Tile finishTile;

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
                        spawnTile = new Tile(null, Type.SPAWN,
                                ((RectangleMapObject) mapObject).getRectangle());
                        break;
                    case "FINISH_LINE":
                        finishTile = new Tile(null, Type.FINISH_LINE,
                                ((RectangleMapObject) mapObject).getRectangle());
                        break;
                    case "FUNDATION":
                        fundationTiles.add(new Tile(null, Type.FUNDATION,
                                ((RectangleMapObject) mapObject).getRectangle()));
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
                        directionTiles.add(new Tile(UP, Type.ROAD,
                                ((RectangleMapObject) mapObject).getRectangle()));
                        break;
                    case "RIGHT":
                        directionTiles.add(new Tile(RIGHT, Type.ROAD,
                                ((RectangleMapObject) mapObject).getRectangle()));
                        break;
                    case "DOWN":
                        directionTiles.add(new Tile(DOWN, Type.ROAD,
                                ((RectangleMapObject) mapObject).getRectangle()));
                        break;
                    case "LEFT":
                        directionTiles.add(new Tile(LEFT, Type.ROAD,
                                ((RectangleMapObject) mapObject).getRectangle()));
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public Array<Tile> getDirectionTiles() {
        return directionTiles;
    }

    public Array<Tile> getFundationTiles() {
        return fundationTiles;
    }

    public Tile getSpawnTile() {
        return spawnTile;
    }

    public Tile getFinishTile() {
        return finishTile;
    }
}
