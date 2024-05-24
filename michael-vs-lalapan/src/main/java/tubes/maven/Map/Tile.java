package tubes.maven.Map;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import tubes.maven.Exception.NotPlantableException;
import tubes.maven.Exception.NotShovelableException;
import tubes.maven.Plant.Plant;
import tubes.maven.Zombie.Zombie;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "type"
)
@JsonSubTypes({
    @JsonSubTypes.Type(value = Water.class, name = "Water"),
    @JsonSubTypes.Type(value = Land.class, name = "Land"),
    @JsonSubTypes.Type(value = RestrictedPlot.class, name = "RestrictedPlot")
    // Add other subclasses here
})
public class Tile {
    private Plant plant;
    private boolean adaTanaman;
    private Queue<Zombie> zombieQueue;

    public Tile(){
        plant = null;
        adaTanaman= false;
        zombieQueue = new ConcurrentLinkedQueue<>();
    }
    public Tile(Plant plant, boolean adaTanaman, Queue<Zombie> zombieQueue){
        this.plant = plant;
        this.adaTanaman = adaTanaman;
        this.zombieQueue = zombieQueue;
        
    }
    public void setZombieQueue(Queue<Zombie> zombieQueue){
        this.zombieQueue = zombieQueue;
    }
    public void setPlanted(Plant plant){
        this.plant = plant;
    }
    public void setAdaTanaman(boolean adaTanaman){
        this.adaTanaman = adaTanaman;
    }
    
    public void tanam(Plant plant) throws NotPlantableException{
        if (!adaTanaman){
            this.plant = plant;
            adaTanaman = true;
        }
        else{
            throw new NotPlantableException();
        }
    }
    public void gali() throws NotShovelableException {
        if (adaTanaman){
            plant = null;
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
        return plant;
    }

    public Queue<Zombie> getZombieList(){
        return zombieQueue;
    }

    public void plantDie(){
        adaTanaman = false;
        plant = null;
    }
}
