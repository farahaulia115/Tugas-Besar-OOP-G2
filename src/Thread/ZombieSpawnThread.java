package Thread;
import java.util.Random;
import Zombie.*;
import Map.*;

public class ZombieSpawnThread implements Runnable {
    public void run(){
        Random rad = new Random();
        ZombieFactory zomfac = new ZombieFactory();
        int prob;

        for (int i = 0;i<2;i++){
            prob = rad.nextInt(10);
            if (prob==1 || prob==5 || prob==9){
                Zombie z = zomfac.createZombie(rad.nextInt(1, 8));
                Map.getMapInstance().getMapDetail()[i][9].getZombieList().add(z);
            }
        }

        for (int i = 2;i<4;i++){
            prob = rad.nextInt(10);
            if (prob==1 || prob==5 || prob==9){
                Zombie z = zomfac.createZombie(rad.nextInt(8, 11));
                Map.getMapInstance().getMapDetail()[i][9].getZombieList().add(z);
            }
        }

        for (int i = 4;i<6;i++){
            prob = rad.nextInt(10);
            if (prob==1 || prob==5 || prob==9){
                Zombie z = zomfac.createZombie(rad.nextInt(1, 8));
                Map.getMapInstance().getMapDetail()[i][9].getZombieList().add(z);
            }
        }

    }    
}
