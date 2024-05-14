package Main;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import Map.Map;
import Time.Time;
import Zombie.Zombie;
import Zombie.ZombieFactory;

public class SpawnZombie implements Runnable {
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    

    public void start() {
        scheduler.scheduleAtFixedRate(this::spawnZombie, 0, 1, TimeUnit.SECONDS);
    }

    public void stop() {
        scheduler.shutdown();
    }

    public void spawnZombie() {
        // Menghentikan scheduler jika kondisi permainan tidak lagi berlaku
        if (!Game.getStatusGame()) {
            stop();
            return;
        }
        
        // Memeriksa apakah waktu berada di rentang yang diinginkan sebelum menambahkan zombie
        if (Time.getTime().getTotalSeconds() > 10 && Time.getTime().getTotalSeconds() < 160) {
            double probabilityTile = 0.3;
            for (int i = 0; i < 6; i++) {
                if (Math.random() < probabilityTile) {
                    int jenisZombie;
                    if (i >= 2 && i < 4) {
                        jenisZombie = new Random().nextInt(3) + 8;
                    } else {
                        jenisZombie = new Random().nextInt(7) + 1;
                    }
                    ZombieFactory factory = new ZombieFactory();
                    Zombie newZombie = factory.createZombie(jenisZombie);
                    Map.getMapInstance().getMapDetail()[i][10].getZombieList().add(newZombie);
                    newZombie.setPosition(i, 10);
                    System.out.println("Zombie spawned at row" + (i + 1) );
                }
            }
        }
    }
    

    @Override
    public void run() {
        start();
    }

}
