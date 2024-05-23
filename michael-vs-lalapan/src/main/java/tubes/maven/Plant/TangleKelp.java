package tubes.maven.Plant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import tubes.maven.Map.Map;
import tubes.maven.Map.Tile;
import tubes.maven.Thread.Time;

@JsonTypeName("TangleKelp")
@JsonIgnoreProperties(ignoreUnknown = true)
public class TangleKelp implements Plant, Attack, SelfDestruct {
    private String name = "Tangle kelp";
    private int cost = 25;
    private int health = 100;
    private int attackDamage = 5000;
    private int attackSpeed = 0;
    private int range = 1;
    private int cooldown = 20;
    private boolean jumpable = true;
    
    @JsonProperty("timePlantCreated")
    private int timeCreated = Time.getTime().getTotalSeconds();

    public TangleKelp() {
        // Konstruktor default
    }

    public TangleKelp(String name, int cost, int health, int attackDamage, int attackSpeed, int range, int cooldown, boolean jumpable, int timeCreated) {
        this.name = name;
        this.cost = cost;
        this.health = health;
        this.attackDamage = attackDamage;
        this.attackSpeed = attackSpeed;
        this.range = range;
        this.cooldown = cooldown;
        this.jumpable = jumpable;
        this.timeCreated = timeCreated;
    }

    @Override
    public int getTimePlantCreated() {
        return timeCreated;
    }


    public void setTimePlantCreated(int timeCreated) {
        this.timeCreated = timeCreated;
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

    @Override
    public void attack(Tile tile) {
        int zombiesCount = tile.getZombieList().size();
        tile.getZombieList().clear();
        Map.getMapInstance().removeZombieInMap(zombiesCount);
    }

    @Override
    public void startAttack(Tile tile) {
        attack(tile);
        selfDestruct(tile);
    }

    @Override
    public void selfDestruct(Tile tile) {
        tile.plantDie();
    }
}
