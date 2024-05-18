import java.util.Scanner;

public class Tes {
    private static volatile boolean gameRunning = true;

    public static void main(String[] args) {
        Thread inputThread = new Thread(() -> {
            Scanner scanner = new Scanner(System.in);
            while (gameRunning) {
                try {
                    System.out.print("Enter your input: ");
                    if (scanner.hasNextLine()) {
                        String input = scanner.nextLine();
                        System.out.println("You entered: " + input);
                    }
                } catch (Exception e) {
                    System.out.println("Input interrupted.");
                    break;
                }
            }
            scanner.close();
        });

        Thread gameThread = new Thread(() -> {
            try {
                // Simulate game running for 10 seconds
                for (int i = 10; i > 0; i--) {
                    if (!gameRunning) break;
                    System.out.println("Game running... " + i);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                gameRunning = false;
                inputThread.interrupt();
                System.out.println("Game over.");
            }
        });

        inputThread.start();
        gameThread.start();
    }
}
