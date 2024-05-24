package tubes.maven.Input;

import java.util.Scanner;

public class StringHandler {
    
    private static Scanner scanner = new Scanner(System.in);
    
    public static String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
}
