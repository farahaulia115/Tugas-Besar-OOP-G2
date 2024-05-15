// Main.java
import java.util.Scanner;

import  main.Opening;

public class Main {
    

    public static void main(String[] args) {
        boolean open = true; // tanda looping ketika game dibuka
        boolean gameInventory = false; // tanda untuk bagian pilih inventory, preparation sebelum game start
        boolean game = false; // tanda untuk game berjalan
        Opening opening = new Opening();
        Scanner input = new Scanner(System.in);
        while (open){
            System.out.println("1. Start");
            System.out.println("2. Help");
            System.out.println("3. Plants List");
            System.out.println("4. Zombies List");
            System.out.println("5. Exit");
            System.out.print("Choose : ");
            int choose = input.nextInt();
            switch (choose) {
                case 1:
                    gameInventory = true;
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
                System.out.println("1. Show Deck");
                System.out.println("2. Show Inventory");
                System.out.println("3. Swap Deck");
                System.out.println("4. Swap Inventory");
                System.out.println("5. Delete Deck");
                System.out.println("6. Start Game");
                System.out.println("7. Exit");
                System.out.print("Choose : ");
                int choose2 = input.nextInt();
                switch (choose2) {
                    case 1:
                        // show deck
                        break;
                    case 2:
                        // show inventory
                        break;
                    case 3:
                        // swap deck
                        break;
                    case 4:
                        // swap inventory
                        break;
                    case 5:
                        // delete deck
                        break;
                    case 6:
                        // start game
                        gameInventory = false;
                        game = true;
                        break;
                    case 7:
                        gameInventory = false;
                        break;
                    default:
                        System.out.println("Invalid input");
                        break;
                }

                while (game) {
                    
                }
            }


        }
    }



       


}


    




   

