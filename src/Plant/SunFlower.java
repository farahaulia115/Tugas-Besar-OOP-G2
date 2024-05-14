package Plant;
import Main.*;

public class SunFlower implements Plant, ProduceSun {
    private static final int SUN_PRODUCTION_INTERVAL = 10; // Interval produksi Sun dalam detik
    private static final int SUN_PRODUCTION_AMOUNT = 25;
    private String name = "SunFlower";
    private int cost = 50;
    private int health = 100;
    private int attackDamage = 0;
    private int attackSpeed = 0;
    private int range = 0;
    private int cooldown = 10;
    private boolean jumpable = true;
    private boolean isAlive = true;
    private Thread sunProductionThread;

    public SunFlower() {
        startSunProductionThread();
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

    public void startSunProductionThread() {
        sunProductionThread = new Thread(() -> {
            while (Game.getStatusGame() && isAlive) {
                try {
                    Thread.sleep(SUN_PRODUCTION_INTERVAL * 1000); // Tunggu interval produksi
                    produceSun();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        sunProductionThread.start(); // Mulai thread
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

    public void produceSun() {
        Sun.increaseSun(SUN_PRODUCTION_AMOUNT);
    }

    public void stopSunProductionThread() {
        if (sunProductionThread != null) {
            sunProductionThread.interrupt();
        }
    }
}
