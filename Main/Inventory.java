package Main;

import java.util.ArrayList;

import Plant.Plant;

public class Inventory {
    private Plant[] inventory;
    private Deck deck;

    public Inventory() {
        this.inventory = new Plant[10];
        ArrayList<Plant> deck;
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
        
    }








}
