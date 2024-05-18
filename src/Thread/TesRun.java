package Thread;
import Map.*;
import Plant.*;
import Main.Game;
import Main.SpawnZombie;
import Zombie.*;

public class TesRun {
    public static void main(String[] args) {
        try {
            Map.getMapInstance().getMapDetail()[0][9].tanam(new Tallnut());
            Map.getMapInstance().getMapDetail()[0][1].tanam(new Repeater());
            Map.getMapInstance().getMapDetail()[1][8].tanam(new Tallnut());
            Map.getMapInstance().getMapDetail()[2][1].tanam(new Lilypad());
            Map.getMapInstance().getMapDetail()[0][2].tanam(new Squash());
            Map.getMapInstance().getMapDetail()[0][3].getZombieList().add(new PolevaultingZombie());
            Map.getMapInstance().getMapDetail()[3][6].tanam(new Lilypad());
            Map.getMapInstance().getMapDetail()[4][5].tanam(new Tallnut());
            Map.getMapInstance().getMapDetail()[5][4].tanam(new Tallnut());

            Map.getMapInstance().getMapDetail()[0][9].getZombieList().add(new DolphinriderZombie());
            Map.getMapInstance().getMapDetail()[2][7].tanam(new TangleKelp());
            //Map.getMapInstance().getMapDetail()[2][7].tanam(new Squash());
            Map.getMapInstance().getMapDetail()[2][9].getZombieList().add(new DolphinriderZombie());
            //Map.getMapInstance().getMapDetail()[2][7].gali();
            Map.getMapInstance().renderMap3();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        Game.setStatusGame(true);

        while (Game.getStatusGame()) {
            try {
                Runnable time = Time.getTime();
                Thread timeThread = new Thread(time);
                Thread spawnerThread = new Thread(new SpawnZombie());
                Thread entityThread1 = new Thread(new Row1EntityThread());
                Thread entityThread2 = new Thread(new Row2EntityThread());
                Thread entityThread3 = new Thread(new Row3EntityThread());
                Thread entityThread4 = new Thread(new Row4EntityThread());
                Thread entityThread5 = new Thread(new Row5EntityThread());
                Thread entityThread6 = new Thread(new Row6EntityThread());

                Thread.sleep(1000); // Menghentikan thread selama 1 detik
                timeThread.start();
                timeThread.join();
                System.out.println("Current time : " + Time.getTime().getTotalSeconds() + " (" + Time.getTime().getCurrentPhase() + ")");

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
                //if (Map.getMapInstance().zombieMenang()) System.exit(0);;

            } catch (Exception e) {
                Thread.currentThread().interrupt();
            }
            
        }
    }
}
