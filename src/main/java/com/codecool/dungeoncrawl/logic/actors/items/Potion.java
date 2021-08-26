package com.codecool.dungeoncrawl.logic.actors.items;

import com.codecool.dungeoncrawl.logic.Cell;

public class Potion extends Item{
    public Potion(Cell cell) {
        super(cell);
    }

    @Override
    public String getTileName() {
        return "potion";
    }
}
