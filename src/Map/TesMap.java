package Map;

import Plant.Peashooter;
import Plant.Repeater;
import Plant.Squash;
import Zombie.*;

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
            map.getMapDetail()[0][2].getZombieList().add(new PolevaultingZombie());
            map.getMapDetail()[0][2].getZombieList().add(new PolevaultingZombie());
            map.renderMap();

            
        } catch (NotPlantableException e) {
           System.out.println(e.getMessage());
        // } catch (NotShovelableException e) {
        //     System.out.println(e.getMessage());
        }

        if (map.equals(anothermap)){
            System.out.println("yey");
        }
    }
}
