package Main;

public class Sun {
    private static int amount;

    public static int getAmount(){
        return amount;
    }

    // buat exception
    public static void decreaseSun (int sun){
        amount -= sun;
    }

    public static void increaseeSun (int sun){
        amount += sun;
    }

    public static void setSun (int sun){
        amount = sun;
    }

    // buat generate sun tiap berapa second

}
