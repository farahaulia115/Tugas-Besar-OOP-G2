package Zombie;

public class NormalZombie implements Zombie {
    private String name = "Normal Zombie";
    private int health = 125;
    private int damage = 100;
    private int speed = 1;
    private boolean aquatic = false;


    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public boolean isAquatic() {
        return aquatic;
    }

    @Override
    public void attack() {
        // Implementasi serangan
    }
}
