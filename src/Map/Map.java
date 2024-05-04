package Map;

public class Map{

    private static Tile[][] map = new Tile[6][11];
    private Map(){
        for (int i = 0;i<=1;i++){
            for (int j = 1;j<=9;j++){
                map[i][j] = new Land();
            }
        }
        for (int i = 2;i<=3;i++){
            for (int j = 1;j<=9;j++){
                map[i][j] = new Water();
            }
        }
        for (int i = 4;i<=5;i++){
            for (int j = 1;j<=9;j++){
                map[i][j] = new Land();
            }
        }
        for (int i = 0;i<=5;i++){
            map[i][0] = new RestrictedPlot();
            map[i][10] = new RestrictedPlot();
        }
    }

    public static Map getMapInstance(){
        return new Map();
    }
}