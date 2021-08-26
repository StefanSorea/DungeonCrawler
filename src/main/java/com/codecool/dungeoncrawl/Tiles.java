package com.codecool.dungeoncrawl;

import com.codecool.dungeoncrawl.logic.Drawable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.HashMap;
import java.util.Map;

public class Tiles {
    public static int TILE_WIDTH = 32;

    private static Image tileset = new Image("/tiles.png", 543 * 2, 543 * 2, true, false);
    private static Map<String, Tile> tileMap = new HashMap<>();

    public static class Tile {
        public final int x, y, w, h;
        Tile(int i, int j) {
            x = i * (TILE_WIDTH + 2);
            y = j * (TILE_WIDTH + 2);
            w = TILE_WIDTH;
            h = TILE_WIDTH;
        }
    }

    static {
        
        tileMap.put("empty", new Tile(0, 0));
        tileMap.put("wall", new Tile(10, 17));
        tileMap.put("floor", new Tile(2, 0));
        tileMap.put("player", new Tile(29, 0));
        tileMap.put("skeleton", new Tile(29, 6));

        tileMap.put("sword", new Tile(1, 30));
        tileMap.put("bat", new Tile(26, 8));
        tileMap.put("cat", new Tile(30, 7));
        tileMap.put("door", new Tile(4, 11));
        tileMap.put("key", new Tile(17, 23));

        tileMap.put("fire", new Tile(13,31)); //fire 15, 10
        tileMap.put("heart", new Tile(26, 22)); //heart 26, 22

        tileMap.put("river", new Tile(12, 5));
        tileMap.put("bridge", new Tile(6, 5));
        tileMap.put("tree", new Tile(3, 1));
        tileMap.put("grass", new Tile(5, 0));
        tileMap.put("brick", new Tile(6, 13));
        tileMap.put("apple", new Tile(15, 29));
        tileMap.put("house", new Tile(7, 20));
        tileMap.put("potion", new Tile(16, 25));
        tileMap.put("devil", new Tile(27,2));
        tileMap.put("gate", new Tile(6, 3));

        tileMap.put("pavement", new Tile(1, 11));
        tileMap.put("pavement2", new Tile(16, 0));

        tileMap.put("sprite", new Tile(22, 8));
        tileMap.put("water", new Tile(8, 5));
        tileMap.put("bridge2", new Tile(13,16));
        tileMap.put("crown", new Tile(12, 24));
        tileMap.put("stone", new Tile(5, 2));
        tileMap.put("spriteBlue", new Tile(21, 7));
        tileMap.put("stump", new Tile(19, 6));
        tileMap.put("bonfire", new Tile(14, 10));
        tileMap.put("snake", new Tile(28, 8));
        tileMap.put("ghost", new Tile(20, 9));
        tileMap.put("wideRiver", new Tile(8, 4));


    }

    public static void drawTile(GraphicsContext context, Drawable d, int x, int y) {
        Tile tile = tileMap.get(d.getTileName());
        context.drawImage(tileset, tile.x, tile.y, tile.w, tile.h,
                x * TILE_WIDTH, y * TILE_WIDTH, TILE_WIDTH, TILE_WIDTH);
    }
}
