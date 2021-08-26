package com.codecool.dungeoncrawl.logic.actors.monsters;

import com.codecool.dungeoncrawl.logic.Cell;

public class SpriteBlue extends Monster{
    public SpriteBlue(Cell cell) {
        super(cell);
        this.setHealth(3);
        this.setDamage(3);
    }

    @Override
    public String getTileName() {
        return "spriteBlue";
    }
}
