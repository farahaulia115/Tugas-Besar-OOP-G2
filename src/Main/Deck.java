package Main;

import java.util.ArrayList;
import java.util.List;

import Map.Map;
import Plant.Plant;
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
            System.out.println("Deck kosong");
        }
        
    }

    public int pilihTanaman(int i){
        if (i < 0 || i >= deck.size()){
            System.out.println("Input tidak valid");
        } else {
            DeckThreat deckThreat = DeckThreat.getDeckThreatInstance(this);
            if (deckThreat.getDeckStatus().get(i).isReadyToPlant()){
                deckThreat.getDeckStatus().get(i).setReadyToPlant(false);
                deckThreat.getDeckStatus().get(i).setLastTimeCreated(Time.getTime().getTotalSeconds());
                return i;
            } else {
                System.out.println("Tanaman belum siap");
            }
        }
        return -1;
    }

    public boolean tanam(int i, int x, int y){
        if ( i > 0){
            if (Map.getMapInstance().getMapDetail()[x][y].isAdaTanaman()){
                System.out.println("Tidak bisa menanam di sini");
            } else {
                Map.getMapInstance().tanamAt(x, y, deck.get(i));
                return true;
            }
        } 
        return false;
    }

    public void gali(int x, int y){
        try{
            Map.getMapInstance().getMapDetail()[x][y].gali();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void showDeckStatus(){
        int i = 1;
        if (!deck.isEmpty()){
            for (Plant p: deck){
                System.out.println(i + " ." + deck.get(i-1).getName() + " " + DeckThreat.getDeckThreatInstance(this).getDeckStatus().get(i-1).isReadyToPlant());
                i++;
            }
        } else {
            System.out.println("Deck kosong");
        }
    
    }



// jangan lupa tanganin kalo deck kosong gak bisa maen game
}
