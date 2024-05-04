package Map;

public class Map{

    private Plot[][] map = new Plot[6][11];

    public Map(){
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

    public void printMap(){

    }
}