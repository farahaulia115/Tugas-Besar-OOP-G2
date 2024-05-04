package Map;

import Plant.Peashooter;

public class TesMap {
    public static void main(String[] args) {
        Map map = Map.getMapInstance();
        Map anothermap = Map.getMapInstance();
        try {
            map.getMapDetail()[1][0].tanam(new Peashooter());
        } catch (NotPlantableException e) {
           System.out.println(e.getMessage());
        }

        if (map.equals(anothermap)){
            System.out.println("yey");
        }
    }
}
