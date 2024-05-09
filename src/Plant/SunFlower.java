package Plant;
import Time.*;
import Main.*;

public class SunFlower implements Plant, ProduceSun{
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
    private Time plantedTime;

    
    public SunFlower (){
        plantedTime = new Time();
        startSunProductionThread();
    }

    public void startSunProductionThread (){
        Thread sunProductionThread = new Thread(() -> {
            while (Game.getStatusGame()) {
                try {
                    Thread.sleep(SUN_PRODUCTION_INTERVAL * 1000); // Tunggu interval produksi
                    Sun.increaseeSun(SUN_PRODUCTION_AMOUNT);
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

    public void produceSun(){

    }

}

