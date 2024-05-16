// Main.java


import Main.DeckThreat;
import Main.Game;
import Main.Opening;
import Main.Sun;
import Map.NotShovelableException;
import Input.InputHandler;

public class Main {
    

    public static void main(String[] args) {
        boolean open = true; // tanda looping ketika game dibuka
        boolean gameInventory = false; // tanda untuk bagian pilih inventory, preparation sebelum game start
         // tanda untuk game berjalan
        Opening opening = new Opening();
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
            int choose = InputHandler.getIntInput("Choose :");
            System.out.println();
            switch (choose) {
                case 1:
                    gameInventory = true;
                    System.out.println("Welcome to Plants vs Zombies");
                    System.out.println("Please select your plants deck");
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
                System.out.println("5. Add Deck");
                System.out.println("6. Delete Deck");
                System.out.println("7. Start Game");
                System.out.println("8. Exit");
                int choose2 = InputHandler.getIntInput("Choose :");
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
                        int x = InputHandler.getIntInput();
                        System.out.print("With deck index : ");
                        int y = InputHandler.getIntInput();
                        try {
                            game.getInventory().swapDeck(x-1, y-1);
                            System.out.println("Swap deck success");
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                        // swap deck
                        break;
                    case 4:
                        System.out.print("Swap inventory index : ");
                        int x2 = InputHandler.getIntInput();
                        System.out.print("With inventory index : ");
                        int y2 = InputHandler.getIntInput();
                        try {
                            game.getInventory().swapInventory(x2-1, y2-1);
                            System.out.println("Swap inventory success");
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                        
                        // swap inventory
                        break;
                    case 5:
                        System.out.print("Add deck index : ");
                        int i = InputHandler.getIntInput();
                        try {
                            game.getInventory().addPlantToDeck(i);
                            System.out.println("Add deck success");
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                        
                        // add deck
                        break;
                    case 6:
                        System.out.print("Delete deck index : ");
                        int index = InputHandler.getIntInput();
                        try {
                            game.getInventory().deletePlantFromDeck(index);
                            System.out.println("Delete deck success");
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                        
                        // delete deck
                        break;
                    case 7:
                        // start game
                        gameInventory = false;
                        game.startGame();
                        Sun.increaseSun(25);
                        break;
                    case 8:
                        gameInventory = false;
                        break;
                    default:
                        System.out.println("Invalid input");
                        break;
                }

                while (Game.getStatusGame()) {
                    Thread deckThreat = new Thread(DeckThreat.getDeckThreatInstance(game.getDeck()));
                    deckThreat.start();
                    game.isGameOver();
                    // System.out.println("Sun : " + Sun.getAmount());
                    // game.getDeck().showDeckStatus();

                    System.out.println();
                    System.out.println("Game Menu");
                    System.out.println("1. Show Map");
                    System.out.println("2. Show Sun");
                    System.out.println("3. Show Deck Status");
                    System.out.println("4. Plant");
                    System.out.println("5. Remove Plant");
                    System.out.println("6. Quit Game");
                    System.out.println("7. Get time");

                    int choose3 = InputHandler.getIntInput("Choose :");
                    System.out.println();

                    switch (choose3) {
                        case 1:
                            game.getMap().renderMap2();
                            // show map
                            break;
                        case 2:
                            System.out.println("Sun : " + Sun.getAmount());
                            // show sun
                            break;
                        case 3:
                            game.getDeck().showDeckStatus();
                            // show deck status
                            break;
                        case 4:
                            System.out.println("Choose plant to plant");
                            game.getDeck().showDeck();
                            int choose4 = InputHandler.getIntInput("Choose :");
                            try {
                                game.getDeck().pilihTanaman(choose4-1);
                                System.out.println("Plant ready");
                                boolean plant = false;
                                int row = InputHandler.getIntInput("Choose row to plant");
                                int column = InputHandler.getIntInput("Choose column to plant");
                                try {
                                    game.getDeck().tanam(choose4-1, row, column, plant);
                                    System.out.println("Plant " + game.getDeck().getDeck().get(choose4-1).getName() + " has been planted");
                                    Sun.decreaseSun(game.getDeck().getDeck().get(choose4-1).getCost());
                                } catch (IllegalArgumentException e) {
                                    System.out.println(e.getMessage());
                                } catch (IllegalStateException e) {
                                    System.out.println(e.getMessage());
                                }
                            } catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                            }
                            
                            
                            break;
                        case 5:
                            int row2 = InputHandler.getIntInput("Choose row to remove plant");
                            int column2 = InputHandler.getIntInput("Choose column to remove plant");
                            try{
                                game.getDeck().gali(row2, column2);
                            } catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                            }
                            catch (NotShovelableException e) {
                                System.out.println(e.getMessage());
                            }
                            // remove plant
                            break;
                        case 6:
                            Game.setStatusGame(false);
                            break;
                        case 7:
                            System.out.println("Time : " + game.getTime());
                            break;
                        default:
                            System.out.println("Invalid input");
                            break;
                        
                    }
                    // game.getMap().renderMap2();

                    
                }
            }
        }
    }
}


    




   

