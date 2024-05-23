package tubes.maven.Plant;
import com.fasterxml.jackson.annotation.JsonTypeName;

import tubes.maven.Player.*;
import tubes.maven.Thread.Time;


@JsonTypeName("Twinsunflower")

public class TwinSunFlower implements Plant, ProduceSun{
    private int SUN_PRODUCTION_INTERVAL = 3; // Interval produksi Sun dalam detik
    private int SUN_PRODUCTION_AMOUNT = 50;
    private String name = "Twin Sunflower";
    private int cost = 125;
    private int health = 200;
    private int attackDamage = 0;
    private int attackSpeed = 0;
    private int range = 0;
    private int cooldown = 10;
    private int plantTimeCreated = Time.getTime().getTotalSeconds();;
    private boolean jumpable = true;
    private int lastProductionTime = Time.getTime().getTotalSeconds();;

    public TwinSunFlower() {
        // Konstruktor default
    }
    public TwinSunFlower(String name, int cost, int health, int attackDamage, int attackSpeed, int range, int cooldown, boolean jumpable, int plantTimeCreated) {
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
    public int getTimePlantCreated() {
        return plantTimeCreated;
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
    public void produceSun() {
        int currentTime = Time.getTime().getTotalSeconds();
        if (currentTime - lastProductionTime >= SUN_PRODUCTION_INTERVAL) {
            Sun.increaseSun(SUN_PRODUCTION_AMOUNT);
            lastProductionTime = currentTime;
        }
    }


}