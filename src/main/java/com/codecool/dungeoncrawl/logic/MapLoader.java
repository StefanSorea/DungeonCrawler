package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.logic.actors.*;
import com.codecool.dungeoncrawl.logic.actors.environment.*;
import com.codecool.dungeoncrawl.logic.actors.items.Crown;
import com.codecool.dungeoncrawl.logic.actors.items.Key;
import com.codecool.dungeoncrawl.logic.actors.items.Potion;
import com.codecool.dungeoncrawl.logic.actors.items.Sword;
import com.codecool.dungeoncrawl.logic.actors.monsters.*;

import java.io.InputStream;
import java.util.Scanner;

public class MapLoader {
    public static GameMap loadMap(String mapPath) {
        InputStream is = MapLoader.class.getResourceAsStream(mapPath);
        Scanner scanner = new Scanner(is);
        int width = scanner.nextInt();
        int height = scanner.nextInt();

        scanner.nextLine(); // empty line

        GameMap map = new GameMap(width, height, CellType.EMPTY);
        for (int y = 0; y < height; y++) {
            String line = scanner.nextLine();
            for (int x = 0; x < width; x++) {
                if (x < line.length()) {
                    Cell cell = map.getCell(x, y);
                    switch (line.charAt(x)) {
                        case ' ':
                            cell.setType(CellType.EMPTY);
                            break;
                        case '#':
                            cell.setType(CellType.WALL);
                            break;
                        case '.':
                            cell.setType(CellType.FLOOR);
                            break;
                        case 's':
                            cell.setType(CellType.FLOOR);
                            new Skeleton(cell);
                            break;
                        case '@':
                            cell.setType(CellType.FLOOR);
                            map.setPlayer(new Player(cell));
                            break;
                        case 'x':
                            cell.setType(CellType.FLOOR);
                            new Sword(cell);
                            break;
                        case 'k':
                            cell.setType(CellType.FLOOR);
                            new Key(cell);
                            break;
                        case 'b':
                        cell.setType(CellType.FLOOR);
                        new Bat(cell);
                        break;
                        case 'c':
                            cell.setType(CellType.FLOOR);
                            new Cat(cell);
                            break;
                        case 'd':
                            cell.setType(CellType.FLOOR);
                            new Door(cell);
                            break;

                        case 'f':
                            cell.setType(CellType.FLOOR);
                            new Fire(cell);
                            break;
                        case 'h':
                            cell.setType(CellType.FLOOR);
                            new Heart(cell);
                            break;

                        case 'r':
                            cell.setType(CellType.WALL);
                            new River(cell);
                            break;
                        case 'p':
                            cell.setType(CellType.BRIDGE);
                            break;
                        case 't':
                            cell.setType(CellType.WALL);
                            new Tree(cell);
                            break;
                        case 'g':
                            cell.setType(CellType.GRASS);
                            break;
                        case 'e':
                            cell.setType(CellType.BRICK);
                            break;
                        case 'a':
                            cell.setType(CellType.FLOOR);
                            new Apple(cell);
                            break;
                        case 'i':
                            cell.setType(CellType.WALL);
                            new House(cell);
                            break;
                        case 'j':
                            cell.setType(CellType.FLOOR);
                            new Potion(cell);
                            break;
                        case 'l':
                            cell.setType(CellType.FLOOR);
                            new Devil(cell);
                            break;
                        case 'm':
                            cell.setType(CellType.GATE);
                            break;

                        case '5':
                            cell.setType(CellType.WALL);
                            new Pavement(cell);
                            break;
                        case '6':
                            cell.setType(CellType.FLOOR);
                            new Sprite(cell);
                            break;
                        case 'w':
                            cell.setType(CellType.WALL);
                            new Water(cell);
                            break;
                        case '4':
                            cell.setType(CellType.BRIDGE2);
                            break;
                        case '3':
                            cell.setType(CellType.FLOOR);
                            new Crown(cell);
                            break;
                        case '2':
                            cell.setType(CellType.STONE);
                            break;
                        case '1':
                            cell.setType(CellType.FLOOR);
                            new SpriteBlue(cell);
                            break;
                        case '0':
                            cell.setType(CellType.WALL);
                            new Stump(cell);
                            break;
                        case '7':
                            cell.setType(CellType.WALL);
                            new Bonfire(cell);
                            break;
                        case '8':
                            cell.setType(CellType.FLOOR);
                            new Snake(cell);
                            break;
                        case '9':
                            cell.setType(CellType.PAVEMENT2);
                            break;
                        case '`':
                            cell.setType(CellType.FLOOR);
                            new Ghost(cell);
                            break;
                        case '~':
                            cell.setType(CellType.WALL);
                            new WideRiver(cell);
                            break;


                        default:
                            throw new RuntimeException("Unrecognized character: '" + line.charAt(x) + "'");
                    }
                }
            }
        }
        return map;
    }

}
