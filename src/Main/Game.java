
package main;

import Map.*;
import Plant.*;
import Time.*;
import Util.*;
import Zombie.*;
// import exception.*;

// import java.lang.Math;
// import java.util.Random;



public class Game {
    private static boolean statusGame;;
    private Map map = Map.getMapInstance();
    private Inventory inventory;
    private Time time = Time.getTime();
    private Deck deck = inventory.getDeck();

    public Game (){
        inventory = new Inventory();
        TimeThread timeThread = new TimeThread(time);
        timeThread.start();
    }

    public Time getTime(){
        return time;
    }

    
    public static boolean getStatusGame(){
        return statusGame;
    }

    public void startGame(){

    }

    // public void spawnZombie() {
    //     double probabilityTile = 0.3;
    //     for (int i = 0; i < 6; i++) {
    //         if (Math.random() < probabilityTile) {
    //             int jenisZombie = new Random().nextInt(10) + 1;
    //             Zombie newZombie = factory.createZombie(jenisZombie);
    //             map.getMapDetail()[i][1].getZombieList().add(newZombie);
    //             newZombie.setPosition(i, 1);
    //         }
    //     }
    // }
    
}
