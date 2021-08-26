package com.codecool.dungeoncrawl.logic.actors.environment;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.actors.Actor;

public class House extends Actor {
    public House(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return "house";
    }
}
