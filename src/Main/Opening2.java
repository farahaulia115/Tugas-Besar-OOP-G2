package Main;

/**
 * Opening
 */
public class Opening2 {
    public void printMvL(){
        String green = "\u001B[32m";  // Kode ANSI untuk warna hijau
        String red = "\u001B[31m";    // Kode ANSI untuk warna merah
        String reset = "\u001B[0m";   // Kode ANSI untuk mereset warna
        String[] asciiArt = new String[]{

            green + "    ███╗   ███╗██╗ ██████╗██╗  ██╗ █████╗ ███████╗██╗         " + reset,
            green + "    ████╗ ████║██║██╔════╝██║  ██║██╔══██╗██╔════╝██║         " + reset,
            green + "    ██╔████╔██║██║██║     ███████║███████║█████╗  ██║         " + reset,
            green + "    ██║╚██╔╝██║██║██║     ██╔══██║██╔══██║██╔══╝  ██║         " + reset,
            green + "    ██║ ╚═╝ ██║██║╚██████╗██║  ██║██║  ██║███████╗███████╗    " + reset,
            green + "    ╚═╝     ╚═╝╚═╝ ╚═════╝╚═╝  ╚═╝╚═╝  ╚═╝╚══════╝╚══════╝    " + reset,
            red + "                    ██╗   ██╗███████╗                         " + reset,
            red + "                    ██║   ██║██╔════╝                         " + reset,
            red + "                    ██║   ██║███████╗                         " + reset,
            red + "                    ╚██╗ ██╔╝╚════██║                         " + reset,
            red + "                     ╚████╔╝ ███████║                         " + reset,
            red + "                      ╚═══╝  ╚══════╝                         " + reset,
            green + "██╗      █████╗ ██╗      █████╗ ██████╗  █████╗ ███╗   ██╗    " + reset,
            green + "██║     ██╔══██╗██║     ██╔══██╗██╔══██╗██╔══██╗████╗  ██║    " + reset,
            green + "██║     ███████║██║     ███████║██████╔╝███████║██╔██╗ ██║    " + reset,
            green + "██║     ██╔══██║██║     ██╔══██║██╔═══╝ ██╔══██║██║╚██╗██║    " + reset,
            green + "███████╗██║  ██║███████╗██║  ██║██║     ██║  ██║██║ ╚████║    " + reset,
            green + "╚══════╝╚═╝  ╚═╝╚══════╝╚═╝  ╚═╝╚═╝     ╚═╝  ╚═╝╚═╝  ╚═══╝    " + reset
        };

        for (String line : asciiArt) {
            System.out.println(line);
        }
    }
        
    public void help(){
        System.out.println("Help");
    }

    public void plantsList(){
        System.out.println("Plants List");
    }

    public void zombiesList(){
        System.out.println("Zombies List");
    }
    public void informasiCombieConeHead(){}
    // lanjutin informasi lainnya
    public void informasiSunFlower(){}
    // lanjutin informasi lainnya

}