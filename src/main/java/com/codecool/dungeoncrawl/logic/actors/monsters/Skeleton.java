package com.codecool.dungeoncrawl.logic.actors.monsters;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.actors.Actor;

public class Skeleton extends Monster {
    public Skeleton(Cell cell) {
        super(cell);
        this.setHealth(18);
        this.setDamage(9);
    }

    @Override
    public String getTileName() {
        return "skeleton";
    }
}
