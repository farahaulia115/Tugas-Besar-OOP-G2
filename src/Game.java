package Player;

import java.util.Random;

public class Game {
    private int[][] map = new int[6][11];
    private Random random = new Random();

    public void spawnZombies() {
        for (int i = 0; i < 6; i++) {
            if (random.nextDouble() < 0.3) {
                map[i][10] = 1;
            }
        }
    }

    public void moveZombies() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 10; j++) {
                map[i][j] = map[i][j + 1];
            }
            map[i][10] = 0;
        }
    }

    public boolean isZombieAtEnd() {
        for (int i = 0; i < 6; i++) {
            if (map[i][0] == 1) {
                return true;
            }
        }
        return false;
    }

    public void printMap() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 11; j++) {
                if (map[i][j] == 1) {
                    System.out.print("[ z] ");
                } else {
                    System.out.print("[  ] ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public void gameLoop() throws InterruptedException {
        while (true) {
            spawnZombies();
            printMap();
            Thread.sleep(1000);
            moveZombies();
            printMap();
            Thread.sleep(5000);
            if (isZombieAtEnd()) {
                System.out.println("Game Over: A zombie reached the end.");
                break;
            }
        }
    }
}