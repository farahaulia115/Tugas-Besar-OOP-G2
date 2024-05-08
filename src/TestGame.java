package Player;

public class TestGame {
    public static void main(String[] args) {
        Game game = new Game();
        try {
            game.gameLoop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
