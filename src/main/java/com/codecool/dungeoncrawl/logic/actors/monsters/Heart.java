package com.codecool.dungeoncrawl.logic.actors.monsters;

import com.codecool.dungeoncrawl.logic.Cell;

public class Heart extends Monster {

    public Heart(Cell cell) {
        super(cell);
        this.setHealth(1);
        this.setDamage(-25);
    }

    @Override
    public String getTileName() {
        return "heart";
    }
}