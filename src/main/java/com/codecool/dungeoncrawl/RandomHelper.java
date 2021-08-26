package com.codecool.dungeoncrawl;

import java.util.Random;

public class RandomHelper {
    public static int getRandomNumberInRange(int min, int max) {

        if (min > max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        else if(min == max){
            return min;
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

}
