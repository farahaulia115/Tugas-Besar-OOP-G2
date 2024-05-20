package tubes.maven.Map;

import tubes.maven.Exception.NotPlantableException;
import tubes.maven.Plant.*;
import tubes.maven.Zombie.*;

public class Map{
    private static Map map;
    private Tile[][] mapdetail = new Tile[6][11];
    private int zombieInMap = 0;

    private String green = "\u001B[32m";     // Kode ANSI untuk warna hijau
    private String blue = "\u001B[34m";      // Kode ANSI untuk warna biru
    private String pink = "\u001B[35m";      // Kode ANSI untuk warna pink
    private String cream = "\u001B[33m";     // Kode ANSI untuk warna cream
    private  String reset = "\u001B[0m";       // Kode ANSI untuk mereset warna

    
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

    public void removeZombieInMap(int jumlah){
        zombieInMap-=jumlah;
    }

    public void resetZombieInMap(){
        zombieInMap = 0;
    }
    
    public void tanamAt(int x, int y, Plant plant) throws NotPlantableException{
            mapdetail[x][y].tanam(plant);
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

    public void renderMap3() {
        for (int i = 0; i <= 5; i++) {
            for (int j = 0; j <= 10; j++) {
                System.out.printf("[");
                if (mapdetail[i][j].isAdaTanaman() || mapdetail[i][j].getZombieList().size() > 0) {
                    if (mapdetail[i][j].isAdaTanaman()) {
                        if (mapdetail[i][j].getPlant() instanceof SunFlower) {
                            System.out.printf("S:" + mapdetail[i][j].getPlant().getHealth() + " ");
                        } 
                        else if (mapdetail[i][j].getPlant() instanceof TwinSunFlower){
                            System.out.printf("TS:" + mapdetail[i][j].getPlant().getHealth() + " ");
                        }
                        else if (mapdetail[i][j].getPlant() instanceof Peashooter){
                            System.out.printf("P:" + mapdetail[i][j].getPlant().getHealth() + " ");
                        }
                        else if (mapdetail[i][j].getPlant() instanceof Repeater){
                            System.out.printf("R:" + mapdetail[i][j].getPlant().getHealth() + " ");
                        }
                        else if (mapdetail[i][j].getPlant() instanceof SnowPea){
                            System.out.printf("SP:" + mapdetail[i][j].getPlant().getHealth() + " ");
                        }
                        else if (mapdetail[i][j].getPlant() instanceof Squash){
                            System.out.printf("Sq:" + mapdetail[i][j].getPlant().getHealth() + " ");
                        }
                        else if (mapdetail[i][j].getPlant() instanceof Tallnut){
                            System.out.printf("T:" + mapdetail[i][j].getPlant().getHealth() + " ");
                        }
                        else if (mapdetail[i][j].getPlant() instanceof Lilypad){
                            System.out.printf("L:" + mapdetail[i][j].getPlant().getHealth() + " ");
                        }
                        else if (mapdetail[i][j].getPlant() instanceof Wallnut){
                            System.out.printf("W:" + mapdetail[i][j].getPlant().getHealth() + " ");
                        }
                        else if (mapdetail[i][j].getPlant() instanceof TangleKelp){
                            System.out.printf("TK:" + mapdetail[i][j].getPlant().getHealth() + " ");
                        }
                    }
                    if (mapdetail[i][j].getZombieList().size() > 0) {
                        for (Zombie z : mapdetail[i][j].getZombieList()) {
                            if (z instanceof CanJump && !((CanJump) z).alreadyJumped()) {
                                System.out.printf("J");
                            }
                            if (z instanceof NormalZombie) {
                                System.out.printf("Z:" + z.getHealth() + " ");
                            } else if (z instanceof ConeheadZombie) {
                                System.out.printf("CZ:" + z.getHealth() + " ");
                            } else if (z instanceof BucketheadZombie) {
                                System.out.printf("BZ:" + z.getHealth() + " ");
                            } else if (z instanceof FootballZombie) {
                                System.out.printf("FZ:" + z.getHealth() + " ");
                            } else if (z instanceof PolevaultingZombie) {
                                System.out.printf("PZ:" + z.getHealth() + " ");
                            } else if (z instanceof ScreendoorZombie) {
                                System.out.printf("SZ:" + z.getHealth() + " ");
                            } else if (z instanceof WallnutZombie) {
                                System.out.printf("WZ:" + z.getHealth() + " ");
                            } else if (z instanceof DolphinriderZombie) {
                                System.out.printf("DoZ:" + z.getHealth() + " ");
                            } else if (z instanceof DuckytubeConeheadZombie) {
                                System.out.printf("DCZ:" + z.getHealth() + " ");
                            } else if (z instanceof DuckytubeZombie) {
                                System.out.printf("DZ:" + z.getHealth() + " ");
                            }
                        }
                    }
                } else {
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

    // public void PlantAttack() {
    //     for (int i = 0; i <= 5; i++) {
    //         for (int j = 1; j <= 9; i++) { 
    //             Tile tile = mapdetail[i][j];
    //             if (tile.isAdaTanaman() && tile.getPlant() instanceof Attack) {
    //                 Attack attackingPlants = (Attack) tile.getPlant();
    //                 if (!tile.getZombieList().isEmpty()) {
    //                     for (Zombie z : tile.getZombieList()) {
    //                         if (attackingPlants instanceof Shooter) {
    //                             ((Shooter) attackingPlants).startAttack(tile);
    //                         }
    //                         if (attackingPlants instanceof SelfDestruct) {
    //                             attackingPlants.attack(z);
    //                             ((SelfDestruct) attackingPlants).selfDestruct(tile);
    //                         }
    //                         if (z.getHealth() <= 0) {