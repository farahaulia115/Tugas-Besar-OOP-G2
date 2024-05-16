public class Tes1 {
    public static void methodName(boolean x){
        x = true;
    }


    public static void main(String[] args) {
        boolean y = false;
        methodName(y);
        System.out.println(y);
    }
}
