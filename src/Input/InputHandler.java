package Input;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InputHandler {
    private static Scanner scanner = new Scanner(System.in);

    public static int getIntInput(String prompt) {
        
        int input = 0;
        boolean isValid = false;
        
        while (!isValid) {
            try {
                System.out.print(prompt);
                input = scanner.nextInt();
                isValid = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, please enter a number");
                scanner.next(); // Clear buffer
            }
        }

        return input;
    }

    public static int getIntInput() {
        int input = 0;
        boolean isValid = false;
        
        while (!isValid) {
            try {
                input = scanner.nextInt();
                isValid = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, please enter a number");
                scanner.next(); // Clear buffer
            }
        }

        return input;
    }

    public static String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
}

