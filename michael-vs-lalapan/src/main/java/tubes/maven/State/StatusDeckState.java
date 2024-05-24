package tubes.maven.State;

public class StatusDeckState {
    private boolean readyToPlant;
    private int lastTimeCreated;
    private int interval;

    // Constructor
    public StatusDeckState(boolean readyToPlant, int lastTimeCreated, int interval) {
        this.readyToPlant = readyToPlant;
        this.lastTimeCreated = lastTimeCreated;
        this.interval = interval;
    }
    public StatusDeckState() {
        // Konstruktor default
    }

    // Getters and Setters
    public boolean isReadyToPlant() {
        return readyToPlant;
    }

    public void setReadyToPlant(boolean readyToPlant) {
        this.readyToPlant = readyToPlant;
    }

    public int getLastTimeCreated() {
        return lastTimeCreated;
    }

    public void setLastTimeCreated(int lastTimeCreated) {
        this.lastTimeCreated = lastTimeCreated;
    }

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }
}
