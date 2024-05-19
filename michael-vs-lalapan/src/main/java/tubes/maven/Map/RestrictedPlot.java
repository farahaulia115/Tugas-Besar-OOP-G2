package tubes.maven.Map;
import tubes.maven.Exception.NotPlantableException;
import tubes.maven.Exception.NotShovelableException;
import tubes.maven.Plant.*;
public class RestrictedPlot extends Tile{

    public void tanam(Plant plant) throws NotPlantableException{
        throw new NotPlantableException();
    }
    public void gali() throws NotShovelableException{
        throw new NotShovelableException();
    }
}
