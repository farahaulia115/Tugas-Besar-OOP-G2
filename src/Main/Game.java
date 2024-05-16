
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

    public int getTime(){
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
        Thread timeThread = new Thread(time);
        timeThread.start();
        Thread deckThreat = new Thread(DeckThreat.getDeckThreatInstance(deck));
        deckThreat.start();
        while (timeThread.isAlive()) {
            try {
                Thread spawnerThread = new Thread(new SpawnZombie());
                Thread entityThread1 = new Thread(new Row1EntityThread());
                Thread entityThread2 = new Thread(new Row2EntityThread());
                Thread entityThread3 = new Thread(new Row3EntityThread());
                Thread entityThread4 = new Thread(new Row4EntityThread());
                Thread entityThread5 = new Thread(new Row5EntityThread());
                Thread entityThread6 = new Thread(new Row6EntityThread());

                Thread.sleep(1000); // Menghentikan thread selama 1 detik
                System.out.println("Current time : " + Time.getTime().getTotalSeconds() + " (" + Time.getTime().getCurrentPhase() + ")");

                spawnerThread.start();

                spawnerThread.join();
                entityThread1.start();
                entityThread2.start();
                entityThread3.start();
                entityThread4.start();
                entityThread5.start();
                entityThread6.start();

                entityThread1.join();
                entityThread2.join();
                entityThread3.join();
                entityThread4.join();
                entityThread5.join();
                entityThread6.join();
                
                map.renderMap();
                isGameOver();

            } catch (Exception e) {
                Thread.currentThread().interrupt();
            }
            
        }
        
        
    }

    
}
