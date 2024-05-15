
package Main;
public class Sun {
    private static int amount;

    public static int getAmount(){
        return amount;
    }

    // buat exception
    public static synchronized void decreaseSun (int sun){
        amount -= sun;
    }

    public static synchronized void increaseSun (int sun){
        amount += sun;
    }

    public static void setSun (int sun){
        amount = sun;
    }

    // public static void generateSun(Time time){
    //     if (time.getCurrentPhase().equalsIgnoreCase("Pagi") ){
    //         if (time.getTotalSeconds() % 25 == 0){
    //             increaseSun(25);
    //         }
    //     } 
    // }

    // buat generate sun tiap berapa second

}
