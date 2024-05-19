package Main;

import java.util.ArrayList;
import java.util.List;

import Exception.NotPlantableException;
import Exception.NotShovelableException;
import Map.Map;
import Plant.Plant;
import Plant.PlantFactory;
import Thread.Time;

public class Deck {

    private ArrayList<Plant> deck;

    public Deck(){
        deck = new ArrayList<>();
    }

    public List<Plant> getDeck(){
        return deck;
    }

    public boolean isEmpty(){
        return deck.isEmpty();
    }

    public boolean isSlotEmpty(int i){
        return deck.get(i) == null;
    }

    public void showDeck(){
        int i = 1;
        if (!deck.isEmpty()){
            for (Plant p: deck){
                System.out.println(i + " ." + deck.get(i-1).getName());
                i++;
            }
        } else {
            System.out.println("Deck is empty");
        }
        
    }

    public void pilihTanaman(int i) throws IllegalArgumentException, IllegalStateException{
        if (i < 0 || i >= deck.size()) {
            throw new IllegalArgumentException("Index out of bounds");
        } else {
            if (deck.get(i).getCost() > Sun.getAmount()){
                throw new IllegalArgumentException("Not enough sun to plant this plant");
            } else {
                
                DeckThreat deckThreat = DeckThreat.getDeckThreatInstance(this);
                if (deckThreat.getDeckStatus().get(i).isReadyToPlant()) {
                
                    deckThreat.getDeckStatus().get(i).setLastTimeCreated(Time.getTime().getTotalSeconds());
                } else {
                    throw new IllegalStateException("Plant is not ready to plant, need to wait " + (deckThreat.getDeckStatus().get(i).getLastTimeCreated() + 5 - Time.getTime().getTotalSeconds()) + " seconds");
            }
            }
            
        }
        
    }

    public void tanam(int i, int x, int y) throws IllegalArgumentException, IllegalStateException, NotPlantableException {
        DeckThreat deckThreat = DeckThreat.getDeckThreatInstance(this);
        if (x < 0 || x >= 6 || y < 1 || y >= 10) {
            throw new IllegalArgumentException("Index out of bounds");
        } else if (Map.getMapInstance().getMapDetail()[x][y].isAdaTanaman()) {
            throw new IllegalStateException("There is already a plant in this plot");
        } else {
            PlantFactory pabrik = new PlantFactory();
            Plant plant = pabrik.createPlant(deck.get(i).getName());
            Map.getMapInstance().tanamAt(x, y, plant);
            // Map.getMapInstance().tanamAt(x, y, new (deck.get(i)));
            deckThreat.getDeckStatus().get(i).setReadyToPlant(false);
        }
    }
    

    public void gali(int x, int y) throws IllegalArgumentException, NotShovelableException {
        if (x < 0 || x >= 6 || y < 1 || y >= 10) {
            throw new IllegalArgumentException("Index out of bounds");
        } else {
            Map.getMapInstance().getMapDetail()[x-1][y-1].gali();
        }
    }
    

    public void showDeckStatus() {
        int i = 1;
        System.out.println("+----------------------+-------+--------+");
        System.out.println("|      Deck Status     |       |        |");
        System.out.println("+----------------------+-------+--------+");
        System.out.println("| Plant Name           | Ready | Cost   |");
        System.out.println("+----------------------+-------+--------+");
        if (!deck.isEmpty()) {
            for (Plant p : deck) {
                System.out.println(String.format("| %-20s | %-5s | %-6d |", 
                    deck.get(i-1).getName(), 
                    DeckThreat.getDeckThreatInstance(this).getDeckStatus().get(i-1).isReadyToPlant(), 
                    deck.get(i-1).getCost()));
                i++;
            }
        } else {
            System.out.println("|                Deck is empty                |");
        }
        System.out.println("+----------------------+-------+--------+");
    }   

    public void resetDeck(){
        deck.clear();
    }



// jangan lupa tanganin kalo deck kosong gak bisa maen game
}
