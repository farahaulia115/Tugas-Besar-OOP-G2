package Plant;
import Main.Game;
import Main.Sun;
import Time.Time;

public class TwinSunFlower implements Plant, ProduceSun{
    private static final int SUN_PRODUCTION_INTERVAL = 10; // Interval produksi Sun dalam detik
    private static final int SUN_PRODUCTION_AMOUNT = 50;
    private String name = "TwinSunflower";
    private int cost = 150;
    private int health = 120;
    private int attackDamage = 0;
    private int attackSpeed = 0;
    private int range = 0;
    private int cooldown = 10;
    private boolean jumpable = true;
    private Time plantedTime = new Time();
    
    public TwinSunFlower(){
        plantedTime = new Time();
        startSunProductionThread();
    }

    public void startSunProductionThread (){
        Thread sunProductionThread = new Thread(() -> {
            while (Game.getStatusGame()) {
                try {
                    Thread.sleep(SUN_PRODUCTION_INTERVAL * 1000); // Tunggu interval produksi
                    Sun.increaseSun(SUN_PRODUCTION_AMOUNT);
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

    public void ProduceSun(Sun sun){
        // setiap berapa detik dia produce sun
    }

    @Override
    public void produceSun() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ProduceSun'");
    }
}
