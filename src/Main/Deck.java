package Main;

import java.util.ArrayList;
import java.util.List;

import Plant.Plant;

public class Deck {
    // private Plant[] deck;

    // public Deck(){
    //     deck = new Plant[6];
    // }

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

// jangan lupa tanganin kalo deck kosong gak bisa maen game
}
