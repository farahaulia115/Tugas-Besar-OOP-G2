package Thread;
import Map.*;
import Zombie.CanJump;
import Zombie.Zombie;

public class Row4EntityThread implements Runnable{
    public void run(){
        for (int i = 1;i<=10;i++){
            Tile tile = Map.getMapInstance().getMapDetail()[3][i];
            Tile nextTile = Map.getMapInstance().getMapDetail()[3][i-1];
            if (tile.isAdaTanaman()){

            }
            if (tile.getZombieList().size()>0){     
                if (tile.isAdaTanaman()){
                    for (Zombie z : tile.getZombieList()){
                        if (z instanceof CanJump){
                            CanJump zj = (CanJump)z;
                            if (!zj.alreadyJumped()){
                                zj.jump();
                                if (tile.getPlant().isJumpable()){
                                    tile.plantDie();
                                }
                                z.setTimeSpawn();
                            }
                        }
                        if (tile.isAdaTanaman()){
                            if (z.getTimeSpawn() != Time.getTime().getTotalSeconds() && (Time.getTime().getTotalSeconds()-z.getTimeSpawn())%z.getSpeed()==0)
                            tile.getPlant().setHealth(tile.getPlant().getHealth()-z.getDamage());
                            if (tile.getPlant().getHealth()<=0){
                                tile.plantDie();
                                for (Zombie zo : tile.getZombieList()){
                                    zo.setTimeSpawn();
                                }
                                break;
                            }
                        }
                    }
                }

                else{
                    for (Zombie z : tile.getZombieList()){
                        if (z instanceof CanJump){
                            CanJump zj = (CanJump)z;
                            if (!zj.alreadyJumped()){
                                if (nextTile.isAdaTanaman()){
                                    zj.jump();
                                    if (nextTile.getPlant().isJumpable()){
                                        nextTile.plantDie();
                                    }
                                    z.setTimeSpawn();
                                    tile.getZombieList().remove(z);
                                    nextTile.getZombieList().add(z);
                                }
                            }
                        }
                        if (z.getTimeSpawn() != Time.getTime().getTotalSeconds() && (Time.getTime().getTotalSeconds() - z.getTimeSpawn())%z.getMoveInterval()==0){
                            tile.getZombieList().remove(z);
                            nextTile.getZombieList().add(z);
                        }
                    }
                }
            }
        }
        
    }
}
