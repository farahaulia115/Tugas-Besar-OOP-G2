package Plant;

public class Repeater implements Plant, Attack{
    private String name = "Repeater";
    private int cost = 200;
    private int health = 100;
    private int attackDamage = 25;
    private int attackSpeed = 2;
    private int range = -1;
    private int cooldown = 10;
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
