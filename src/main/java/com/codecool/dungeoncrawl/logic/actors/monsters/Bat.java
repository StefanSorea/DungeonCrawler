package com.codecool.dungeoncrawl.logic.actors.monsters;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.actors.Actor;

public class Bat extends Monster{
    public Bat(Cell cell) {
        super(cell);
        this.setHealth(12);
        this.setDamage(2);
    }

    @Override
    public String getTileName() {
        return "bat";
    }
}