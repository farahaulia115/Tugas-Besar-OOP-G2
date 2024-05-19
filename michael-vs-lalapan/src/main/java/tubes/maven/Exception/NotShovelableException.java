package Exception;

public class NotShovelableException extends Exception {
    public NotShovelableException(){
        super("Cannot shovel this tile");

    }
}
