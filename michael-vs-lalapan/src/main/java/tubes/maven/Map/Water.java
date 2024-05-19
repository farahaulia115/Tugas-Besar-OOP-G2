package tubes.maven.Map;
import tubes.maven.Exception.NotPlantableException;
import tubes.maven.Exception.NotShovelableException;
import tubes.maven.Plant.*;

public class Water extends Tile {
    private boolean diTanamLilypad = false;
    public Water(){
        super();
    }
    
    @Override
    public void tanam(Plant plant) throws NotPlantableException{
        if (plant instanceof Lilypad && !diTanamLilypad ){
            super.tanam((Lilypad) plant);
            diTanamLilypad = true;
        }
        else if (plant instanceof TangleKelp){
            super.tanam(plant);
        }
        else if (!(plant instanceof Lilypad) && !(plant instanceof TangleKelp) && diTanamLilypad){
            try {
                super.gali();
            } catch (Exception e) {
            }
            plant.setHealth(plant.getHealth()+100);
            super.tanam(plant);
        }
        else{
            throw new NotPlantableException();
        }
    } 

    @Override
    public void gali() throws NotShovelableException{
        if (isAdaTanaman() && getPlant() instanceof TangleKelp){
            super.gali();
        }
        else if (isAdaTanaman() && (getPlant() instanceof Lilypad)){
            super.gali();
            diTanamLilypad = false;
        }
        else if (isAdaTanaman() && diTanamLilypad && !(getPlant() instanceof Lilypad) && !(getPlant() instanceof TangleKelp)){
            int healthremain = super.getPlant().getHealth();
            super.gali();
            try {
                if (healthremain<100){
                    Lilypad lili = new Lilypad();
                    lili.setHealth(healthremain);
                    diTanamLilypad = false;
                    tanam(lili);
                }
                else {
                    diTanamLilypad = false;
                    tanam(new Lilypad());
                }
            } catch (Exception e) {
            }
        }
        else{
            throw new NotShovelableException();
        }
    }

    public boolean isDitanamLilypad(){
        return diTanamLilypad;
    }

    public void setDitanamLilypad(boolean b){
        diTanamLilypad = b;
    }

}
