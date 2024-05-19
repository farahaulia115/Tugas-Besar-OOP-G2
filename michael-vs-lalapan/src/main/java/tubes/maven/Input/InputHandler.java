package tubes.maven.Input;
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

    public static int[] getThreeIntInput(String prompt) {
        System.out.print(prompt);
        int[] numbers = new int[3];
        while (true) {
            String input = scanner.nextLine();
            String[] tokens = input.split(" ");
            if (tokens.length == 3) {
                try {
                    for (int i = 0; i < 3; i++) {
                        numbers[i] = Integer.parseInt(tokens[i]);
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter three integers separated by spaces.");
                }
            } else {
                System.out.println("Invalid input. Please enter three integers separated by spaces.");
            }
        }
        return numbers;
    }

    public static int[] getTwoIntInput(String prompt) {
        System.out.print(prompt);
        int[] numbers = new int[2];
        while (true) {
            String input = scanner.nextLine();
            String[] tokens = input.split(" ");
            if (tokens.length == 2) {
                try {
                    for (int i = 0; i < 2; i++) {
                        numbers[i] = Integer.parseInt(tokens[i]);
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter two integers separated by spaces.");
                }
            } else {
                System.out.println("Invalid input. Please enter two integers separated by spaces.");
            }
        }
        return numbers;
    }
}

