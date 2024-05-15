package Thread;
import Map.*;
import Zombie.Zombie;

public class Row3EntityThread implements Runnable{
    public void run(){
        for (int i = 1;i<=10;i++){
            Tile tile = Map.getMapInstance().getMapDetail()[2][i];
            if (tile.isAdaTanaman()){

            }
            if (tile.getZombieList().size()>0){     
                if (tile.isAdaTanaman()){
                    for (Zombie z : tile.getZombieList()){
                        tile.getPlant().setHealth(tile.getPlant().getHealth()-z.getDamage());
                        if (tile.getPlant().getHealth()<=0){
                            try {
                                tile.gali();
                                for (Zombie zo : tile.getZombieList()){
                                    zo.setTimeSpawn();
                                }
                                break;
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        }
                    }
                }

                else{
                    while (Time.getTime().getTotalSeconds() != tile.getZombieList().peek().getTimeSpawn() && (Time.getTime().getTotalSeconds() - tile.getZombieList().peek().getTimeSpawn())%5==0){
                        Zombie z = tile.getZombieList().poll();
                        Map.getMapInstance().getMapDetail()[2][i-1].getZombieList().add(z);
                        if (tile.getZombieList().size()==0 ){
                            break;
                        }
                    }
                }
            }
        }
        
    }
}
