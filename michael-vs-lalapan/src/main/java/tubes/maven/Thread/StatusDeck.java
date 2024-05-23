package tubes.maven.Thread;

import tubes.maven.Plant.Plant;

public class StatusDeck {
    private boolean readyToPlant;
    private int lastTimeCreated;
    private int interval;
    public StatusDeck(boolean readyToPlant, int lastTimeCreated, int interval) {
        this.readyToPlant = readyToPlant;
        this.lastTimeCreated = lastTimeCreated;
        this.interval = interval;
    }

    public StatusDeck(Plant p) {
        readyToPlant = true;
        lastTimeCreated = 0;
        interval = p.getCooldown();
    }

    public boolean isReadyToPlant() {
        return readyToPlant;
    }

    public void setReadyToPlant(boolean readyToPlant) {
        this.readyToPlant = readyToPlant;
    }

    public int getLastTimeCreated() {
        return lastTimeCreated;
    }

    public int getInterval() {
        return interval;
    }

    public void setLastTimeCreated(int totalSeconds) {
        lastTimeCreated = totalSeconds;
    }

    public void setInterval(int interval2) {
        interval = interval2;
    }
}
