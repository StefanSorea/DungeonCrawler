package com.codecool.dungeoncrawl.logic.actors.monsters;

import com.codecool.dungeoncrawl.logic.Cell;

public class Ghost extends Monster{
    public Ghost(Cell cell) {
        super(cell);
        this.setHealth(10);
        this.setDamage(5);
    }

    @Override
    public String getTileName() {
        return "ghost";
    }
}
