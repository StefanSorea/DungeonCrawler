package com.codecool.dungeoncrawl.logic.actors.environment;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.actors.Actor;

public class River extends Actor {
    public River(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return "river";
    }
}
