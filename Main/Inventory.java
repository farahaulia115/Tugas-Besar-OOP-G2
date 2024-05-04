package Main;

import java.util.ArrayList;

import Plant.Plant;

public class Inventory {
    private Plant[] inventory;
    private Deck deck;
 
    public Inventory() {
        this.inventory = new Plant[10];
        deck = new Deck();

        // plants[1] = create plant tanaman 1 dst
    }

    public Plant[] getInventory(){
        return inventory;
    }

    public Deck getDeck(){
        return deck;
    }

    public void swapInventory (int x, int y){
        Plant temp = inventory[x];
        inventory[x] = inventory [y];
        inventory[y] = temp;

    }

    public void swapDeck (int x, int y){
        Plant temp = deck.getDeck().get(x);
        deck.getDeck().set(x, deck.getDeck().get(y));
        deck.getDeck().set(y, temp);
    }

    public void deletePlant (int index){
        deck.getDeck().remove(index);
    }

    // public void deletePlant (Plant plant){
    //     deck.getDeck().equals()
    //     for (Plant p: deck.getDeck()){
    //         if (deck.getDeck().equals(p))
    //     }
    // }

    public void addPlantToDeck (int i){
        deck.getDeck().add(inventory[i]);
    }

    public void addPlantToDeck (Plant plant){
        deck.getDeck().add(plant);
    }

    public void showInventory (){
        for (int i = 0; i < 10; i++){
            System.out.println((i+1) + " ." + inventory[i].getName());
        }
    }








}
