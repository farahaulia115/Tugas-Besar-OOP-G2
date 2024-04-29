package Map;

public class Water extends Plot {
    boolean placeholder = true;
    boolean adalilipad = false;

    @Override
    public void tanam(/*Plant plant*/){
        
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
    

}
