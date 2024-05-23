package tubes.maven.State;
import java.util.List;

import tubes.maven.Plant.Plant;

public class DeckState {
    private List<StatusDeckState> deckStatus;
    public DeckState() {
        // Konstruktor default
    }
    // Constructor
    public DeckState(List<StatusDeckState> deckStatus) {
        this.deckStatus = deckStatus;
    }
    // Getters and Setters
    public List<StatusDeckState> getDeckStatus() {
        return deckStatus;
    }

    public void setDeckStatus(List<StatusDeckState> deckStatus) {
        this.deckStatus = deckStatus;
    }
}
