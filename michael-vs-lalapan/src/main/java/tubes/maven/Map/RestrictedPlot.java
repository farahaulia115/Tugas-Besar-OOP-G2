package tubes.maven.Map;
import tubes.maven.Exception.NotPlantableException;
import tubes.maven.Exception.NotShovelableException;
import tubes.maven.Plant.*;
import com.fasterxml.jackson.annotation.JsonTypeName;
@JsonTypeName("RestrictedPlot")
public class RestrictedPlot extends Tile{

    public void tanam(Plant plant) throws NotPlantableException{
        throw new NotPlantableException();
    }
    public void gali() throws NotShovelableException{
        throw new NotShovelableException();
    }
}
