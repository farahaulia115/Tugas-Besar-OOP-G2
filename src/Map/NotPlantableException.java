package Map;

public class NotPlantableException extends Exception {
    public NotPlantableException(){
        super("Tidak bisa menanam tanaman disini");
    }
}
