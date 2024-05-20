package tubes.maven.Thread;

import tubes.maven.Map.Map;
import tubes.maven.Plant.Lilypad;
import tubes.maven.Plant.Tallnut;
import tubes.maven.Plant.Wallnut;
import tubes.maven.Zombie.DolphinriderZombie;

public class TesRun {
    public static void main(String[] args) {
        try {
            Map.getMapInstance().getMapDetail()[2][8].getZombieList().add(new DolphinriderZombie());
            Map.getMapInstance().getMapDetail()[3][8].getZombieList().add(new DolphinriderZombie());
            Map.getMapInstance().getMapDetail()[3][8].tanam(new Lilypad());
            Map.getMapInstance().getMapDetail()[3][8].tanam(new Wallnut());
            Map.getMapInstance().getMapDetail()[2][7].tanam(new Lilypad());
            Map.getMapInstance().getMapDetail()[2][7].tanam(new Tallnut());
            
            Map.getMapInstance().renderMap();
            while (true){
                Runnable t = Time.getTime();
                Thread timeThread = new Thread(t);
                timeThread.start();

                Thread spawnerThread = new Thread(new SpawnZombie());
                Thread entityThread1 = new Thread(new Row1EntityThread());
                Thread entityThread2 = new Thread(new Row2EntityThread());
                Thread entityThread3 = new Thread(new Row3EntityThread());
                Thread entityThread4 = new Thread(new Row4EntityThread());
                Thread entityThread5 = new Thread(new Row5EntityThread());
                Thread entityThread6 = new Thread(new Row6EntityThread());
                Thread.sleep(1000);
                spawnerThread.start();
                spawnerThread.join();
                entityThread1.start();
                entityThread2.start();
                entityThread3.start();
                entityThread4.start();
                entityThread5.start();
                entityThread6.start();

                entityThread1.join();
                entityThread2.join();
                entityThread3.join();
                entityThread4.join();
                entityThread5.join();
                entityThread6.join(); 

                Map.getMapInstance().renderMap();
                }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
