package Main;

/**
 * Opening
 */
public class Opening {
    public void printMvL(){
        String green = "\u001B[32m";  // Kode ANSI untuk warna hijau
        String red = "\u001B[31m";    // Kode ANSI untuk warna merah
        String blue = "\u001B[34m";   // Kode ANSI untuk warna biru
        String reset = "\u001B[0m";   // Kode ANSI untuk mereset warna
        String[] asciiArt = new String[]{

            red + "    ███╗   ███╗██╗ ██████╗██╗  ██╗ █████╗ ███████╗██╗         " + reset,
            red + "    ████╗ ████║██║██╔════╝██║  ██║██╔══██╗██╔════╝██║         " + reset,
            red + "    ██╔████╔██║██║██║     ███████║███████║█████╗  ██║         " + reset,
            red + "    ██║╚██╔╝██║██║██║     ██╔══██║██╔══██║██╔══╝  ██║         " + reset,
            red + "    ██║ ╚═╝ ██║██║╚██████╗██║  ██║██║  ██║███████╗███████╗    " + reset,
            red + "    ╚═╝     ╚═╝╚═╝ ╚═════╝╚═╝  ╚═╝╚═╝  ╚═╝╚══════╝╚══════╝    " + reset,
            blue + "                    ██╗   ██╗███████╗                         " + reset,
            blue + "                    ██║   ██║██╔════╝                         " + reset,
            blue + "                    ██║   ██║███████╗                         " + reset,
            blue + "                    ╚██╗ ██╔╝╚════██║                         " + reset,
            blue + "                     ╚████╔╝ ███████║                         " + reset,
            blue + "                      ╚═══╝  ╚══════╝                         " + reset,
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