package Zombie;

public class Zombie {
    private String name;
    private int health;
    private int attack_damage;
    private int attack_speed;
    private boolean is_aquatic;

    public Zombie (String name, int health, int attack_damage, int attack_speed, boolean is_aquatic) {
        this.name = name;
        this.health = health;
        this.attack_damage = attack_damage;
        this.attack_speed = attack_speed;
        this.is_aquatic = is_aquatic;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }
    
    public int getDamage() {
        return attack_damage;
    }

    public int getSpeed() {
        return attack_speed;
    }

    public boolean getAquatic() {
        return is_aquatic;
    }
}
