package Plant;

import Main.Game;
import Thread.Time;
import Zombie.Zombie;

public class Peashooter implements Plant, Attack {
    private String name = "Peashooter";
    private int cost = 100;
    private int health = 100;
    private int attackDamage = 25;
    private int attackSpeed = 4;
    private int range = -1;
    private int cooldown = 10;
    private boolean jumpable = true;
    private int timeCreated;
    public Peashooter() {
        this.timeCreated = Time.getTime().getTotalSeconds();
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setCost(int cost) {
        this.cost = cost;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }
    public void setRange(int range) {
        this.range = range;
    }
    public void setCooldown(int cooldown) {
        this.cooldown = cooldown;
    }

    public void setJumpable(boolean jumpable) {
        this.jumpable = jumpable;
    }

    public int getTimePlantCreated() {
        return timeCreated;
    }

    
    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public int getHealth() {
        return health;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public int getAttackSpeed() {
        return attackSpeed;
    }

    public int getRange() {
        return range;
    }

    public int getCooldown() {
        return cooldown;
    }

    public boolean isJumpable() {
        return jumpable;
    }

    public void attack(Zombie zombie) {
        zombie.setHealth(zombie.getHealth() - attackDamage);

    }

}
