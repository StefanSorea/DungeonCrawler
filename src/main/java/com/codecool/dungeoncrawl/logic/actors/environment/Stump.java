package com.codecool.dungeoncrawl.logic.actors.environment;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.actors.Actor;

public class Stump extends Actor {
    public Stump(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return "stump";
    }
}
