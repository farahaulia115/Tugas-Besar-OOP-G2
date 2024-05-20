package tubes.maven.Thread;
import tubes.maven.Map.*;
import tubes.maven.Plant.Attack;
import tubes.maven.Plant.ProduceSun;
import tubes.maven.Plant.SelfDestruct;
import tubes.maven.Zombie.CanJump;
import tubes.maven.Zombie.Zombie;

public class Row1EntityThread implements Runnable{
    public void run(){
        for (int i = 1;i<=10;i++){
            Tile tile = Map.getMapInstance().getMapDetail()[0][i];
            Tile nextTile = Map.getMapInstance().getMapDetail()[0][i-1];
            Tile nextNextTile = null;
            if (i>=2){
                nextNextTile = Map.getMapInstance().getMapDetail()[0][i-2];
            }
            if (tile.isAdaTanaman()){
                if (tile.getPlant().getHealth()>0){
                    if (tile.getPlant() instanceof Attack && tile.getPlant().getRange()==-1){
                        Attack pa = (Attack)tile.getPlant();
                        for(int y = i;y<=9;y++){
                            Tile tileToAttack = Map.getMapInstance().getMapDetail()[0][y];
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
                            Tile tileToAttack = Map.getMapInstance().getMapDetail()[0][i+1];
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
                                    nextTile.plantDie();
                                    z.setTimeSpawn();
                                    tile.getZombieList().remove(z);
                                    nextTile.getZombieList().add(z);
                                }
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
                                    if (nextTile.getPlant().isJumpable() && i>=2){
                                       nextNextTile.plantDie();
                                       z.setTimeSpawn();
                                       if (i>=2){
                                           tile.getZombieList().remove(z);
                                           nextNextTile.getZombieList().add(z);
                                       }
                                    }
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
