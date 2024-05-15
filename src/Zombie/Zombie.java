package Zombie;

public interface Zombie {
    String getName();
    int getHealth();
    int getDamage();
    int getSpeed();
    boolean isAquatic();
    void setPosition(int x, int y);

}
