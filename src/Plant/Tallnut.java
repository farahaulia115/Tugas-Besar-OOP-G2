package Plant;

public class Tallnut implements Plant {
    private String name = "Tallnut";
    private int cost = 125;
    private int health = 2000;
    private int attackDamage = 0;
    private int attackSpeed = 0;
    private int range = 0;
    private int cooldown = 20;
    private boolean jumpable = false;



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



}
