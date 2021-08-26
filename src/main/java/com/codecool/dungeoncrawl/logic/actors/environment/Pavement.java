package com.codecool.dungeoncrawl.logic.actors.environment;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.actors.Actor;

public class Pavement extends Actor {
    public Pavement(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return "pavement";
    }
}
