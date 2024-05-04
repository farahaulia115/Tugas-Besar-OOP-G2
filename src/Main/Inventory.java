package Main;

import java.util.ArrayList;

import Plant.*;

public class Inventory {
    private ArrayList<Plant> inventory;
    private Deck deck;
 
    public Inventory() {
        this.inventory = new ArrayList<>();
        deck = new Deck();
        PlantFactory pabrik = new PlantFactory();
        inventory.add(pabrik.createPlant("SunFlower"));
        inventory.add(pabrik.createPlant("SunFlower"));

    }

    public ArrayList<Plant> getInventory(){
        return inventory;
    }

    public Deck getDeck(){
        return deck;
    }

    public void swapInventory (int x, int y){
        Plant temp = inventory.get(x);
        inventory.set(x, inventory.get(y));
        inventory.set(y, temp);
    }

    public void swapDeck (int x, int y){
        Plant temp = deck.getDeck().get(x);
        deck.getDeck().set(x, deck.getDeck().get(y));
        deck.getDeck().set(y, temp);
    }

    public void deletePlantFromDeck (int index){
        deck.getDeck().remove(index);
    }

    

    public void deletePlant (Plant plant){
        deck.getDeck().remove(plant);
    }

    public void addPlantToDeck (int i){
        deck.getDeck().add(inventory.get(i));
    }

    public void addPlantToDeck (Plant plant){
        deck.getDeck().add(plant);
    }

    public void showInventory (){
        int i = 1;
        for (Plant p : inventory){
            System.out.println(i + " ." + inventory.get(i-1).getName());
            i++;
        }
    }

}
