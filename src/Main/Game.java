
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
        this.time = Time.getTime();
        this.inventory = inventory;
        deck = inventory.getDeck();
    }

    public static void setStatusGame(boolean status){
        statusGame = status;
    }

    public static void setGame(){
        statusGame = true;
    }

    public static boolean getStatusGame(){
        return statusGame;
    }

    public int getTime(){
        return time.getTotalSeconds();
    }

    
    public void isGameOver(){
        if (time.getTotalSeconds() > 160){
            statusGame = false;
        }
    }

    public void startGame(){

    }

    
}
