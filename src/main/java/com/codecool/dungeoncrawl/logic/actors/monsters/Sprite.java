package com.codecool.dungeoncrawl.logic.actors.monsters;

import com.codecool.dungeoncrawl.logic.Cell;

public class Sprite extends Monster{
    public Sprite(Cell cell) {
        super(cell);
        this.setHealth(8);
        this.setDamage(5);
    }

    @Override
    public String getTileName() {
        return "sprite";
    }
}
