package tubes.maven.Plant;
import tubes.maven.Map.*;
import tubes.maven.Thread.Time;
import tubes.maven.Zombie.Zombie;

public class Peashooter implements Plant, Attack, Shooter {
    private String name = "Peashooter";
    private int cost = 100;
    private int health = 100;
    private int attackDamage = 25;
    private int attackSpeed = 4;
    private int range = -1;
    private int cooldown = 10;
    private boolean jumpable = true;
    private int timeCreated;
    private int lastAttack;
    private boolean firstAttack;
    public Peashooter() {
        this.timeCreated = Time.getTime().getTotalSeconds();
        this.lastAttack = Time.getTime().getTotalSeconds();
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
        return timeCreated;
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
    public int getlastAttack() {
        return lastAttack;
    }

    @Override
    public void setfirstAttack(boolean firstAttack) {
        this.firstAttack = firstAttack;
    }

    @Override
    public boolean getfirstAttack() {
        return firstAttack;
    }

    @Override
    public void attack(Tile tile) {
        int timeNow = Time.getTime().getTotalSeconds();
        if (timeNow - lastAttack >= attackSpeed) {
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