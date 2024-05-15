// Main.java
import java.util.Scanner;

import Main.Game;
import Main.Opening;
import Main.Sun;
import Thread.Time;

public class Main {
    

    public static void main(String[] args) {
        boolean open = true; // tanda looping ketika game dibuka
        boolean gameInventory = false; // tanda untuk bagian pilih inventory, preparation sebelum game start
        boolean running = false; // tanda untuk game berjalan
        Opening opening = new Opening();
        Scanner input = new Scanner(System.in);
        Game game = new Game();

        opening.pvz();
        while (open){
            System.out.println();
            System.out.println("Main Menu");
            System.out.println("1. Start");
            System.out.println("2. Help");
            System.out.println("3. Plants List");
            System.out.println("4. Zombies List");
            System.out.println("5. Exit");
            System.out.print("Choose : ");
            int choose = input.nextInt();
            System.out.println();
            switch (choose) {
                case 1:
                    gameInventory = true;
                    System.out.println("Selamat datang di Plants vs Zombies!");
                    System.out.println("Silahkan pilih inventory dan deck yang akan digunakan");
                    break;
                case 2:
                    opening.help();
                    break;
                case 3:
                    opening.plantsList();
                    break;
                case 4:
                    opening.zombiesList();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
            



            while (gameInventory){
                System.out.println();
                System.out.println("Inventory Menu");
                System.out.println("1. Show Deck");
                System.out.println("2. Show Inventory");
                System.out.println("3. Swap Deck");
                System.out.println("4. Swap Inventory");
                System.out.println("5. Delete Deck");
                System.out.println("6. Start Game");
                System.out.println("7. Exit");
                System.out.print("Choose : ");
                int choose2 = input.nextInt();
                System.out.println();
                switch (choose2) {
                    case 1:
                        game.getDeck().showDeck();
                        // show deck
                        break;
                    case 2:
                        game.getInventory().showInventory();
                        // show inventory
                        break;
                    case 3:
                        System.out.print("Swap deck index : ");
                        int x = input.nextInt();
                        System.out.print("With deck index : ");
                        int y = input.nextInt();
                        try {
                            game.getInventory().swapDeck(x, y);
                            System.out.println("Swap deck success");
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                        // swap deck
                        break;
                    case 4:
                        System.out.print("Swap inventory index : ");
                        int x2 = input.nextInt();
                        System.out.print("With inventory index : ");
                        int y2 = input.nextInt();
                        try {
                            game.getInventory().swapInventory(x2, y2);
                            System.out.println("Swap inventory success");
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                        
                        // swap inventory
                        break;
                    case 5:
                        System.out.print("Delete deck index : ");
                        int index = input.nextInt();
                        try {
                            game.getInventory().deletePlantFromDeck(index);
                            System.out.println("Delete deck success");
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                        
                        // delete deck
                        break;
                    case 6:
                        // start game
                        gameInventory = false;
                        running = true;
                        game.startGame();
                        break;
                    case 7:
                        gameInventory = false;
                        break;
                    default:
                        System.out.println("Invalid input");
                        break;
                }

                while (running) {
                    game.isGameOver();
                    System.out.println("Sun : " + Sun.getAmount());
                    game.getDeck().showDeckStatus();

                    System.out.println();
                    System.out.println("Game Menu");
                    System.out.println("1. Show Map");
                    System.out.println("2. Show Sun");
                    System.out.println("3. Show Deck Status");
                    System.out.println("4. Plant");
                    System.out.println("5. Remove Plant");
                    System.out.println("6. Quit Game");

                    
                }


            }
        }
    }



       


}


    




   

