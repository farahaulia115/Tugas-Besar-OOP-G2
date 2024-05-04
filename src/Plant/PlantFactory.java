
package Plant;

public class PlantFactory {

    public Plant createPlant(String type){
        if (type.equalsIgnoreCase("SunFlower")){
            return new SunFlower();
        } 
        else if (type.equalsIgnoreCase("TwinSunFlower")){
            return new TwinSunFlower();
        } 
        return null;
        
    }
}
