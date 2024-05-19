package tubes.maven.Player;

import java.util.ArrayList;

import tubes.maven.Plant.*;

public class Inventory {
    private ArrayList<Plant> inventory;
    private Deck deck;
 
    public Inventory() {
        this.inventory = new ArrayList<>();
        deck = new Deck();
        PlantFactory pabrik = new PlantFactory();
        inventory.add(pabrik.createPlant("Sunflower"));
        inventory.add(pabrik.createPlant("Twin Sunflower"));
        inventory.add(pabrik.createPlant("Tangle kelp"));
        inventory.add(pabrik.createPlant("Squash"));
        inventory.add(pabrik.createPlant("Peashooter"));
        inventory.add(pabrik.createPlant("Repeater"));
        inventory.add(pabrik.createPlant("Snow pea"));
        inventory.add(pabrik.createPlant("Tall nut"));
        inventory.add(pabrik.createPlant("Wall nut"));
        inventory.add(pabrik.createPlant("Lilypad"));
    }

    public ArrayList<Plant> getInventory(){
        return inventory;
    }

    public Deck getDeck(){
        return deck;
    }

    public void swapInventory (int x, int y){
        if (x == y){
            throw new IllegalArgumentException("Index is the same");
        }
        else if (x < 0 || x >= inventory.size() || y < 0 || y >= inventory.size()) {
            throw new IllegalArgumentException("Index out of bounds");
        } else {
            Plant temp = inventory.get(x);
            inventory.set(x, inventory.get(y));
            inventory.set(y, temp);
        }
        
    }

    public void swapDeck (int x, int y){
        if (x == y){
            throw new IllegalArgumentException("Index is the same");
        }
        else if (x < 0 || x >= deck.getDeck().size() || y < 0 || y >= deck.getDeck().size()) {
            throw new IllegalArgumentException("Index out of bounds");
        } else {
            Plant temp = deck.getDeck().get(x);
            deck.getDeck().set(x, deck.getDeck().get(y));
            deck.getDeck().set(y, temp);
        }
    }

    public void deletePlantFromDeck (int index){
        if (index < 0 || index >= deck.getDeck().size()) {
            throw new IllegalArgumentException("Index out of bounds");
        }
        else if (deck.getDeck().isEmpty()){
            throw new IllegalArgumentException("Deck is empty");
        }
        else if (deck.getDeck().get(index) == null){
            throw new IllegalArgumentException("No plant in deck");
        }
        System.out.println(deck.getDeck().get(index).getName() + " has been deleted from deck");
        deck.getDeck().remove(index);
        
    }

    public void deletePlant (Plant plant){
        deck.getDeck().remove(plant);
    }

    public void addPlantToDeck (int i){
        if (i < 0 || i > inventory.size()) {
            throw new IllegalArgumentException("Index out of bounds");
        }
        else if (deck.getDeck().size() >= 6){
            throw new IllegalArgumentException("Deck is full");
        }
        else if (deck.getDeck().contains(inventory.get(i-1))){
            throw new IllegalArgumentException("Plant already in deck");
        }
        System.out.println(inventory.get(i-1).getName() + " has been added to deck");
        deck.getDeck().add(inventory.get(i-1));
    }

    public void addPlantToDeck (Plant plant){
        deck.getDeck().add(plant);
    }

    public void showInventory (){
        int i = 1;
        System.out.println("Inventory : ");
        for (Plant p : inventory){
            System.out.println(i + ". " + inventory.get(i-1).getName());
            i++;
        }
    }

    public void resetInventory(){
        inventory.clear();
        PlantFactory pabrik = new PlantFactory();
        inventory.add(pabrik.createPlant("Sunflower"));
        inventory.add(pabrik.createPlant("Twin Sunflower"));
        inventory.add(pabrik.createPlant("Tangle kelp"));
        inventory.add(pabrik.createPlant("Squash"));
        inventory.add(pabrik.createPlant("Peashooter"));
        inventory.add(pabrik.createPlant("Repeater"));
        inventory.add(pabrik.createPlant("Snow pea"));
        inventory.add(pabrik.createPlant("Tall nut"));
        inventory.add(pabrik.createPlant("Wall nut"));
        inventory.add(pabrik.createPlant("Lilypad"));
    }

}
