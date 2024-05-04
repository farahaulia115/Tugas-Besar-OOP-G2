package Map;

public class Water extends Plot {
    boolean placeholder = true;
    boolean adalilipad = false;
    //Lilipad lilipad = null;

    public Water(){
        super();
        //lilipad = null;
    }
    @Override
    public void tanam(/*Plant plant*/)throws NotPlantableException{
        
        if (adalilipad /*&& plant.isaquatic == false */){
            super.tanam();
        }
        else if (/*plant instanceof lilipad && adalilipad == false*/ placeholder){
            adalilipad = true;
        }
        else{

        }
    } 

    @Override
    public void gali(){
        if (isAdaTanaman()){
            super.gali();
        }
        if (!isAdaTanaman() && adalilipad){
            adalilipad = false;
        }
        else{

        }
    }

    public boolean isAdaLilipad(){
        return adalilipad;
    }
    

}
