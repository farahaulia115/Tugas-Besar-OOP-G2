package tubes.maven.Plant;

import tubes.maven.Thread.Time;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("Tallnut")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tallnut implements Plant {
    private String name = "Tall nut";
    private int cost = 125;
    private int health = 2000;
    private int attackDamage = 0;
    private int attackSpeed = 0;
    private int range = 0;
    private int cooldown = 20;
    private boolean jumpable = false;
    private int plantTimeCreated = Time.getTime().getTotalSeconds();
    
    public Tallnut() {
        // Konstruktor default
    }

    public Tallnut(String name, int cost, int health, int attackDamage, int attackSpeed, int range, int cooldown, boolean jumpable, int plantTimeCreated) {
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

    @Override
    public int getTimePlantCreated() {
        return plantTimeCreated;
    }

    public void setTimePlantCreated(int plantTimeCreated) {
        this.plantTimeCreated = plantTimeCreated;
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

    public void setAttackSpeed(int attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    @Override
    public void setRange(int range) {
        this.range = range;
    }

    @Override
    public void setCooldown(int cooldown) {
        this.cooldown = cooldown;
    }

    public void setJumpable(boolean jumpable) {
        this.jumpable = jumpable;
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
}
