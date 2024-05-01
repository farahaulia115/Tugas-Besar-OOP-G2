package Map;

public class Plot {
    //private Plant planted = null;
    private boolean adaTanaman = false;

    public Plot(){
        //Plant planted = null;
    }
    
    public void tanam(/*Plant plant*/) throws NotPlantableException{
        if (!adaTanaman){
            //planted = plant;
            adaTanaman = true;
        }
    }
    public void gali(/*Plant plant*/) {
        if (adaTanaman){
            //planted = null;
            adaTanaman = false;
        }

    }
    public boolean isAdaTanaman(){
        return adaTanaman;
    }

    /*
    
    */
}

//method zombie & plant: takedamage;

