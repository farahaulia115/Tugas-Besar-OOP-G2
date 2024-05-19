package tubes.maven;

import tubes.maven.Player.DeckThreat;
import tubes.maven.Player.Game;
import tubes.maven.Player.Opening;
import tubes.maven.Player.SpawnZombie;
import tubes.maven.Player.Sun;
import tubes.maven.Map.Map;
import tubes.maven.Plant.Lilypad;
import tubes.maven.Plant.Tallnut;
import tubes.maven.Thread.Row1EntityThread;
import tubes.maven.Thread.Row2EntityThread;
import tubes.maven.Thread.Row3EntityThread;
import tubes.maven.Thread.Row4EntityThread;
import tubes.maven.Thread.Row5EntityThread;
import tubes.maven.Thread.Row6EntityThread;
import tubes.maven.Exception.NotPlantableException;
import tubes.maven.Exception.NotShovelableException;
import tubes.maven.Input.InputHandler;

public class App {
    public static void main(String[] args) throws InterruptedException, NotShovelableException, NotPlantableException {
        String red = "\u001B[31m";       // Kode ANSI untuk warna merah
        String reset = "\u001B[0m";     // Kode ANSI untuk mereset warna
        String brown = "\u001B[33m";    // Kode ANSI untuk warna coklat
        String cyan = "\u001B[36m";     // Kode ANSI untuk warna cyan
        boolean open = true; // tanda looping ketika game dibuka
        boolean gameInventory = false; // tanda untuk bagian pilih inventory, preparation sebelum game start
        Opening opening = new Opening();
        final Game game = new Game();
        opening.printMvL();
        
        while (open){
            System.out.println();
            System.out.println(brown + "===============================================================================================================================================" + reset);
            System.out.println(red + "MAIN MENU" + reset);
            System.out.println("1. Start");
            System.out.println("2. Help");
            System.out.println("3. Plants List");
            System.out.println("4. Zombies List");
            System.out.println("5. Exit");
            System.out.println(brown + "===============================================================================================================================================" + reset);
            int choose = InputHandler.getIntInput("Choose :");
            System.out.println();
            switch (choose) {
                case 1:
                    gameInventory = true;
                    System.out.println("Welcome to Michael vs Lalapan");
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
                System.out.println(brown + "===============================================================================================================================================" + reset);
                System.out.println(red + "INVENTORY MENU" + reset);
                System.out.println("1. Show Deck");
                System.out.println("2. Show Inventory");
                System.out.println("3. Swap Deck");
                System.out.println("4. Swap Inventory");
                System.out.println("5. Add Deck");
                System.out.println("6. Delete Deck");
                System.out.println("7. Start Game");
                System.out.println("8. Exit");
                System.out.println(brown + "===============================================================================================================================================" + reset);
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
                        game.getInventory().showInventory();
                        System.out.println();
                        System.out.print("Add deck index : ");
                        int i = InputHandler.getIntInput();
                        try {
                            game.getInventory().addPlantToDeck(i);
                            System.out.println("Add deck success");
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        
                        // add deck
                        break;
                    case 6:
                        System.out.print("Delete deck index : ");
                        int index = InputHandler.getIntInput();
                        try {
                            game.getInventory().deletePlantFromDeck(index-1);
                            System.out.println("Delete deck success");
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        
                        // delete deck
                        break;
                    case 7:
                        // start game
                        try {
                            game.startGame();
                            gameInventory = false;
                            Sun.increaseSun(50);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }

                        break;
                    case 8:
                        gameInventory = false;
                        Game.resetGame();
                        break;
                    default:
                        System.out.println("Invalid input");
                        break;
                }
                // Set the source level to 1.8 or above
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            while (Game.getStatusGame()) {
                            final Game finalGame = game;
                            Thread deckThreat = new Thread(DeckThreat.getDeckThreatInstance(finalGame.getDeck()));
                            deckThreat.start();
                            Thread timeThread = new Thread(finalGame.getTime());
                            timeThread.start();

                            Thread spawnerThread = new Thread(new SpawnZombie());
                            Thread entityThread1 = new Thread(new Row1EntityThread());
                            Thread entityThread2 = new Thread(new Row2EntityThread());
                            Thread entityThread3 = new Thread(new Row3EntityThread());
                            Thread entityThread4 = new Thread(new Row4EntityThread());
                            Thread entityThread5 = new Thread(new Row5EntityThread());
                            Thread entityThread6 = new Thread(new Row6EntityThread());
                            Thread.sleep(1000);
                            spawnerThread.start();
                            spawnerThread.join();
                            entityThread1.start();
                            entityThread2.start();
                            entityThread3.start();
                            entityThread4.start();
                            entityThread5.start();
                            entityThread6.start();
    
                            entityThread1.join();
                            entityThread2.join();
                            entityThread3.join();
                            entityThread4.join();
                            entityThread5.join();
                            entityThread6.join(); 
                            }
                        } catch (InterruptedException e) {
                            System.out.println("Game Loop Interrupted");
                        }
                    }
                });
                    
                thread.start();
                while (Game.getStatusGame()) {
             
                    System.out.println("Sun : " + Sun.getAmount());
                    game.getDeck().showDeckStatus();

                    System.out.println();
                    System.out.println(brown + "===============================================================================================================================================" + reset);
                    System.out.println(red + "GAME MENU" + reset);
                    System.out.println("1. Show Time");
                    System.out.println("2. Show Deck Status");
                    System.out.println("3. Plant");
                    System.out.println("4. Remove Plant");
                    System.out.println("5. Quit Game");
                    System.out.println(brown + "===============================================================================================================================================" + reset);

                    int choose3 = InputHandler.getIntInput("Choose :");
                    System.out.println();

                    switch (choose3) {
                        case 1:
                            if (Game.getStatusGame() == false) {
                                break;
                            }
                            System.out.println("Day : " + game.getTime().getDay());
                            System.out.println("Time : " + game.getTotalSecondsTime ());
                            System.out.println("Phase : " + game.getTime().getCurrentPhase());
                            break;
                        case 2:
                            if (Game.getStatusGame() == false) {
                                break;
                            }
                            game.getDeck().showDeckStatus();
                            // show deck status
                            break;
                        case 3:
                            if (Game.getStatusGame() == false) {
                                break;
                            }
                            
                            game.getDeck().showDeck();
                            
                            int [] choose4 = InputHandler.getThreeIntInput("Choose plant to plant, row, and column to plant :");
                            try {
                                if (Game.getStatusGame() == false) {
                                    break;
                                }
                                game.getDeck().pilihTanaman(choose4[0]-1);
                                System.out.println("Plant ready");
                                try {
                                    game.getDeck().tanam(choose4[0]-1, choose4[1]-1, choose4[2]-1);
                                    System.out.println("Plant " + game.getDeck().getDeck().get(choose4[0]-1).getName() + " has been planted");
                                    Sun.decreaseSun(game.getDeck().getDeck().get(choose4[0]-1).getCost());
                                } catch (IllegalArgumentException e) {
                                    System.out.println(e.getMessage()); 
                                } catch (IllegalStateException e) {
                                    System.out.println(e.getMessage());
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                            } catch (Exception  e) {
                                System.out.println(e.getMessage());
                            }
                            
                            break;
                        case 4:
                            if (Game.getStatusGame() == false) {
                                break;
                            }
                            int[] choose5 = InputHandler.getTwoIntInput("Choose row and column to remove plant :");
                            try{
                                if (Game.getStatusGame() == false) {
                                    break;
                                }
                                game.getDeck().gali(choose5[0]-1, choose5[1]-1);
                            } catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                            }
                            catch (NotShovelableException e) {
                                System.out.println(e.getMessage());
                            }
                            
                            
                            // remove plant
                            break;
                        case 5:
                        
                            if (Game.getStatusGame() == false) {
                                break;
                            }
                            Game.setStatusGame(false);
                            Game.resetGame();   
                            break;
                        case 555555:
                            if (Game.getStatusGame() == false) {
                                break;
                            }
                            Sun.increaseSun(10000);
                            break;
                        case 111111:
                            if (Game.getStatusGame() == false) {
                                break;
                            }
                            for (int i = 0; i < 6; i++) {
                                try {
                                if (i == 2 || i == 3) {
                                    game.getMap().tanamAt(i, 5, new Lilypad());
                                    game.getMap().tanamAt(i, 5, new Tallnut());
                                } else {
                                    game.getMap().tanamAt(i, 5, new Tallnut());
                                }
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                            }
                        
                            break;
                        case 131313:
                            if (Game.getStatusGame() == false) {
                                break;
                            }
                            Map.getMapInstance().resetZombieInMap();
                            for (int i = 0; i < 6; i++) {
                                for (int j = 0; j < 10; j++) {
                                    Map.getMapInstance().getMapDetail()[i][j].getZombieList().clear();
                                }
                            }
                            break;
                        default:
                            if (Game.getStatusGame() == false) {
                                break;
                            }
                            System.out.println("Invalid input");
                            break;
                    }
                    if (Game.getStatusGame() == false) {
                        break;
                    }
                    System.out.println(cyan + "===============================================================================================================================================" + reset);
                    game.getMap().renderMap3();
                    System.out.println(cyan + "===============================================================================================================================================" + reset);

                    
                }
            }
        }
    }
}


    




   
