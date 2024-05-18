
package Main;

import Map.*;
import Thread.Time; 

public class Game {
    private static boolean statusGame = false;
    private static Map map = Map.getMapInstance();
    private static Inventory inventory;
    private static Time time;
    private static Deck deck;

    public Game (){
        Game.time = Time.getTime();
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
        if ((map.jumlahZombie() == 0 && time.getTotalSeconds() > 10)||(map.jumlahZombie() == 0 && time.getTotalSeconds() < 20 && time.getDay() != 1)) {
            statusGame = false;
            System.out.println("Congratulation, you win the game");
            System.out.println("This is your reward");
            ASCIIart.piala();
            System.out.println("");
            resetGame();
        } else if (map.zombieMenang()) {
            statusGame = false;
            System.out.println("Arghhhhhhhhhhhh");
            System.out.println("Zombie entry to your house");
            System.out.println("You lose the game");
            ASCIIart.tengkorak();
            System.out.println("");
            resetGame();

        }
    }
    

    public void startGame(){
        if (deck.getDeck().size() != 6) {
            throw new IllegalArgumentException("Deck must have 6 plants");
        } else {
            Game.setGame();
        }
    }

    public static void resetGame(){
        map.resetMap();
        time.resetTimeData();
        inventory.resetInventory();
        deck.resetDeck();
        Sun.resetSun();
    }

    
}
