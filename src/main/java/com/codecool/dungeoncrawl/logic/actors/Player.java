package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.Inventory;

public class Player extends Actor {
    private Integer playerHealth;
    private Inventory inventory;



    int damage;
    public Player(Cell cell) {
        super(cell);
        inventory = new Inventory();
        playerHealth = 100;
        damage = 7;
    }

    public String getTileName() {
        return "player";
    }

    public Inventory getInventory() {
        return inventory;
    }

    public int getDamage() {
        return damage;
    }

    public Integer getHealth() {
        return playerHealth;
    }

    public void takeDamage(Integer damageTaken){
        this.playerHealth = playerHealth - damageTaken;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

}
