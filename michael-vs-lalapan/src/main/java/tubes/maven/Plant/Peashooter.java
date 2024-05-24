package tubes.maven.Plant;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;

import tubes.maven.Map.*;
import tubes.maven.Thread.Time;
import tubes.maven.Zombie.Zombie;
@JsonTypeName("Peashooter")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Peashooter implements Plant, Attack, Shooter {
    private String name = "Peashooter";
    private int cost = 100;
    private int health = 100;
    private int attackDamage = 25;
    private int attackSpeed = 4;
    private int range = -1;
    private int cooldown = 10;
    private boolean jumpable = true;
    private int plantTimeCreated = Time.getTime().getTotalSeconds();
    private int lastAttack = Time.getTime().getTotalSeconds();
    private boolean firstAttack = true;
    public Peashooter() {
        // Konstruktor default
    }

    public Peashooter(String name, int cost, int health, int attackDamage, int attackSpeed, int range, int cooldown, boolean jumpable, int plantTimeCreated) {
        this.name = name;
        this.cost = cost;
        this.health = health;
        this.attackDamage = attackDamage;
        this.attackSpeed = attackSpeed;
        this.range = range;
        this.cooldown = cooldown;
        this.jumpable = jumpable;
        this.plantTimeCreated = plantTimeCreated;
    }

    public int getplantTimeCreated() {
        return plantTimeCreated;
    }
    

    public void setAttackSpeed(int attackSpeed) {
        this.attackSpeed = attackSpeed;
    }
    public void setplantTimeCreated(int plantTimeCreated) {
        this.plantTimeCreated = plantTimeCreated;
    }
    public void setJumpable(boolean jumpable) {
        this.jumpable = jumpable;
    }
    public void getRange(int range) {
        this.range = range;
    }
    


    @Override
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public void setCost(int cost) {
        this.cost = cost;
    }
    @Override
    public void setHealth(int health) {
        this.health = health;
    }
    @Override
    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }
    @Override
    public void setRange(int range) {
        this.range = range;
    }
    @Override
    public void setCooldown(int cooldown) {
        this.cooldown = cooldown;
    }

    @Override
    public int getTimePlantCreated() {
        return plantTimeCreated;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getCost() {
        return cost;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public int getAttackDamage() {
        return attackDamage;
    }

    @Override
    public int getAttackSpeed() {
        return attackSpeed;
    }

    @Override
    public int getRange() {
        return range;
    }

    @Override
    public int getCooldown() {
        return cooldown;
    }

    @Override
    public boolean isJumpable() {
        return jumpable;
    }

    @Override
    public void setLastAttack(int lastAttack) {
        this.lastAttack = lastAttack;
    }

    @Override
    public int getLastAttack() {
        return lastAttack;
    }

    @Override
    public void setFirstAttack(boolean firstAttack) {
        this.firstAttack = firstAttack;
    }

    @Override
    public boolean getFirstAttack() {
        return firstAttack;
    }

    @Override
    public void attack(Tile tile) {
        int timeNow = Time.getTime().getTotalSeconds();
        if (firstAttack) {
            firstAttack = false;
        }
        if (timeNow - lastAttack >= attackSpeed || timeNow == lastAttack) {
            for (Zombie zombie : tile.getZombieList()) {
                zombie.setHealth(zombie.getHealth() - attackDamage);
                if (zombie.getHealth() <= 0) {
                    tile.getZombieList().remove(zombie);
                    Map.getMapInstance().removeZombieInMap();
                }
            }
            lastAttack = timeNow;
        }
    }

    @Override
    public void startAttack(Tile tile) {
        attack(tile);
    }
}