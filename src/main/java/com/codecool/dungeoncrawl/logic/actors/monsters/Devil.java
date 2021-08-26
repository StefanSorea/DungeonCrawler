package com.codecool.dungeoncrawl.logic.actors.monsters;

import com.codecool.dungeoncrawl.RandomHelper;
import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.GameMap;
import com.codecool.dungeoncrawl.logic.actors.Actor;

public class Devil extends Monster {
    public Devil(Cell cell) {
        super(cell);
        this.setHealth(30);
        this.setDamage(10);
    }

    @Override
    public String getTileName() {
        return "devil";
    }
}
