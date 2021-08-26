package com.codecool.dungeoncrawl.logic.actors.monsters;

import com.codecool.dungeoncrawl.logic.Cell;

public class Fire extends Monster {
    public Fire(Cell cell) {
        super(cell);
        this.setHealth(1);
        this.setDamage(2);
    }

    @Override
    public String getTileName() {
        return "fire";
    }
}