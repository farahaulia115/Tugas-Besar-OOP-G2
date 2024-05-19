package tubes.maven.Exception;

public class NotPlantableException extends Exception {
    public NotPlantableException(){
        super("Cannot plant on this tile");
    }
}
