package Map;
import Plant.*;
import Zombie.*;
import java.util.List;
import java.util.ArrayList;

public class Tile {
    private Plant planted;
    private boolean adaTanaman;
    private List<Zombie> zombieList;

    public Tile(){
        planted = null;
        adaTanaman= false;
        zombieList = new ArrayList<>();
    }
    
    public void tanam(Plant plant) throws NotPlantableException{
        if (!adaTanaman){
            planted = plant;
            adaTanaman = true;
        }
        else{
            throw new NotPlantableException();
        }
    }
    public void gali() throws NotShovelableException {
        if (adaTanaman){
            planted = null;
            adaTanaman = false;
        }
        else{
            throw new NotShovelableException();
        }

    }
    public boolean isAdaTanaman(){
        return adaTanaman;
    }

    public Plant getPlant(){
        return planted;
    }

    public List<Zombie> getZombieList(){
        return zombieList;
    }

    public void plantDie(){
        adaTanaman = false;
        planted = null;
    }
}
