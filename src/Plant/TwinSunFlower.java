package Plant;
import Main.*;
import Thread.Time;

public class TwinSunFlower implements Plant, ProduceSun{
    private static final int SUN_PRODUCTION_INTERVAL = 3000; // Interval produksi Sun dalam detik
    private static final int SUN_PRODUCTION_AMOUNT = 50;
    private String name = "Twin Sunflower";
    private int cost = 150;
    private int health = 120;
    private int attackDamage = 0;
    private int attackSpeed = 0;
    private int range = 0;
    private int cooldown = 10;
    private int timeCreated;
    private boolean jumpable = true;

    public TwinSunFlower() {
        this.timeCreated = Time.getTime().getTotalSeconds();
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

    @Override
    public void produceSun() {
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(SUN_PRODUCTION_INTERVAL);
                    Sun.increaseSun(SUN_PRODUCTION_AMOUNT);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}