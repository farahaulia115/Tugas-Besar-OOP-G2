package Zombie;

public interface Zombie {
    String getName();
    int getHealth();
    int getDamage();
    int getSpeed();
    int getTimeSpawn();
    boolean isAquatic();
    void setPosition(int x, int y);
    void setTimeSpawn();
    void setHealth(int i);
    void setMoveInterval(int moveInterval);
    int getMoveInterval();
    int getX();
    int getY();
}
