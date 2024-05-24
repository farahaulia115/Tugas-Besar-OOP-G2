package tubes.maven.State;

import java.util.ArrayList;
import java.util.List;

import tubes.maven.Plant.Plant;

public class PlantDeck {
    private List<Plant> plantsInDeck;
   
    public PlantDeck(List<Plant> plantsInDeck) {
        this.plantsInDeck = plantsInDeck;
    }
     public PlantDeck() {
        this.plantsInDeck = new ArrayList<>();
    }


    // Getters and Setters
    public List<Plant> getPlantsInDeck() {
        return plantsInDeck;
    }

    public void setPlantsInDeck(List<Plant> plantsInDeck) {
        this.plantsInDeck = plantsInDeck;
    }
}
