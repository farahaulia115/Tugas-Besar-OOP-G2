package tubes.maven.State;

import tubes.maven.Map.Tile;

public class MapState {
    private Tile[][] mapDetails;
    private int zombieInMap;

    // Default constructor
    public MapState() {
        this.mapDetails = new Tile[0][0];
        zombieInMap = 0;
    }

    // Constructors
    public MapState(Tile[][] mapDetails, int zombieInMap) {
        this.mapDetails = mapDetails;
        this.zombieInMap = zombieInMap;
    }

    // Getters and Setters
    public Tile[][] getMapDetails() {
        return mapDetails;
    }

    public void setMapDetails(Tile[][] mapDetails) {
        this.mapDetails = mapDetails;
    }

    public int getZombieInMap() {
        return zombieInMap;
    }

    public void setZombieInMap(int zombieInMap) {
        this.zombieInMap = zombieInMap;
    }
}
