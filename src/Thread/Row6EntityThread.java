package Thread;
import Map.*;
import Zombie.CanJump;
import Zombie.Zombie;

public class Row6EntityThread implements Runnable{
    public void run(){
        for (int i = 1;i<=10;i++){
            Tile tile = Map.getMapInstance().getMapDetail()[5][i];
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
                    for (Zombie z : tile.getZombieList()){
                        if (z instanceof CanJump){
                            CanJump zj = (CanJump)z;
                            if (zj.alreadyJumped()==false && Map.getMapInstance().getMapDetail()[5][i-1].isAdaTanaman()==true){
                                zj.jump();
                                if (Map.getMapInstance().getMapDetail()[5][i-1].getPlant().isJumpable()==true){
                                    Map.getMapInstance().getMapDetail()[5][i-1].plantDie();
                                }
                                z.setTimeSpawn();
                                tile.getZombieList().remove(z);
                                Map.getMapInstance().getMapDetail()[5][i-1].getZombieList().add(z);
                            }
                        }
                        if (z.getTimeSpawn() != Time.getTime().getTotalSeconds() && (Time.getTime().getTotalSeconds() - z.getTimeSpawn())%5==0){
                            tile.getZombieList().remove(z);
                            Map.getMapInstance().getMapDetail()[5][i-1].getZombieList().add(z);
                        }
                    }

                }
            }
        }
        
    }
}
