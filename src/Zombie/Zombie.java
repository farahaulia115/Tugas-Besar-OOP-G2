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
}
