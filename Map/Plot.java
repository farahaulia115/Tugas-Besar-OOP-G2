package Map;

public class Plot {
    //private Plant planted = null;
    private boolean adaTanaman = false;
    
    public void tanam(/*Plant plant*/){
        if (!adaTanaman){
            //planted = plant;
            adaTanaman = true;
        }
    }
    public void gali(/*Plant plant*/){
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

