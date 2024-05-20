package tubes.maven.Map;

import tubes.maven.Exception.NotPlantableException;
import tubes.maven.Plant.*;
import tubes.maven.Zombie.*;

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

    public void removeZombieInMap(int jumlah){
        zombieInMap-=jumlah;
    }

    public void resetZombieInMap(){
        zombieInMap = 0;
    }
    
    public void tanamAt(int x, int y, Plant plant) throws NotPlantableException{
            mapdetail[x][y].tanam(plant);
    }

    public void renderMap3(){
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

    public void renderMap() {
        // ANSI escape codes for colors
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_GREEN = "\u001B[32m";
        final String ANSI_PINK = "\u001B[35m";
        final String ANSI_CREAM = "\u001B[33m";
        final String ANSI_PURPLE = "\u001B[35m";
    
        // Print column headers
        System.out.print("   ");
        for (int j = 0; j <= 10; j++) {
            System.out.printf(ANSI_RED + "%2d  " + ANSI_RESET, j);
        }
        System.out.println();
    
        for (int i = 0; i < 6; i++) {
            // Print row header starting from 1 to 6
            System.out.printf(ANSI_RED + "%2d " + ANSI_RESET, i + 1);
    
            for (int j = 0; j <= 10; j++) {
                // Select the appropriate color for the grid
                if ((i == 2 || i == 3) && j > 0 && j < 10) {
                    System.out.printf(ANSI_BLUE + "[" + ANSI_RESET);
                } else if ((i == 0 || i == 1 || i == 4 || i == 5) && j > 0 && j < 10) {
                    System.out.printf(ANSI_GREEN + "[" + ANSI_RESET);
                } else if (j == 0) {
                    System.out.printf(ANSI_PINK + "[" + ANSI_RESET);
                } else if (j == 10) {
                    System.out.printf(ANSI_CREAM + "[" + ANSI_RESET);
                }
    
                // Add plant information if present
                if (mapdetail[i][j].isAdaTanaman()) {
                    if (mapdetail[i][j].getPlant() instanceof SunFlower) {
                        System.out.printf(ANSI_PURPLE + "S:%d " + ANSI_RESET, mapdetail[i][j].getPlant().getHealth());
                    } else if (mapdetail[i][j].getPlant() instanceof TwinSunFlower) {
                        System.out.printf(ANSI_PURPLE + "TS:%d " + ANSI_RESET, mapdetail[i][j].getPlant().getHealth());
                    } else if (mapdetail[i][j].getPlant() instanceof Peashooter) {
                        System.out.printf(ANSI_PURPLE + "P:%d " + ANSI_RESET, mapdetail[i][j].getPlant().getHealth());
                    } else if (mapdetail[i][j].getPlant() instanceof Repeater) {
                        System.out.printf(ANSI_PURPLE + "R:%d " + ANSI_RESET, mapdetail[i][j].getPlant().getHealth());
                    } else if (mapdetail[i][j].getPlant() instanceof SnowPea) {
                        System.out.printf(ANSI_PURPLE + "SP:%d " + ANSI_RESET, mapdetail[i][j].getPlant().getHealth());
                    } else if (mapdetail[i][j].getPlant() instanceof Squash) {
                        System.out.printf(ANSI_PURPLE + "Sq:%d " + ANSI_RESET, mapdetail[i][j].getPlant().getHealth());
                    } else if (mapdetail[i][j].getPlant() instanceof Tallnut) {
                        System.out.printf(ANSI_PURPLE + "T:%d " + ANSI_RESET, mapdetail[i][j].getPlant().getHealth());
                    } else if (mapdetail[i][j].getPlant() instanceof Lilypad) {
                        System.out.printf(ANSI_PURPLE + "L:%d " + ANSI_RESET, mapdetail[i][j].getPlant().getHealth());
                    } else if (mapdetail[i][j].getPlant() instanceof Wallnut) {
                        System.out.printf(ANSI_PURPLE + "W:%d " + ANSI_RESET, mapdetail[i][j].getPlant().getHealth());
                    } else if (mapdetail[i][j].getPlant() instanceof TangleKelp) {
                        System.out.printf(ANSI_PURPLE + "TK:%d " + ANSI_RESET, mapdetail[i][j].getPlant().getHealth());
                    }
                }
    
                // Add zombie information if present
                if (mapdetail[i][j].getZombieList().size() > 0) {
                    for (Zombie z : mapdetail[i][j].getZombieList()) {
                        if (z instanceof CanJump && !((CanJump) z).alreadyJumped()) {
                            System.out.printf(ANSI_RED + "J" + ANSI_RESET);
                        }
                        if (z instanceof NormalZombie) {
                            System.out.printf(ANSI_RED + "Z:%d " + ANSI_RESET, z.getHealth());
                        } else if (z instanceof ConeheadZombie) {
                            System.out.printf(ANSI_RED + "CZ:%d " + ANSI_RESET, z.getHealth());
                        } else if (z instanceof BucketheadZombie) {
                            System.out.printf(ANSI_RED + "BZ:%d " + ANSI_RESET, z.getHealth());
                        } else if (z instanceof FootballZombie) {
                            System.out.printf(ANSI_RED + "FZ:%d " + ANSI_RESET, z.getHealth());
                        } else if (z instanceof PolevaultingZombie) {
                            System.out.printf(ANSI_RED + "PZ:%d " + ANSI_RESET, z.getHealth());
                        } else if (z instanceof ScreendoorZombie) {
                            System.out.printf(ANSI_RED + "SZ:%d " + ANSI_RESET, z.getHealth());
                        } else if (z instanceof WallnutZombie) {
                            System.out.printf(ANSI_RED + "WZ:%d " + ANSI_RESET, z.getHealth());
                        } else if (z instanceof DolphinriderZombie) {
                            System.out.printf(ANSI_RED + "DoZ:%d " + ANSI_RESET, z.getHealth());
                        } else if (z instanceof DuckytubeConeheadZombie) {
                            System.out.printf(ANSI_RED + "DCZ:%d " + ANSI_RESET, z.getHealth());
                        } else if (z instanceof DuckytubeZombie) {
                            System.out.printf(ANSI_RED + "DZ:%d " + ANSI_RESET, z.getHealth());
                        }
                    }
                } else {
                    System.out.printf("   ");
                }
    
                // Close the bracket for the grid
                if ((i == 2 || i == 3) && j > 0 && j < 10) {
                    System.out.printf(ANSI_BLUE + "]" + ANSI_RESET);
                } else if ((i == 0 || i == 1 || i == 4 || i == 5) && j > 0 && j < 10) {
                    System.out.printf(ANSI_GREEN + "]" + ANSI_RESET);
                } else if (j == 0) {
                    System.out.printf(ANSI_PINK + "]" + ANSI_RESET);
                } else if (j == 10) {
                    System.out.printf(ANSI_CREAM + "]" + ANSI_RESET);
                }
            }
            System.out.println();
        }
        System.out.println();
    }
    
    
    

    public void renderMap4() {
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

    public boolean zombieMenang(){
        for (int i = 0; i<=5;i++){
            if (mapdetail[i][0].getZombieList().size() > 0){
                return true;
            }
        }
        return false;
    }

    public void resetMap(){
        Map.getMapInstance().resetZombieInMap();
        for (int i = 0; i<=5;i++){
            for (int j = 0; j<=10;j++){
                mapdetail[i][j].getZombieList().clear();
                mapdetail[i][j].plantDie();
            }
        }
    }
}