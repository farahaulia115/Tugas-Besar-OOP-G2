
package Main;

import Map.*;
import Thread.Row1EntityThread;
import Thread.Row2EntityThread;
import Thread.Row3EntityThread;
import Thread.Row4EntityThread;
import Thread.Row5EntityThread;
import Thread.Row6EntityThread;
import Thread.Time; 

public class Game {
    private static boolean statusGame = false;
    private Map map = Map.getMapInstance();
    private Inventory inventory;
    private Time time;
    private Deck deck;

    public Game (){
        this.time = Time.getTime();
        inventory = new Inventory();
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
    public Time getTime(){
        return time;
    }

    public int getTotalSecondsTime(){
        return time.getTotalSeconds();
    }

    public Map getMap(){
        return map;
    }

    public Inventory getInventory(){
        return inventory;
    }

    public Deck getDeck(){
        return deck;
    }

    
    public void isGameOver() {
        if (map.jumlahZombie() == 0 && time.getTotalSeconds() > 160) {
            statusGame = false;
            System.out.println("Player Win");
        } else if (map.jumlahZombie() == 0 && time.getTotalSeconds() < 20 && time.getDay() != 1) {
            statusGame = false;
            System.out.println("Player Win");
        } else if (map.zombieMenang()) {
            statusGame = false;
            System.out.println("Zombie Win");
        }
    }
    

    public void startGame(){
        
        
    }

    
}
