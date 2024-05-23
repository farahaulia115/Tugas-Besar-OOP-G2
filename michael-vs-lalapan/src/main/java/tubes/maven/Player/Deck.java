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
import tubes.maven.Thread.DeckThreat;
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

    public DeckState getDeckState(){
        List<StatusDeckState> deckStatus = new ArrayList<>();
        for (StatusDeck statusDeck : DeckThreat.getDeckThreatInstance(this).getDeckStatus()){
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
                
                DeckThreat deckThreat = DeckThreat.getDeckThreatInstance(this);
                if (deckThreat.getDeckStatus().get(i).isReadyToPlant()) {
                
                    deckThreat.getDeckStatus().get(i).setLastTimeCreated(Time.getTime().getTotalSeconds());
                } else {
                    throw new IllegalStateException("Plant is not ready to plant, need to wait " + (deckThreat.getDeckStatus().get(i).getLastTimeCreated() + 5 - Time.getTime().getTotalSeconds()) + " seconds");
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
        
        DeckThreat.getDeckThreatInstance(this).getDeckStatus().clear();
        DeckThreat.resetDeckThreat();
        DeckThreat.setDeckThreatInstance(DeckThreat.getDeckThreatInstance(this));
        
        for (int i = 0; i < deckState.getDeckStatus().size(); i++){
            DeckThreat.getDeckThreatInstance(this).getDeckStatus().add(new StatusDeck(deckState.getDeckStatus().get(i).isReadyToPlant(), deckState.getDeckStatus().get(i).getLastTimeCreated(), deckState.getDeckStatus().get(i).getInterval()));
        }
        System.out.println(DeckThreat.getDeckThreatInstance(this).getDeckStatus().size());
        
    }

    public void tanam(int i, int x, int y) throws IllegalArgumentException, IllegalStateException, NotPlantableException {
        DeckThreat deckThreat = DeckThreat.getDeckThreatInstance(this);
        if (x < 0 || x >= 6 || y < 1 || y >= 10) {
            throw new IllegalArgumentException("Index out of bounds");
        // } else if (Map.getMapInstance().getMapDetail()[x][y].isAdaTanaman()) {
        //     throw new IllegalStateException("There is already a plant in this plot");
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
