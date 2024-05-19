package Map;
import Exception.NotPlantableException;
import Exception.NotShovelableException;
import Plant.Lilypad;
import Plant.Repeater;
import Plant.Squash;
import Plant.Wallnut;

public class TesMap {
    public static void main(String[] args) {
        Map map = Map.getMapInstance();
        Map anothermap = Map.getMapInstance();
        try {
   //         System.out.println("tes1");
            anothermap.getMapDetail()[0][1].tanam(new Squash());
 //           System.out.println("tes2");
            map.getMapDetail()[0][2].tanam(new Repeater());
//            System.out.println("tes3");
            map.getMapDetail()[2][1].tanam(new Lilypad());
            map.getMapDetail()[2][1].tanam(new Wallnut());
            map.getMapDetail()[2][1].getPlant().setHealth(101);
            map.getMapDetail()[2][1].gali();

        } catch (NotPlantableException e) {
           System.out.println(e.getMessage());
        } catch (NotShovelableException e) {
           System.out.println(e.getMessage());
        }
        anothermap.renderMap();

    }
}
