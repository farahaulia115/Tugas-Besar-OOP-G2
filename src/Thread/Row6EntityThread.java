package Thread;
import Map.*;
import Plant.Attack;
import Plant.ProduceSun;
import Plant.SelfDestruct;
import Zombie.CanJump;
import Zombie.Zombie;

public class Row6EntityThread implements Runnable{
    public void run(){
        for (int i = 1;i<=10;i++){
            Tile tile = Map.getMapInstance().getMapDetail()[5][i];
            Tile nextTile = Map.getMapInstance().getMapDetail()[5][i-1];
            if (tile.isAdaTanaman()){
                if (tile.getPlant().getHealth()>0){
                    if (tile.getPlant() instanceof Attack && tile.getPlant().getRange()==-1){
                        Attack pa = (Attack)tile.getPlant();
                        for(int y = i;y<=10;y++){
                            Tile tileToAttack = Map.getMapInstance().getMapDetail()[5][y];
                            if (tileToAttack.getZombieList().size()>0){
                                pa.startAttack(tileToAttack);
                                break;
                            }
                        }
                    }
                    else if (tile.getPlant() instanceof Attack && tile.getPlant() instanceof SelfDestruct){
                        Attack pa = (Attack)tile.getPlant();
                        SelfDestruct ps = (SelfDestruct)tile.getPlant();
                        if (i<10){
                            Tile tileToAttack = Map.getMapInstance().getMapDetail()[5][i+1];
                            if (tileToAttack.getZombieList().size()>0){
                                pa.attack(tileToAttack);
                                ps.selfDestruct(tile);
                            }
                        }
                    }
                    else if (tile.getPlant() instanceof ProduceSun){
                        ProduceSun pps = (ProduceSun)tile.getPlant();
                        pps.produceSun();
                    }
                }
            }
            if (tile.getZombieList().size()>0){     
                if (tile.isAdaTanaman()){
                    for (Zombie z : tile.getZombieList()){
                        z.checkSlowEffect();
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
                        z.checkSlowEffect();
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
