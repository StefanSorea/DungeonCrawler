package com.codecool.dungeoncrawl.logic;

public enum CellType {
    EMPTY("empty"),
    FLOOR("floor"),
    WALL("wall"),
    BRIDGE("bridge"),
    BRIDGE2("bridge2"),
    GRASS("grass"),
    BRICK("brick"),
    GATE("gate"),
    STONE("stone"),
    PAVEMENT2("pavement2");

//    PAVEMENT("pavement");

    private final String tileName;

    CellType(String tileName) {
        this.tileName = tileName;
    }

    public String getTileName() {
        return tileName;
    }
}
