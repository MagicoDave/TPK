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

/**
 * Esta clase gestiona el parseado de objetos del mapa (Tiles)
 */
public class LevelCreator {

    /**
     * Referencia del mapa a parsear
     */
    private TiledMap map;

    /**
     * Arrays de los objetos parseados
     */
    private Array<Tile> directionTiles, fundationTiles, spawnTile;

    /**
     * Tiles de spawn de enemigos y final de recorrido
     */
    private Tile finishTile;

    /**
     * Parsea los objetos de un mapa que se le pasa como parámetro
     * @param map El TiledMap a parsear
     */
    public void setLevel(TiledMap map) {
        this.map = map;
        //Se reasignan los arrays a uno nuevo cada vez que se llama al método
        spawnTile = new Array<Tile>();
        directionTiles = new Array<Tile>();
        fundationTiles = new Array<Tile>();
        //Se parsean los objetos del mapa. En mis TiledMaps, hay dos capas de objetos: Metadata y Directions, cada una con su método correspondiente
        parseMetadataObjects(map.getLayers().get("Metadata").getObjects());
        parseDirectionObjects(map.getLayers().get("Directions").getObjects());
    }

    /**
     * Crea nuevos Tiles de tipo SPAWN, FINISH_LINE y FUNDATION en función de los objetos parseados del mapa
     * @param mapObjects El array de objetos de la capa escogida del TiledMap
     */
    private void parseMetadataObjects(MapObjects mapObjects) {
        for (MapObject mapObject : mapObjects) {

            if (mapObject instanceof RectangleMapObject && mapObject.getName() != null) {

                switch (mapObject.getName()) {
                    case "SPAWN":
                        spawnTile.add(new Tile(null, Type.SPAWN,
                                ((RectangleMapObject) mapObject).getRectangle()));
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

    /**
     * Crea nuevos Tiles de tipo ROAD con su correspondiente Direction en función de los objetos parseados del mapa
     * @param mapObjects El array de objetos de la capa escogida del TiledMap
     */
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

    public TiledMap getMap() {
        return map;
    }

    public Array<Tile> getDirectionTiles() {
        return directionTiles;
    }

    public Array<Tile> getFundationTiles() {
        return fundationTiles;
    }

    public Array<Tile> getSpawnTile() {
        return spawnTile;
    }

    public Tile getFinishTile() {
        return finishTile;
    }
}
