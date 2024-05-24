package tubes.maven.Thread;

import tubes.maven.Map.Map;
import tubes.maven.Plant.*;
import tubes.maven.Zombie.*;

public class TesRun {
    public static void main(String[] args) {
        try {
            //Map.getMapInstance().getMapDetail()[2][8].getZombieList().add(new DolphinriderZombie());
            
            Map.getMapInstance().getMapDetail()[3][8].getZombieList().add(new DolphinriderZombie());
            Map.getMapInstance().addZombieInMap();
            Map.getMapInstance().getMapDetail()[3][8].tanam(new Lilypad());
            Map.getMapInstance().getMapDetail()[3][8].tanam(new Wallnut());
            Map.getMapInstance().getMapDetail()[2][7].tanam(new Lilypad());
            Map.getMapInstance().getMapDetail()[2][7].tanam(new Tallnut());
            // Map.getMapInstance().getMapDetail()[2][1].tanam(new Lilypad());
            // Map.getMapInstance().getMapDetail()[2][1].tanam(new Wallnut());

            Map.getMapInstance().getMapDetail()[0][10].getZombieList().add(new FootballZombie());
            Map.getMapInstance().addZombieInMap();
            Map.getMapInstance().getMapDetail()[0][1].tanam(new SnowPea());

            Map.getMapInstance().getMapDetail()[1][10].getZombieList().add(new FootballZombie());
            Map.getMapInstance().addZombieInMap();
            Map.getMapInstance().getMapDetail()[1][1].tanam(new SnowPea());
            
            Map.getMapInstance().getMapDetail()[2][10].getZombieList().add(new FootballZombie());
            Map.getMapInstance().addZombieInMap();
            Map.getMapInstance().getMapDetail()[2][1].tanam(new Lilypad());
            Map.getMapInstance().getMapDetail()[2][1].tanam(new SnowPea());
            
            Map.getMapInstance().getMapDetail()[3][10].getZombieList().add(new FootballZombie());
            Map.getMapInstance().addZombieInMap();
            Map.getMapInstance().getMapDetail()[3][1].tanam(new Lilypad());
            Map.getMapInstance().getMapDetail()[3][1].tanam(new SnowPea());
            
            Map.getMapInstance().getMapDetail()[4][10].getZombieList().add(new FootballZombie());
            Map.getMapInstance().addZombieInMap();
            Map.getMapInstance().getMapDetail()[4][1].tanam(new SnowPea());
            
            Map.getMapInstance().getMapDetail()[5][10].getZombieList().add(new FootballZombie());
            Map.getMapInstance().addZombieInMap();
            Map.getMapInstance().getMapDetail()[5][1].tanam(new SnowPea());

            Map.getMapInstance().getMapDetail()[2][8].getZombieList().add(new DuckytubeConeheadZombie());
            Map.getMapInstance().addZombieInMap();
            Map.getMapInstance().getMapDetail()[2][8].tanam(new TangleKelp());


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
