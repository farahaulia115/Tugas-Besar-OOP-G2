package Map;
import Plant.*;

public class Water extends Tile {
    private Lilypad lilypadInPool;

    public Water(){
        super();
        lilypadInPool = null;
    }
    
    @Override
    public void tanam(Plant plant) throws NotPlantableException{
        if (plant instanceof Lilypad && lilypadInPool == null ){
            lilypadInPool = (Lilypad) plant;
        }
        else if (plant instanceof TangleKelp && lilypadInPool == null){
            super.tanam(plant);
        }
        else if ( lilypadInPool != null && !(plant instanceof Lilypad) && !(plant instanceof TangleKelp)){
            super.tanam(plant);
        }
        else{
            throw new NotPlantableException();
        }
    } 

    @Override
    public void gali() throws NotShovelableException{
        if (isAdaTanaman()){
            super.gali();
        }
        else if (!isAdaTanaman() && lilypadInPool != null){
            lilypadInPool = null;
        }
        else{
            throw new NotShovelableException();
        }
    }

    public Lilypad getLilypad(){
        return lilypadInPool;
    }

}
