package tubes.maven.Thread;

import java.util.Random;

import tubes.maven.Map.Map;
import tubes.maven.Zombie.Zombie;
import tubes.maven.Zombie.ZombieFactory;

public class SpawnZombie implements Runnable {

    @Override
    public void run() {
        // Check if the total seconds are within the desired range
        if (Time.getTime().getTotalSeconds() > 20 && Time.getTime().getTotalSeconds() <= 150) {
            double probabilityTile = 0.3;
            for (int i = 0; i < 6; i++) {
                if (Math.random() < probabilityTile && Map.getMapInstance().jumlahZombie() < 10) {
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
                    System.out.println("Zombie " +  newZombie.getName() + " spawned at " + i + ", 10");
                    Map.getMapInstance().addZombieInMap();
                }
                
            }
        }
       else  if (Time.getTime().getTotalSeconds() > 150 && Time.getTime().getTotalSeconds() <= 160) {
            double probabilityTile = 0.3;
            for (int i = 0; i < 6; i++) {
                if (Math.random() < probabilityTile && Map.getMapInstance().jumlahZombie() < 25) {
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
                    System.out.println("Zombie " +  newZombie.getName() + " spawned at " + i + ", 10");
                    Map.getMapInstance().addZombieInMap();
                }
                
            }
        }
    }
}
