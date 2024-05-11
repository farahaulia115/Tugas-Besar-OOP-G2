package Util;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
    private static Input instance = null;
    private Scanner scan;

    private Input() {
        scan = new Scanner(System.in);
    }

    public static Input getInstance() {
        if (instance == null) {
            instance = new Input();
        }

        return instance;
    }

    public int nextInt() {
        return scan.nextInt();
    }

    public String next() {
        return scan.next();
    }

    public String nextLine() {
        try {
            while (System.in.available() > 0) {
                scan.next();
            }
        } catch (IOException e) {
    
        }

        return scan.nextLine();
    }

    public String getInput(String message) throws NoInputException {
        System.out.print(message);

        String input = nextLine();
        if (input.equals("")) {
            throw new NoInputException();
        } else {
            return input;
        }
    }

    
}
