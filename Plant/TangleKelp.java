package Plant;

public class TangleKelp implements Plant {
    private String name = "Tangle Kelp";
    private int cost = 25;
    private int health = 100;
    private int attackDamage = 5000;
    private int attackSpeed = 0;
    private int range = 1;
    private int cooldown = 20;
    private boolean jumpable = true;



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

}

