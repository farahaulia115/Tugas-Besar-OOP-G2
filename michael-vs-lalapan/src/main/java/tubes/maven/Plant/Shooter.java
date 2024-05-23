package tubes.maven.Plant;
import tubes.maven.Map.Tile;

public interface Shooter {
    void setLastAttack(int lastAttack);
    int getLastAttack();
    void setFirstAttack(boolean firstAttack);
    boolean getFirstAttack();
    void startAttack(Tile tile);
}
