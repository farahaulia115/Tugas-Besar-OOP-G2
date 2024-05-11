package main;
import java.util.Scanner;


public class MenuGame {
    Scanner input = new Scanner(System.in);
    public MenuGame() {
        System.out.println("");
        pvz();
        System.out.println("");
        opening();
    }

    public void opening() {
        System.out.println("1. Start");
        System.out.println("2. Help");
        System.out.println("3. Plants List");
        System.out.println("4. Zombies List");
        System.out.println("5. Exit");
        System.out.print("Choose : ");
        int choose = input.nextInt();
        if (choose == 1) {
            // startGame();
        } else if (choose == 2) {
            help();
        } else if (choose == 3) {
            plantsList();
        } else if (choose == 4) {
            zombiesList();
        } 
        else if (choose == 5) {
            System.exit(0);
        } else {
            System.out.println("Invalid input");
            opening();
        }
    }


    public void pvz (){
        System.out.println("### ##   ####       ##     ###  ##  #### ##           ### ###  ### ##            ### ##    ## ##  ##   ##   ### ##    ####    ### ###  ");
        System.out.println("##  ##   ##         ##     ##  ##  # ## ##            ##  ##  ##  ##            ##  ##   ##   ##  ##   ##   ##  ##     ##     ##  ##  ");
        System.out.println("##  ##   ##       ## ##    # ## #    ##               ##  ##     ##                ##    ##   ##  ##   ##   ##  ##     ##     ##     ");
        System.out.println("##  ##   ##       ##  ##   ##  ##    ##               ##  ##    ##                ##     ##   ##  # ### #   ##  ##     ##     ## ##   ");
        System.out.println("## ##    ##       ######   ##  ##    ##               ### ##   ##                ##      ##   ##  ## # ##   ## ##      ##     ##      ");
        System.out.println("##       ##  ##   ##  ##   ##  ##    ##                ###    ##  ##            ##  ##   ##   ##  ##   ##   ##  ##     ##     ##  ##  ");
        System.out.println("####     ### ### ###   ##  ###  ##  ####               ##    # ####            # ####    ## ##   ##   ##   ### ##    ####    ### ###  ");
        System.out.println("By : GROUP 2-K2                                                                                                                        ");
       
    }


    public void help(){

    }

    public void plantsList(){

    }

    public void zombiesList(){

    }


}
