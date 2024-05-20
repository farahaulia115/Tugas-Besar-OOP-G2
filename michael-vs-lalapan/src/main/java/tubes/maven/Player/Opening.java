package tubes.maven.Player;
import tubes.maven.Zombie.*;
import tubes.maven.Plant.*;
/**
 * Opening
 */
public class Opening {
    public void printMvL() {
        String green = "\u001B[32m";  // Kode ANSI untuk warna hijau
        String red = "\u001B[31m";    // Kode ANSI untuk warna merah
        String blue = "\u001B[34m";   // Kode ANSI untuk warna biru
        String reset = "\u001B[0m";   // Kode ANSI untuk mereset warna
        String[] asciiArt = new String[] {
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
    
        int consoleWidth = 143;  // Assume the console width is 143 characters
        for (String line : asciiArt) {
            int paddingSize = (consoleWidth - line.length()) / 2;
            String padding = " ".repeat(paddingSize);
            System.out.println(padding + line);
        }
    }    
        
    public void help() {
        String border = "===============================================================================================================================================";
        String padding = " ";
        String[] lines = {
            "WELCOME TO PLANT VS ZOMBIES",
            "",
            "This game is a strategy-based game where you need to defend your garden from waves of zombies using different types of plants.",
            "",
            "Main Menu:",
            "1. Start: Begin a new game.",
            "2. Help: Display this help information.",
            "3. List Zombies: See the different types of zombies.",
            "4. List Plants: See the different types of plants.",
            "",
            "----------------------------------------------------------------------------------------------------------------------------------------------",
            "STARTING THE GAME",
            "1. Choose at least 6 plants for your deck.",
            "2. Use Sun, the in-game currency, to plant your chosen plants.",
            "3. Each plant has different attributes such as health, cost, and cooldown.",
            "4. Defend your garden from different types of zombies.",
            "",
            "----------------------------------------------------------------------------------------------------------------------------------------------",
            "GAMEPLAY TIPS",
            "1. Always keep an eye on your Sun points and spend wisely.",
            "2. Place your SunFlowers at the back to keep them safe.",
            "3. Use Peashooters and Repeaters to create a strong defense line.",
            "4. Utilize plants with special abilities, like SnowPea and Squash, to handle tougher zombies.",
            "5. Remember to use plants' cooldown wisely and manage your deck efficiently.",
            "",
            "----------------------------------------------------------------------------------------------------------------------------------------------",
            "Good luck and have fun defending your garden!"
        };
        
        System.out.println(border);
        for (String line : lines) {
            int paddingLength = (border.length() - line.length()) / 2;
            StringBuilder paddedLine = new StringBuilder();
            
            paddedLine.append("*");
            for (int i = 0; i < paddingLength - 1; i++) {
                paddedLine.append(padding);
            }
            paddedLine.append(line);
            for (int i = 0; i < paddingLength - 1; i++) {
                paddedLine.append(padding);
            }
            while (paddedLine.length() < border.length() - 1) {
                paddedLine.append(padding);
            }
            paddedLine.append("*");
            
            System.out.println(paddedLine.toString());
        }
        System.out.println(border);
    }

    public void plantsList() {
        String green = "\u001B[32m";  // ANSI code for green
        String yellow = "\u001B[33m"; // ANSI code for yellow
        String reset = "\u001B[0m";   // ANSI code to reset color
    
        String titlePlants = "=== List of All Plants ===";
        int paddingSizePlants = (143 - titlePlants.length()) / 2;
        String paddingPlants = " ".repeat(paddingSizePlants);
    
        System.out.println(yellow + "=".repeat(143) + reset);
        System.out.println(yellow + paddingPlants + titlePlants + paddingPlants + reset);
        System.out.println(yellow + "=".repeat(143) + reset);
        System.out.println();
        informasiSunFlower();
        System.out.println(green + "-".repeat(143) + reset);
        informasiTwinSunFlower();
        System.out.println(green + "-".repeat(143) + reset);
        informasiTangleKelp();
        System.out.println(green + "-".repeat(143) + reset);
        informasiPeashooter();
        System.out.println(green + "-".repeat(143) + reset);
        informasiRepeater();
        System.out.println(green + "-".repeat(143) + reset);
        informasiSnowPea();
        System.out.println(green + "-".repeat(143) + reset);
        informasiSquash();
        System.out.println(green + "-".repeat(143) + reset);
        informasiTallnut();
        System.out.println(green + "-".repeat(143) + reset);
        informasiLilypad();
        System.out.println(green + "-".repeat(143) + reset);
        informasiWallnut();
        System.out.println(yellow + "=".repeat(143) + reset);
    }
    
    public void zombiesList() {
        String red = "\u001B[31m";    // ANSI code for red
        String yellow = "\u001B[33m"; // ANSI code for yellow
        String reset = "\u001B[0m";   // ANSI code to reset color
    
        String titleZombies = "=== List of All Zombies ===";
        int paddingSizeZombies = (143 - titleZombies.length()) / 2;
        String paddingZombies = " ".repeat(paddingSizeZombies);
    
        System.out.println(yellow + "=".repeat(143) + reset);
        System.out.println(yellow + paddingZombies + titleZombies + paddingZombies + reset);
        System.out.println(yellow + "=".repeat(143) + reset);
        System.out.println();
        informasiNormalZombie();
        informasiConeheadZombie();
        System.out.println(red + "-".repeat(143) + reset);
        informasiBucketheadZombie();
        System.out.println(red + "-".repeat(143) + reset);
        informasiFootballZombie();
        System.out.println(red + "-".repeat(143) + reset);
        informasiPolevaultingZombie();
        System.out.println(red + "-".repeat(143) + reset);
        informasiScreendoorZombie();
        System.out.println(red + "-".repeat(143) + reset);
        informasiWallnutZombie();
        System.out.println(red + "-".repeat(143) + reset);
        informasiDolphinriderZombie();
        System.out.println(red + "-".repeat(143) + reset);
        informasiDuckytubeConeheadZombie();
        System.out.println(red + "-".repeat(143) + reset);
        informasiDuckytubeZombie();
        System.out.println(yellow + "=".repeat(143) + reset);
    }    

    private void printCenteredBoxedTable(String... lines) {
        int consoleWidth = 143;  // Assume the console width is 143 characters
        int fixedWidth = 80;     // Fixed width for the table content
        int tableWidth = fixedWidth + 4; // Padding for the box borders
        int paddingSize = (consoleWidth - tableWidth) / 2;
        String padding = " ".repeat(paddingSize);
        
        String horizontalBorder = "+" + "-".repeat(fixedWidth) + "+";
        
        System.out.println(padding + horizontalBorder);
        for (String line : lines) {
            if (line.length() > fixedWidth) {
                line = line.substring(0, fixedWidth - 3) + "..."; // Truncate if the line is too long
            }
            String formattedLine = "| " + line + " ".repeat(fixedWidth - line.length()) + " |";
            System.out.println(padding + formattedLine);
        }
        System.out.println(padding + horizontalBorder);
    }
    
    public void informasiNormalZombie() {
        NormalZombie normalZombie = new NormalZombie();
        String[] infoLines = {
            "Name:         " + normalZombie.getName(),
            "Description:  Classic, slow-walking undead in common areas. It",
            "              can't walk in pools. Perfect for beginners, it's",
            "              the typical zombie everyone knows!",
            "Health:       " + normalZombie.getHealth(),
            "Damage:       " + normalZombie.getDamage(),
            "Speed:        " + normalZombie.getSpeed(),
            "Aquatic:      " + normalZombie.isAquatic()
        };

        printCenteredBoxedTable(infoLines);
    }
    
    public void informasiConeheadZombie() {
        ConeheadZombie coneheadZombie = new ConeheadZombie();
        String[] infoLines = {
            "Name:         " + coneheadZombie.getName(),
            "Description:  Tough with a cone on its head, harder to kill.",
            "              It's a bit faster than the normal zombie, but",
            "              still slow enough to be taken down easily.",
            "Health:       " + coneheadZombie.getHealth(),
            "Damage:       " + coneheadZombie.getDamage(),
            "Speed:        " + coneheadZombie.getSpeed(),
            "Aquatic:      " + coneheadZombie.isAquatic()
        };
        
    }
    
    public void informasiBucketheadZombie() {
        BucketheadZombie bucketheadZombie = new BucketheadZombie();
        String[] infoLines = {
            "Name:         " + bucketheadZombie.getName(),
            "Description:  Tough with a bucket on its head, even harder to",
            "              kill. It's a bit faster than the conehead zombie,",
            "              but still slow enough to be taken down easily.",
            "Health:       " + bucketheadZombie.getHealth(),
            "Damage:       " + bucketheadZombie.getDamage(),
            "Speed:        " + bucketheadZombie.getSpeed(),
            "Aquatic:      " + bucketheadZombie.isAquatic()
        };

        printCenteredBoxedTable(infoLines);
    }
    
    public void informasiFootballZombie() {
        FootballZombie footballZombie = new FootballZombie();
        String[] infoLines = {
            "Name:         " + footballZombie.getName(),
            "Description:  Tough with a football helmet, even tougher to kill.",
            "              It's a bit faster than the buckethead zombie, but",
            "              still slow enough to be taken down easily.",
            "Health:       " + footballZombie.getHealth(),
            "Damage:       " + footballZombie.getDamage(),
            "Speed:        " + footballZombie.getSpeed(),
            "Aquatic:      " + footballZombie.isAquatic()
        };

        printCenteredBoxedTable(infoLines);
    }
    
    public void informasiPolevaultingZombie() {
        PolevaultingZombie polevaultingZombie = new PolevaultingZombie();
        String[] infoLines = {
            "Name:         " + polevaultingZombie.getName(),
            "Description:  Jumps over the first plant it encounters. It's",
            "              faster than the normal zombie, but still slow",
            "              enough to be taken down easily.",
            "Health:       " + polevaultingZombie.getHealth(),
            "Damage:       " + polevaultingZombie.getDamage(),
            "Speed:        " + polevaultingZombie.getSpeed(),
            "Aquatic:      " + polevaultingZombie.isAquatic()
        };

        printCenteredBoxedTable(infoLines);
    }
    
    public void informasiScreendoorZombie() {
        ScreendoorZombie screendoorZombie = new ScreendoorZombie();
        String[] infoLines = {
            "Name:         " + screendoorZombie.getName(),
            "Description:  Tough with a screen door, even tougher to kill.",
            "              It's a bit faster than the football zombie, but",
            "              still slow enough to be taken down easily.",
            "Health:       " + screendoorZombie.getHealth(),
            "Damage:       " + screendoorZombie.getDamage(),
            "Speed:        " + screendoorZombie.getSpeed(),
            "Aquatic:      " + screendoorZombie.isAquatic()
        };

        printCenteredBoxedTable(infoLines);
    }
    
    public void informasiWallnutZombie() {
        WallnutZombie wallnutZombie = new WallnutZombie();
        String[] infoLines = {
            "Name:         " + wallnutZombie.getName(),
            "Description:  Tough with a wallnut, even tougher to kill. It's",
            "              a bit faster than the polevaulting zombie, but",
            "              still slow enough to be taken down easily.",
            "Health:       " + wallnutZombie.getHealth(),
            "Damage:       " + wallnutZombie.getDamage(),
            "Speed:        " + wallnutZombie.getSpeed(),
            "Aquatic:      " + wallnutZombie.isAquatic()
        };

        printCenteredBoxedTable(infoLines);
    }
    
    public void informasiDolphinriderZombie() {
        DolphinriderZombie dolphinriderZombie = new DolphinriderZombie();
        String[] infoLines = {
            "Name:         " + dolphinriderZombie.getName(),
            "Description:  Rides a dolphin, allowing it to jump over the",
            "              first plant it encounters. It's faster than the",
            "              screendoor zombie, but still slow enough to be",
            "              taken down easily.",
            "Health:       " + dolphinriderZombie.getHealth(),
            "Damage:       " + dolphinriderZombie.getDamage(),
            "Speed:        " + dolphinriderZombie.getSpeed(),
            "Aquatic:      " + dolphinriderZombie.isAquatic()
        };

        printCenteredBoxedTable(infoLines);
    }
    
    public void informasiDuckytubeConeheadZombie() {
        DuckytubeConeheadZombie duckytubeConeheadZombie = new DuckytubeConeheadZombie();
        String[] infoLines = {
            "Name:         " + duckytubeConeheadZombie.getName(),
            "Description:  Tough with a cone on its head, harder to kill.",
            "              It's a bit faster than the normal zombie, but",
            "              still slow enough to be taken down easily.",
            "Health:       " + duckytubeConeheadZombie.getHealth(),
            "Damage:       " + duckytubeConeheadZombie.getDamage(),
            "Speed:        " + duckytubeConeheadZombie.getSpeed(),
            "Aquatic:      " + duckytubeConeheadZombie.isAquatic()
        };

        printCenteredBoxedTable(infoLines);
    }
    
    public void informasiDuckytubeZombie() {
        DuckytubeZombie duckytubeZombie = new DuckytubeZombie();
        String[] infoLines = {
            "Name:         " + duckytubeZombie.getName(),
            "Description:  Classic, slow-walking undead in common areas.",
            "              It can walk in pools. Perfect for beginners,",
            "              it's the typical zombie everyone knows!",
            "Health:       " + duckytubeZombie.getHealth(),
            "Damage:       " + duckytubeZombie.getDamage(),
            "Speed:        " + duckytubeZombie.getSpeed(),
            "Aquatic:      " + duckytubeZombie.isAquatic()
        };

        printCenteredBoxedTable(infoLines);
    }
    
    public void informasiSunFlower() {
        SunFlower sunFlower = new SunFlower();
        String[] infoLines = {
            "Name:         " + sunFlower.getName(),
            "Description:  Produces sun, essential for planting more",
            "              plants.",
            "Health:       " + sunFlower.getHealth(),
            "Cost:         " + sunFlower.getCost(),
            "Attack Damage:" + sunFlower.getAttackDamage(),
            "Attack Speed: " + sunFlower.getAttackSpeed(),
            "Cooldown:     " + sunFlower.getCooldown(),
            "Jumpable:     " + sunFlower.isJumpable()
        };
        printCenteredBoxedTable(infoLines);
    }
    
    public void informasiTwinSunFlower() {
        TwinSunFlower twinSunFlower = new TwinSunFlower();
        String[] infoLines = {
            "Name:         " + twinSunFlower.getName(),
            "Description:  Produces twice as much sun as the Sunflower.",
            "Health:       " + twinSunFlower.getHealth(),
            "Cost:         " + twinSunFlower.getCost(),
            "Attack Damage:" + twinSunFlower.getAttackDamage(),
            "Attack Speed: " + twinSunFlower.getAttackSpeed(),
            "Cooldown:     " + twinSunFlower.getCooldown(),
            "Jumpable:     " + twinSunFlower.isJumpable()
        };
        printCenteredBoxedTable(infoLines);
    }
    
    public void informasiTangleKelp() {
        TangleKelp tangleKelp = new TangleKelp();
        String[] infoLines = {
            "Name:         " + tangleKelp.getName(),
            "Description:  Instantly kills the first zombie that steps on",
            "              it. It can only be planted in water.",
            "Health:       " + tangleKelp.getHealth(),
            "Cost:         " + tangleKelp.getCost(),
            "Attack Damage:" + tangleKelp.getAttackDamage(),
            "Attack Speed: " + tangleKelp.getAttackSpeed(),
            "Cooldown:     " + tangleKelp.getCooldown(),
            "Jumpable:     " + tangleKelp.isJumpable()
        };
        printCenteredBoxedTable(infoLines);
    }
    
    public void informasiPeashooter() {
        Peashooter peashooter = new Peashooter();
        String[] infoLines = {
            "Name:         " + peashooter.getName(),
            "Description:  Shoots peas at zombies.",
            "Health:       " + peashooter.getHealth(),
            "Cost:         " + peashooter.getCost(),
            "Attack Damage:" + peashooter.getAttackDamage(),
            "Attack Speed: " + peashooter.getAttackSpeed(),
            "Cooldown:     " + peashooter.getCooldown(),
            "Jumpable:     " + peashooter.isJumpable()
        };
        printCenteredBoxedTable(infoLines);
    }
    
    public void informasiRepeater() {
        Repeater repeater = new Repeater();
        String[] infoLines = {
            "Name:         " + repeater.getName(),
            "Description:  Shoots two peas at a time.",
            "Health:       " + repeater.getHealth(),
            "Cost:         " + repeater.getCost(),
            "Attack Damage:" + repeater.getAttackDamage(),
            "Attack Speed: " + repeater.getAttackSpeed(),
            "Cooldown:     " + repeater.getCooldown(),
            "Jumpable:     " + repeater.isJumpable()
        };
        printCenteredBoxedTable(infoLines);
    }
    
    public void informasiSnowPea() {
        SnowPea snowPea = new SnowPea();
        String[] infoLines = {
            "Name:         " + snowPea.getName(),
            "Description:  Shoots peas that slow down zombies.",
            "Health:       " + snowPea.getHealth(),
            "Cost:         " + snowPea.getCost(),
            "Attack Damage:" + snowPea.getAttackDamage(),
            "Attack Speed: " + snowPea.getAttackSpeed(),
            "Cooldown:     " + snowPea.getCooldown(),
            "Jumpable:     " + snowPea.isJumpable()
        };
        printCenteredBoxedTable(infoLines);
    }
    
    public void informasiSquash() {
        Squash squash = new Squash();
        String[] infoLines = {
            "Name:         " + squash.getName(),
            "Description:  Squashes the first zombie that steps on it.",
            "Health:       " + squash.getHealth(),
            "Cost:         " + squash.getCost(),
            "Attack Damage:" + squash.getAttackDamage(),
            "Attack Speed: " + squash.getAttackSpeed(),
            "Cooldown:     " + squash.getCooldown(),
            "Jumpable:     " + squash.isJumpable()
        };
        printCenteredBoxedTable(infoLines);
    }
    
    public void informasiTallnut() {
        Tallnut tallnut = new Tallnut();
        String[] infoLines = {
            "Name:         " + tallnut.getName(),
            "Description:  Can take a lot of damage, perfect for protection.",
            "Health:       " + tallnut.getHealth(),
            "Cost:         " + tallnut.getCost(),
            "Attack Damage:" + tallnut.getAttackDamage(),
            "Attack Speed: " + tallnut.getAttackSpeed(),
            "Cooldown:     " + tallnut.getCooldown(),
            "Jumpable:     " + tallnut.isJumpable()
        };
        printCenteredBoxedTable(infoLines);
    }
    
    public void informasiLilypad() {
        Lilypad lilypad = new Lilypad();
        String[] infoLines = {
            "Name:         " + lilypad.getName(),
            "Description:  Allows planting non-aquatic plants on water.",
            "Health:       " + lilypad.getHealth(),
            "Cost:         " + lilypad.getCost(),
            "Attack Damage:" + lilypad.getAttackDamage(),
            "Attack Speed: " + lilypad.getAttackSpeed(),
            "Cooldown:     " + lilypad.getCooldown(),
            "Jumpable:     " + lilypad.isJumpable()
        };
        printCenteredBoxedTable(infoLines);
    }
    
    public void informasiWallnut() {
        Wallnut wallnut = new Wallnut();
        String[] infoLines = {
            "Name:         " + wallnut.getName(),
            "Description:  Can take a lot of damage, perfect for protection.",
            "Health:       " + wallnut.getHealth(),
            "Cost:         " + wallnut.getCost(),
            "Attack Damage:" + wallnut.getAttackDamage(),
            "Attack Speed: " + wallnut.getAttackSpeed(),
            "Cooldown:     " + wallnut.getCooldown(),
            "Jumpable:     " + wallnut.isJumpable()
        };
        printCenteredBoxedTable(infoLines);
    }
    
}