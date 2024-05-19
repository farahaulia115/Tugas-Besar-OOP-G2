
package tubes.maven.Plant;

public class PlantFactory {

    public Plant createPlant(String type){
        if (type.equalsIgnoreCase("Sunflower")){
            return new SunFlower();
        } 
        else if (type.equalsIgnoreCase("Twin Sunflower")){
            return new TwinSunFlower();
        }
        else if (type.equalsIgnoreCase("Tangle kelp")){
            return new TangleKelp();
        }
        else if (type.equalsIgnoreCase("Peashooter")){
            return new Peashooter();
        }
        else if (type.equalsIgnoreCase("Repeater")){
            return new Repeater();
        }
        else if (type.equalsIgnoreCase("Snow pea")){
            return new SnowPea();
        }
        else if (type.equalsIgnoreCase("Squash")){
            return new Squash();
        }
        else if (type.equalsIgnoreCase("Tall nut")){
            return new Tallnut();
        }
        else if (type.equalsIgnoreCase("Lilypad")){
            return new Lilypad();
        }
        else if (type.equalsIgnoreCase("Wall nut")){
            return new Wallnut();
        }
       
        
        return null;
        
    }
}
