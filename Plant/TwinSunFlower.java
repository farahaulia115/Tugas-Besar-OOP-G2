package Plant;

public class TwinSunFlower implements Plant, ProduceSun{
    private String name = "TwinSunFlower";
    private int cost = 150;
    private int health = 120;
    private int attackDamage = 0;
    private int attackSpeed = 0;
    private int range = 0;
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
        // Implementasi serangan untuk Sunflower
    }

    public void ProduceSun(Sun sun){

    }
}
