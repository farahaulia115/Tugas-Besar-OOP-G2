package tubes.maven.State;

import com.fasterxml.jackson.annotation.JsonProperty;


public class GameState {
    @JsonProperty("mapState")
    private MapState mapState;
    @JsonProperty("amountSun")
    private int amountSun;
    @JsonProperty("timeState")
    private TimeState timeState;
    @JsonProperty("deckState")
    private DeckState deckState;
    @JsonProperty("plantInDeck")
    private PlantDeck plantInDeck;
   
    public GameState() {}
    // Constructors
    public GameState(MapState mapState, int amountSun, TimeState timeState, DeckState deckState, PlantDeck plantInDeck) {
        this.mapState = mapState;
        this.amountSun = amountSun;
        this.timeState = timeState;
        this.deckState = deckState;
        this.plantInDeck = plantInDeck;
        
    }

    // Getters and Setters
    public MapState getMapState() {
        return mapState;
    }

    public void setMapState(MapState mapState) {
        this.mapState = mapState;
    }

    public int getamountSun() {
        return amountSun;
    }

    public void setamountSun(int amountSun) {
        this.amountSun = amountSun;
    }

    public TimeState getTimeState() {
        return timeState;
    }

    public void setTimeState(TimeState timeState) {
        this.timeState = timeState;
    }

    public DeckState getDeckState() {
        return deckState;
    }

    public void setDeckState(DeckState deckState) {
        this.deckState = deckState;
    }

    public PlantDeck getPlantInDeck() {
        return plantInDeck;
    }

    public void setPlantInDeck(PlantDeck plantInDeck) {
        this.plantInDeck = plantInDeck;
    }
}