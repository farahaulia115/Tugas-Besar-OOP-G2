package Map;
import Plant.*;
public class RestrictedPlot extends Tile{

    public void tanam(Plant plant) throws NotPlantableException{
        throw new NotPlantableException();
    }
    public void gali() throws NotShovelableException{
        throw new NotShovelableException();
    }
}
