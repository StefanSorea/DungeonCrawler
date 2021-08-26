package com.codecool.dungeoncrawl.logic.actors.monsters;

import com.codecool.dungeoncrawl.Main;
import com.codecool.dungeoncrawl.RandomHelper;
import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.GameMap;
import com.codecool.dungeoncrawl.logic.actors.Actor;

public class Cat extends Monster {
    public Cat(Cell cell) {
        super(cell);
        this.setHealth(40);
        this.setDamage(15);
    }

    public void catMove(Actor bossCat, GameMap map){
        int row = bossCat.getY();
        int col = bossCat.getX();
        int newRow = 0;
        int newCol = 0;

        boolean searching = true;
        while(searching){
            newRow = RandomHelper.getRandomNumberInRange(row-1,row+1);
            newCol = RandomHelper.getRandomNumberInRange(col-1,col+1);
            if((newRow < 18 && newRow > 12) && (newCol < 23 && newCol > 18) && newRow != map.getPlayer().getY() &&  newCol != map.getPlayer().getX()){
                searching = false;
            }
        }

        bossCat.move(newCol-col,newRow - row);
    }

    @Override
    public String getTileName() {
        return "cat";
    }

    @Override
    public void takeDamage(Integer damageTaken) {
        super.takeDamage(damageTaken);
        if (health <= 0) {
            Main.levelOneDone = true;
        }
    }
}