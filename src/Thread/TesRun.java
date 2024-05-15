package Thread;
import Map.*;
public class TesRun {
    public static void main(String[] args) {
        while (true) {
            try {
                Thread.sleep(1000);
                Thread spawnerThread = new Thread(new ZombieSpawnThread());
                spawnerThread.start();
                spawnerThread.join();
                Map.getMapInstance().renderMap();
            } catch (Exception e) {
                // TODO: handle exception
            }
            
        }
    }
}
