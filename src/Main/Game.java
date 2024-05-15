
package Main;

import Map.*;
import Thread.Time;





public class Game {
    private static boolean statusGame = true;
    private Map map = Map.getMapInstance();
    private Inventory inventory;
    private Time time;
    private Deck deck;

    public Game (Inventory inventory){
        this.inventory = inventory;
        Thread timeThread = new Thread(Time.getTime());
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
