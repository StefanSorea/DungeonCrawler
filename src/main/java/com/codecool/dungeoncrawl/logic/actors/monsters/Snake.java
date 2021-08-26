package com.codecool.dungeoncrawl.logic.actors.monsters;

import com.codecool.dungeoncrawl.logic.Cell;

public class Snake extends Monster{
    public Snake(Cell cell) {
        super(cell);
        this.setHealth(5);
        this.setDamage(2);
    }

    @Override
    public String getTileName() {
        return "snake";
    }
}
