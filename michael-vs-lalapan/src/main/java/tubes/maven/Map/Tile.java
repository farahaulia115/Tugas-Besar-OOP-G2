package tubes.maven.Map;
import tubes.maven.Plant.*;
import tubes.maven.Zombie.*;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import tubes.maven.Exception.NotPlantableException;
import tubes.maven.Exception.NotShovelableException;

public class Tile {
    private Plant planted;
    private boolean adaTanaman;
    private Queue<Zombie> zombieQueue;

    public Tile(){
        planted = null;
        adaTanaman= false;
        zombieQueue = new ConcurrentLinkedQueue<>();
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

    public Queue<Zombie> getZombieList(){
        return zombieQueue;
    }

    public void plantDie(){
        adaTanaman = false;
        planted = null;
    }
}