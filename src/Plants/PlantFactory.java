
package Plants;

public class PlantFactory {

    public Plants createPlant(String type){
        if (type.equalsIgnoreCase("SunFlower")){
            return new Sunflower();
        } 
        else if (type.equalsIgnoreCase("TwinSunFlower")){
            return new TwinSunflower();
        }
        else if (type.equalsIgnoreCase("TangleKelp")){
            return new TangleKelp();
        }
        else if (type.equalsIgnoreCase("Peashooter")){
            return new Peashooter();
        }
        else if (type.equalsIgnoreCase("Repeater")){
            return new Repeater();
        }
        else if (type.equalsIgnoreCase("SnowPea")){
            return new SnowPea();
        }
        else if (type.equalsIgnoreCase("Squash")){
            return new Squash();
        }
        else if (type.equalsIgnoreCase("Tallnut")){
            return new Tallnut();
        }
        else if (type.equalsIgnoreCase("Lilypad")){
            return new LilyPad();
        }
        else if (type.equalsIgnoreCase("Wallnut")){
            return new Wallnut();
        }
       
        
        return null;
        
    }
}
