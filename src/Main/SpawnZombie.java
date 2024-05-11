package main;


import java.util.Random;

import Map.Map;
import Zombie.*;

public class SpawnZombie implements Runnable{
    public void run(){
        double probabilityTile = 0.3;
        for (int i = 0; i < 1; i++) {
            if (Math.random() < probabilityTile) {
                int jenisZombie = new Random().nextInt(7) + 1;
                ZombieFactory factory = new ZombieFactory();
                Zombie newZombie = factory.createZombie(jenisZombie);
                Map.getMapInstance().getMapDetail()[i][11].getZombieList().add(newZombie);
                newZombie.setPosition(i, 11);
            }
        }
    }
}
