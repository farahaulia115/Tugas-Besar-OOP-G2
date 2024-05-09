
package Main;

import Map.*;
import Plant.*;
import Time.*;
import Util.*;
import Exception.*;
import Zombie.*;
import java.lang.Math;
import java.util.Random;


public class Game {
    private static boolean statusGame = true;
    private Map map;
    private Inventory inventory;
    private Time time;
    private ZombieFactory factory;

    public Game (){
        time = new Time();
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

    public void spawnZombie() {
        double probabilityTile = 0.33;
        for (int i = 0; i < 6; i++) {
            if (Math.random() < probabilityTile) {
                int jenisZombie = new Random().nextInt(10) + 1;
                Zombie newZombie = factory.createZombie(jenisZombie);
                map.getMapDetail()[i][1].getZombieList().add(newZombie);
                newZombie.setPosition(i, 1);
            }
        }
    }
    
}
