package com.codecool.dungeoncrawl.logic.actors.monsters;

import com.codecool.dungeoncrawl.logic.Cell;

public class Apple extends Monster{
    public Apple(Cell cell) {
        super(cell);
        this.setHealth(1);
        this.setDamage(-10);
    }

    @Override
    public String getTileName() {
        return "apple";
    }
}
