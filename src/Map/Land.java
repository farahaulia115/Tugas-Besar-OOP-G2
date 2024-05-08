package Map;
import Plant.*;
public class Land extends Tile {
    @Override
    public void tanam(Plant plant) throws NotPlantableException{
        
        if (plant instanceof Lilypad|| plant instanceof TangleKelp){
            throw new NotPlantableException();
        } 
        else{
            super.tanam(plant);
        }
    }    

}
