
package Main;

import Map.*;
import Plant.*;
import Time.*;
import Util.*;
import Exception.*;
import Zombie.*;


public class Game {
    private static boolean statusGame = true;
    private Map map;
    private Inventory inventory;
    private Time time;

    public Game (){
        time = new Time();
        TimeThread timeThread = new TimeThread(time);
        timeThread.start();
    }

    public Time getTime(){
        return time;
    }

    
    public static boolean getStatusGame(){
        return statusGame;
    }

    public void startGame(){

    }
    
}
