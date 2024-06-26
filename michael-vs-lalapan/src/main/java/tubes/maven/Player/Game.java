
package tubes.maven.Player;


import java.io.IOException;
import tubes.maven.Map.*;
import tubes.maven.SaveManager.SaveLoadManager;
import tubes.maven.State.GameState;
import tubes.maven.State.MapState;
import tubes.maven.Thread.DeckThread;
import tubes.maven.Thread.Time; 

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
        if ((map.jumlahZombie() == 0 && time.getTotalSeconds() > 160)||(map.jumlahZombie() == 0 && time.getTotalSeconds() < 20 && time.getDay() != 1)) {
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
        DeckThread.resetDeckThread();
    }

    public void saveGame(String fileName){
        MapState mapState = map.getMapState();
        GameState gameState = new GameState(mapState, Sun.getAmount(), time.getTimeState(), deck.getDeckState(), deck.getPlantDeck());
        try {
            SaveLoadManager.saveGameState(gameState, fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

   public void loadGame(String fileName) {
    try {
        GameState gameState = SaveLoadManager.loadGameState(fileName);
        if (gameState != null) {
            // Perbarui objek Game sesuai dengan data yang dibaca dari JSON
            map.setMapState(gameState.getMapState());
            Sun.setSun(gameState.getamountSun());
            time.setTimeState(gameState.getTimeState());
            deck.setDeckState(gameState.getDeckState());
            deck.setPlantDeck(gameState.getPlantInDeck());
        } else {
            System.out.println("Failed to load game. GameState is null.");
        }
    } catch (IOException e) {
        System.out.println("Failed to load game. IOException occurred: " + e.getMessage());
    }
}


    
}
