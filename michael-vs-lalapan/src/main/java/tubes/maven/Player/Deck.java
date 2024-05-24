package tubes.maven.Player;

import java.util.ArrayList;
import java.util.List;

import tubes.maven.Exception.NotPlantableException;
import tubes.maven.Exception.NotShovelableException;
import tubes.maven.Map.*;
import tubes.maven.Plant.*;
import tubes.maven.State.DeckState;
import tubes.maven.State.PlantDeck;
import tubes.maven.State.StatusDeckState;
import tubes.maven.Thread.DeckThread;
import tubes.maven.Thread.StatusDeck;
import tubes.maven.Thread.Time;

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

    public void showDeck(){
        int i = 1;
        if (!deck.isEmpty()){
            for (Plant p : deck){
                System.out.println(i + " ." + deck.get(i-1).getName());
                i++;
            }
        } else {
            System.out.println("Deck is empty");
        }
        
    }

    public DeckState getDeckState(){
        List<StatusDeckState> deckStatus = new ArrayList<>();
        for (StatusDeck statusDeck : DeckThread.getDeckThreadInstance(this).getDeckStatus()){
            deckStatus.add(new StatusDeckState(statusDeck.isReadyToPlant(), statusDeck.getLastTimeCreated(), statusDeck.getInterval()));
        }
        return new DeckState(deckStatus);
    }

    public void pilihTanaman(int i) throws IllegalArgumentException, IllegalStateException{
        if (i < 0 || i >= deck.size()) {
            throw new IllegalArgumentException("Index out of bounds");
        } else {
            if (deck.get(i).getCost() > Sun.getAmount()){
                throw new IllegalArgumentException("Not enough sun to plant this plant");
            } else {
                
                DeckThread deckThread = DeckThread.getDeckThreadInstance(this);
                if (deckThread.getDeckStatus().get(i).isReadyToPlant()) {
                
                    deckThread.getDeckStatus().get(i).setLastTimeCreated(Time.getTime().getTotalSeconds());
                } else {
                    throw new IllegalStateException("Plant is not ready to plant, need to wait " + (deckThread.getDeckStatus().get(i).getLastTimeCreated() + 5 - Time.getTime().getTotalSeconds()) + " seconds");
            }
            }
            
        }
        
    }

    public PlantDeck getPlantDeck(){
        PlantDeck plantDeck = new PlantDeck();
        for (Plant p : deck){
            plantDeck.getPlantsInDeck().add(p);
        }
        return plantDeck;
    }

    public void setPlantDeck(PlantDeck plantDeck){
        deck.clear();
        for (Plant p : plantDeck.getPlantsInDeck()){
            deck.add(p);
        }
    }

    public void setDeckState(DeckState deckState){
        
        DeckThread.getDeckThreadInstance(this).getDeckStatus().clear();
        DeckThread.resetDeckThread();
        DeckThread.setDeckThreadInstance(DeckThread.getDeckThreadInstance(this));
        
        for (int i = 0; i < deckState.getDeckStatus().size(); i++){
            DeckThread.getDeckThreadInstance(this).getDeckStatus().add(new StatusDeck(deckState.getDeckStatus().get(i).isReadyToPlant(), deckState.getDeckStatus().get(i).getLastTimeCreated(), deckState.getDeckStatus().get(i).getInterval()));
        }
        System.out.println(DeckThread.getDeckThreadInstance(this).getDeckStatus().size());
        
    }

    public void tanam(int i, int x, int y) throws IllegalArgumentException, IllegalStateException, NotPlantableException {
        DeckThread deckThread = DeckThread.getDeckThreadInstance(this);
        if (x < 0 || x >= 6 || y < 1 || y >= 10) {
            throw new IllegalArgumentException("Index out of bounds");
        // } else if (Map.getMapInstance().getMapDetail()[x][y].isAdaTanaman()) {
        //     throw new IllegalStateException("There is already a plant in this plot");
        } else {
            PlantFactory pabrik = new PlantFactory();
            Plant plant = pabrik.createPlant(deck.get(i).getName());
            Map.getMapInstance().tanamAt(x, y, plant);
            // Map.getMapInstance().tanamAt(x, y, new (deck.get(i)));
            deckThread.getDeckStatus().get(i).setReadyToPlant(false);
        }
    }
    

    public void gali(int x, int y) throws IllegalArgumentException, NotShovelableException {
        if (x < 0 || x >= 6 || y < 1 || y >= 10) {
            throw new IllegalArgumentException("Index out of bounds");
        } else {
            Map.getMapInstance().getMapDetail()[x][y].gali();
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
                    DeckThread.getDeckThreadInstance(this).getDeckStatus().get(i-1).isReadyToPlant(), 
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


}
