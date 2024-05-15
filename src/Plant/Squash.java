package Plant;

import Map.NotShovelableException;
import Map.Tile;
import Thread.Time;
import Zombie.Zombie;

public class Squash implements Plant, Attack, SelfDestruct {
    private String name = "Squash";
    private int cost = 50;
    private int health = 100;
    private int attackDamage = 5000;
    private int attackSpeed = 0;
    private int range = 1;
    private int cooldown = 20;
    private boolean jumpable = true;
    private int timeCreated;
    
    
    public Squash() {
        this.timeCreated = Time.getTime().getTotalSeconds();
    }
    @Override
    public void attack(Zombie zombie) {
        zombie.setHealth(zombie.getHealth() - getAttackDamage());
        
    }
    public void attack(Zombie zombie, Tile tile) {
        attack(zombie);
        selfDestruct(tile);
    }
    
    public void selfDestruct(Tile tile) {
        try {
            tile.gali();
        } catch (NotShovelableException e) {
            e.printStackTrace();
        }
    }

    public int getTimePlantCreated() {
        return timeCreated;
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

    public void attack() {
        
    }

    public void selfDestruct() {
        
    }


}

