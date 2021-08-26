package com.codecool.dungeoncrawl.logic.actors.items;

import com.codecool.dungeoncrawl.logic.Cell;

public class Crown extends Item{
    public Crown(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return "crown";
    }
}
