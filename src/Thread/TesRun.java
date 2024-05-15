package Thread;
import Map.*;
import Main.SpawnZombie;

public class TesRun {
    public static void main(String[] args) {
        while (true) {
            try {
                Runnable time = Time.getTime();
                Thread timeThread = new Thread(time);
                timeThread.run();
    
                System.out.println("Current time : " + Time.getTime().getTotalSeconds() + " (" + Time.getTime().getCurrentPhase() + ")");

                Thread spawnerThread = new Thread(new SpawnZombie());
                spawnerThread.start();
                Thread entityThread = new Thread(new EntityThreadRow1());
                entityThread.start();

                spawnerThread.join();
                Map.getMapInstance().renderMap();
                
            } catch (Exception e) {
            }
            
        }
    }
}
