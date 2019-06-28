package sample;

import java.util.Random;

public class Die {

    static int MAX = 6;
    static int MIN = 1;
    int number;


    public int roll(){

        Random random = new Random();

        number = random.nextInt((MAX-MIN)+1) + MIN;

        return number;
    }


    public void setDie(int number){

        this.number = number;

    }

    public int getDie(){

        return number;
    }
}
