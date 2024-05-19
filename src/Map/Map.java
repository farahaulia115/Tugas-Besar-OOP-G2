package Map;

import Exception.NotPlantableException;
import Plant.Plant;
import Zombie.CanJump;
import Zombie.Zombie;

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
                StringBuilder tileContent = new StringBuilder();
                String colorStart, colorEnd;
    
                // Determine color based on row and column
                if (i == 2 || i == 3) {
                    colorStart = (j == 0) ? pink : (j == 10) ? cream : blue;
                    colorEnd = colorStart;
                } else {
                    colorStart = (j == 0) ? pink : (j == 10) ? cream : green;
                    colorEnd = colorStart;
                }
    
                // Append plant and zombie information
                if (mapdetail[i][j].isAdaTanaman() || mapdetail[i][j].getZombieList().size() > 0) {
                    if (mapdetail[i][j].isAdaTanaman()) {
                        tileContent.append("P:").append(mapdetail[i][j].getPlant().getHealth()).append(" ");
                    }
                    if (mapdetail[i][j].getZombieList().size() > 0) {
                        for (Zombie z : mapdetail[i][j].getZombieList()) {
                            if (z instanceof CanJump && !((CanJump) z).alreadyJumped()) {
                                tileContent.append("J");
                            }
                            tileContent.append("Z:").append(z.getHealth()).append(" ");
                        }
                    }
                }
    
                // Ensure the content fits within 11 characters (leaving 2 characters for the brackets)
                String content = tileContent.toString();
                if (content.length() > 11) {
                    content = content.substring(0, 10) + "…"; // Truncate and add ellipsis if too long
                }
    
                // Format the tile to ensure it has 11 characters, including the brackets
                String tile = String.format("%s[%-11s]%s", colorStart, content, reset);
    
                // Print the tile
                System.out.print(tile);
            }
            System.out.println();
        }
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
    //                             tile.getZombieList().remove(z);
    //                             removeZombieInMap();
    //                         }
    //                     }
    //                 }
    //             }
    //         }
    //     }
    // }


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