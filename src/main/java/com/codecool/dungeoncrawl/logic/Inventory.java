package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.logic.actors.Actor;
import com.codecool.dungeoncrawl.logic.actors.items.Crown;
import com.codecool.dungeoncrawl.logic.actors.items.Key;
import com.codecool.dungeoncrawl.logic.actors.items.Potion;
import com.codecool.dungeoncrawl.logic.actors.items.Sword;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    public static Map<Integer,Map<String,Integer>> inventory;
    public Inventory(){
        inventory = new HashMap<>();
    }

    public void addToInventory(Actor itemToAdd) {
        if(itemToAdd.getClass() == Sword.class){
            HashMap<String,Integer> itemStats = new HashMap<>();
            itemStats.put("damage",4);
            inventory.put(1,itemStats);
        }

        if(itemToAdd.getClass() == Key.class){
            inventory.put(2,null);
        }

        if (itemToAdd.getClass() == Potion.class) {
            HashMap<String,Integer> itemStats = new HashMap<>();
            itemStats.put("damage",10);
            inventory.put(3, itemStats);
        }
        if(itemToAdd.getClass() == Crown.class) {
            HashMap<String, Integer> itemStats = new HashMap<>();
            itemStats.put("damage", 20);
            inventory.put(4, itemStats);
        }
    }
}
