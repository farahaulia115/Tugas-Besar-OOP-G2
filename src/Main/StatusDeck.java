package main;

import Plant.Plant;

public class StatusDeck {
    private boolean readyToPlant;
    private int lastTimeCreated;
    private int interval;

    public StatusDeck(Plant p) {
        readyToPlant = false;
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
}
