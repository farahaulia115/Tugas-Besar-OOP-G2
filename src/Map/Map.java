package Map;

import Plant.Attack;
import Plant.Plant;
import Zombie.CanJump;
import Plant.SelfDestruct;
import Zombie.Zombie;

public class Map{
    private static Map map;
    private Tile[][] mapdetail = new Tile[6][11];
    private int zombieInMap = 0;
    
    private Map(){
        for (int i = 0;i<=1;i++){
            for (int j = 1;j<=9;j++){
                mapdetail[i][j] = new Land();
            }
        }
        for (int i = 2;i<=3;i++){
            for (int j = 1;j<=9;j++){
                mapdetail[i][j] = new Water();
            }
        }
        for (int i = 4;i<=5;i++){
            for (int j = 1;j<=9;j++){
                mapdetail[i][j] = new Land();
            }
        }
        for (int i = 0;i<=5;i++){
            mapdetail[i][0] = new RestrictedPlot();
            mapdetail[i][10] = new RestrictedPlot();
        }
    }

    public static Map getMapInstance(){
        if (map == null) {
            map = new Map();
        }
        return map;
    }

    public Tile[][] getMapDetail(){
        return mapdetail;
    }

    public int jumlahZombie(){
        // int jumlah = 0;
        // for (int i = 0; i<=5;i++){
        //     for (int j = 1; j<=9;j++){
        //         jumlah += mapdetail[i][j].getZombieList().size();
        //     }
        // }
        // return jumlah;
        return zombieInMap;
    }

    public void addZombieInMap(){
        zombieInMap++;
    }

    public void removeZombieInMap(){
        zombieInMap--;
    }
    
    public void tanamAt(int x, int y, Plant plant){
        try{
            mapdetail[x][y].tanam(plant);
        }
        catch (NotPlantableException e){
            System.out.println(e.getMessage());
        }
    }

    public void renderMap(){
        for (int i = 0; i<=5;i++){
            for (int j = 1; j<=10;j++){
                System.out.printf("[");
                if (mapdetail[i][j].isAdaTanaman() || mapdetail[i][j].getZombieList().size()>0){
                    if (mapdetail[i][j].isAdaTanaman()){
                        System.out.printf("P:" + mapdetail[i][j].getPlant().getHealth() + " ");
                    }
                    if (mapdetail[i][j].getZombieList().size()>0){
                        for (Zombie z : mapdetail[i][j].getZombieList()) {
                            if (z instanceof CanJump){
                                if (!((CanJump)z).alreadyJumped()) System.out.printf("J");
                            }
                            System.out.printf("Z:" + z.getHealth() + " ");
                        }      
                    }
                }
                else{
                    System.out.printf(" ");
                }
                System.out.printf("]");
                
            }
            System.out.println();
        }
        System.out.println();
    }

    public void renderMap2(){
        for (int i = 0; i<=5;i++){
            for (int j = 1; j<=9;j++){
                System.out.printf("[");
                if (mapdetail[i][j].isAdaTanaman() || mapdetail[i][j].getZombieList().size()>0){
                    if (mapdetail[i][j].isAdaTanaman()){
                        System.out.printf("P:" + mapdetail[i][j].getPlant().getHealth() + " ");
                    }
                    if (mapdetail[i][j].getZombieList().size()>0){
                        for (Zombie z : mapdetail[i][j].getZombieList()) {
                            System.out.printf("Z:" + z.getClass().getCanonicalName() + " ");
                        }      
                    }
                }
                else{
                    System.out.printf(" ");
                }
                System.out.printf("]");
                
            }
            System.out.println();
        }
        System.out.println();
    }

    public void PlantAttack() {
        for (int i = 0; i <= 5; i++) {
            for (int j = 1; j <= 9; i++) { 
                Tile tile = mapdetail[i][j];
                if (tile.isAdaTanaman() && tile.getPlant() instanceof Attack) {
                    Attack attackingPlants = (Attack) tile.getPlant();
                    if (!tile.getZombieList().isEmpty()) {
                        for (Zombie z : tile.getZombieList()) {
                            attackingPlants.attack(z);
                            if (attackingPlants instanceof SelfDestruct) {
                                ((SelfDestruct) attackingPlants).selfDestruct(tile);
                            }
                            if (z.getHealth() <= 0) {
                                tile.getZombieList().remove(z);
                                removeZombieInMap();
                            }
                        }
                    }
                }
            }
        }
    }


    public boolean zombieMenang(){
        for (int i = 0; i<=5;i++){
            if (mapdetail[i][0].getZombieList().size() > 0){
                return true;
            }
        }
        return false;
    }
}