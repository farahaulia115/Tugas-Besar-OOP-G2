
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

   

}
