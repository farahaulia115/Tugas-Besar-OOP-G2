package Plants;
import Main.Sun;

public class Sunflower extends Plants implements ProduceSun{
    private static final int SUN_PRODUCTION_INTERVAL = 3000; // Interval produksi Sun dalam detik
    private static final int SUN_PRODUCTION_AMOUNT = 25;
    public Sunflower() {
        setName("Sunflower");
        setCost(50);
        setHealth(100);
        setAttackDamage(0);
        setAttackSpeed(0);
        setRange(0);
        setCooldown(10);
        setJumpable(true);
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
    // public void startSunProductionThread() {
    //     sunProductionThread = new Thread(() -> {
    //         while (Game.getStatusGame() && isAlive) {
    //             try {
    //                 Thread.sleep(SUN_PRODUCTION_INTERVAL * 1000); // Tunggu interval produksi
    //                 produceSun();
    //             } catch (InterruptedException e) {
    //                 e.printStackTrace();
    //             }
    //         }
    //     });
    //     sunProductionThread.start(); // Mulai thread
    // }
    // @Override
    //  public void produceSun() {
    //     Sun.increaseSun(SUN_PRODUCTION_AMOUNT);
    // }

    // public void stopSunProductionThread() {
    //     if (sunProductionThread != null) {
    //         sunProductionThread.interrupt();
    //     }
    // }

