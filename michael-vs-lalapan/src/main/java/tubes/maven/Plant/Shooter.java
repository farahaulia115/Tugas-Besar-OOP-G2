package tubes.maven.Plant;
import tubes.maven.Map.Tile;

public interface Shooter {
    void setLastAttack(int lastAttack);
    int getlastAttack();
    void startAttack(Tile tile);
}
