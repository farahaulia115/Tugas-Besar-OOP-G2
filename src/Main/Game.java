
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
    private static Map map = Map.getMapInstance();
    private Inventory inventory;
    private static Time time;
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

    
    public static void isGameOver() {
        if (map.jumlahZombie() == 0 && time.getTotalSeconds() > 160) {
            statusGame = false;
            System.out.println("Player Win");
            System.out.println(" ________¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶ ");
            System.out.println("________¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶ ");
            System.out.println("___¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶");
            System.out.println("_¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶ ");
            System.out.println("¶¶¶¶______¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶_______¶¶¶¶");
            System.out.println("¶¶¶_______¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶________¶¶¶");
            System.out.println("¶¶________¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶________¶¶¶");
            System.out.println("¶¶¶_____¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶______¶¶¶");
            System.out.println("¶¶¶____¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶____¶¶¶¶ ");
            System.out.println("_¶¶¶___¶¶¶_¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶_¶¶¶____¶¶¶ ");
            System.out.println("_¶¶¶¶___¶¶¶_¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶_¶¶¶¶__¶¶¶¶ ");
            System.out.println("___¶¶¶¶__¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶_¶¶¶¶¶");
            System.out.println("____¶¶¶¶¶¶¶¶_¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶_¶¶¶¶¶¶¶¶¶");
            System.out.println("____¶¶¶¶¶¶¶¶_¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶_¶¶¶¶¶¶¶¶¶");
            System.out.println("______¶¶¶¶¶¶__¶¶¶¶¶¶¶¶¶¶¶¶¶¶___¶¶¶¶¶¶");
            System.out.println("_________________¶¶¶¶¶¶¶¶");
            System.out.println("___________________¶¶¶¶");
            System.out.println("___________________¶¶¶¶");
            System.out.println("___________________¶¶¶¶");
            System.out.println("_______________¶¶¶¶¶¶¶¶¶¶¶¶");
            System.out.println("____________¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶ ");
            System.out.println("____________¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶");
            System.out.println("____________¶¶¶____________¶¶¶");
            System.out.println("____________¶¶¶____________¶¶¶");
            System.out.println("____________¶¶¶____________¶¶¶");
            System.out.println("____________¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶");
            System.out.println("____________¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶");
            System.out.println("__________¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶");
            System.out.println("_________¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶");
            System.out.println("");
        } else if (map.jumlahZombie() == 0 && time.getTotalSeconds() < 20 && time.getDay() != 1) {
            statusGame = false;
            System.out.println("Player Win");
        } else if (map.zombieMenang()) {
            statusGame = false;
            System.out.println("Zombie Win");
        }
    }
    

    public void startGame(){
        if (deck.getDeck().size() != 6) {
            throw new IllegalArgumentException("Deck must have 6 plants");
        } else {
            Game.setGame();
        }
        
        
    }

    
}
