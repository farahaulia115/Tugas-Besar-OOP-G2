package Plant;

import Map.NotShovelableException;
import Map.Tile;
import Thread.Time;
import Zombie.Zombie;

public class TangleKelp implements Plant, Attack, SelfDestruct {
    private String name = "TangleKelp";
    private int cost = 25;
    private int health = 100;
    private int attackDamage = 5000;
    private int attackSpeed = 0;
    private int range = 1;
    private int cooldown = 20;
    private boolean jumpable = true;
    private int timeCreated;
    public TangleKelp() {
        this.timeCreated = Time.getTime().getTotalSeconds();
    }

    @Override
    public void attack(Zombie z) {
        z.setHealth(z.getHealth()-getAttackDamage());
        selfDestruct(tile);
    }

    @Override
    public void selfDestruct(Tile tile) {
        try {
            tile.gali();
        } catch (NotShovelableException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getTimePlantCreated() {
        return timeCreated;
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

}

