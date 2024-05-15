
package main;

import Map.*;
import Time.*;





public class Game {
    private static boolean statusGame = true;
    private Map map = Map.getMapInstance();
    private Inventory inventory;
    private Time time;
    private Deck deck;

    public Game (Inventory inventory){
        this.inventory = inventory;
        TimeThread timeThread = new TimeThread(time);
        timeThread.start();
        deck = inventory.getDeck();
    }


    public int getTime(){
        return time.getTotalSeconds();
    }

    
    public static boolean getStatusGame(){
        return statusGame;
    }

    public void startGame(){

    }

    
}
