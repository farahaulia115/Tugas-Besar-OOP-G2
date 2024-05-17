package Thread;
import Map.*;
import Zombie.CanJump;
import Zombie.Zombie;

public class Row4EntityThread implements Runnable{
    public void run(){
        for (int i = 1;i<=10;i++){
            Tile tile = Map.getMapInstance().getMapDetail()[3][i];
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
                            if (zj.alreadyJumped()==false && Map.getMapInstance().getMapDetail()[3][i-1].isAdaTanaman()==true){
                                zj.jump();
                                if (Map.getMapInstance().getMapDetail()[3][i-1].getPlant().isJumpable()==true){
                                    Map.getMapInstance().getMapDetail()[3][i-1].plantDie();
                                }
                                z.setTimeSpawn();
                                tile.getZombieList().remove(z);
                                Map.getMapInstance().getMapDetail()[3][i-1].getZombieList().add(z);
                            }
                        }
                        if (z.getTimeSpawn() != Time.getTime().getTotalSeconds() && (Time.getTime().getTotalSeconds() - z.getTimeSpawn())%z.getMoveInterval()==0){
                            tile.getZombieList().remove(z);
                            Map.getMapInstance().getMapDetail()[3][i-1].getZombieList().add(z);
                        }
                    }
                }
            }
        }
        
    }
}

// while ((tile.getZombieList().peek() instanceof CanJump) || (Time.getTime().getTotalSeconds() != tile.getZombieList().peek().getTimeSpawn() && (Time.getTime().getTotalSeconds() - tile.getZombieList().peek().getTimeSpawn())%5==0)){
//     if (tile.getZombieList().peek() instanceof CanJump){
//         CanJump zj = (CanJump)tile.getZombieList().peek();
//         if (zj.alreadyJumped()==false && Map.getMapInstance().getMapDetail()[3][i-1].isAdaTanaman()==true){
//             zj.jump();
//             Map.getMapInstance().getMapDetail()[3][i-1].plantDie();
//         }
//         else if ((Time.getTime().getTotalSeconds() == tile.getZombieList().peek().getTimeSpawn() || (Time.getTime().getTotalSeconds() - tile.getZombieList().peek().getTimeSpawn())%5!=0)){
//             break;
//         }

//     }
//     else if (tile.getZombieList().){
//         Zombie z = tile.getZombieList().poll();
//         Map.getMapInstance().getMapDetail()[3][i-1].getZombieList().add(z);
//         if (tile.getZombieList().size()==0 ){
//             break;
//         }
//     }
// }
