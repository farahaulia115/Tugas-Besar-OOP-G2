import java.util.Random;
import Map.*;
import Zombie.Zombie;
import Zombie.ZombieFactory;
import Time.Time;

public class TesSpawn {
    public static void main(String[] args) {
        // Start the time thread once at the beginning
        
        boolean status = true;

        Thread timeThread = new Thread(Time.getTime());
        timeThread.start();
        // Main loop for spawning zombies
        while (status) {
            
            // Check if the game status is still active
            if (!status) {
                break;
            }

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
                }
            }
            System.out.println("Time: " + Time.getTime().getTotalSeconds() + " seconds");
            // Render the map after attempting to spawn zombies
            Map.getMapInstance().renderMap();

            // Sleep for 1 second before the next iteration
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (Time.getTime().getTotalSeconds() > 40) {
                status = false;
            }
        }

        
    }
}
