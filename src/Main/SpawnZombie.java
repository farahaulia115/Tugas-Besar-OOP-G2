package Main;

import java.util.Random;

import Map.Map;
import Thread.Time;
import Zombie.Zombie;
import Zombie.ZombieFactory;

public class SpawnZombie implements Runnable {

    @Override
    public void run() {
        // Check if the total seconds are within the desired range
        if (Time.getTime().getTotalSeconds() >= 5 && Time.getTime().getTotalSeconds() <= 160) {
            double probabilityTile = 0.3;
            for (int i = 0; i < 6; i++) {
                if (Math.random() < probabilityTile && Map.getMapInstance().jumlahZombie() <= 10) {
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
                    System.out.println("Zombie spawned at row " + (i + 1));
                }
                // Add a delay of 1 second between each iteration
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // Handle the exception if the thread is interrupted
                    System.err.println("Thread was interrupted: " + e.getMessage());
                }
            }
        }
    }
}
