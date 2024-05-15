package Thread;
import Map.*;
import Zombie.Zombie;

public class EntityThreadRow1 implements Runnable{
    public void run(){
        for (int i = 1;i<=10;i++){
            Tile tile = Map.getMapInstance().getMapDetail()[0][i];
            if (tile.isAdaTanaman()){

            }
            if (tile.getZombieList().size()>0){     
                while ((Time.getTime().getTotalSeconds() - tile.getZombieList().peek().getTimeSpawn())%5==0){
                    Zombie z = tile.getZombieList().poll();
                    Map.getMapInstance().getMapDetail()[0][i-1].getZombieList().add(z);
                    if (tile.getZombieList().size()==0 ){
                        break;
                    }
                }
            }
        }
        
    }
}
