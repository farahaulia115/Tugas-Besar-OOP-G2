package Main;
import Zombie.*;
import Plant.*;
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
    
        int consoleWidth = 80;  // Assume the console width is 80 characters
        for (String line : asciiArt) {
            int paddingSize = (consoleWidth - line.length()) / 2;
            String padding = " ".repeat(paddingSize);
            System.out.println(padding + line);
        }
    }    
        
    public void help(){
        System.out.println("Help");
    }

    public void plantsList() {
        String green = "\u001B[32m";  // ANSI code for green
        String yellow = "\u001B[33m"; // ANSI code for yellow
        String reset = "\u001B[0m";   // ANSI code to reset color
    
        String titlePlants = "=== List of All Plants ===";
        int paddingSizePlants = (68 - titlePlants.length()) / 2;
        String paddingPlants = " ".repeat(paddingSizePlants);
    
        System.out.println(yellow + "====================================================================" + reset);
        System.out.println(yellow + paddingPlants + titlePlants + paddingPlants + reset);
        System.out.println(yellow + "====================================================================" + reset);
        System.out.println();
        informasiSunFlower();
        System.out.println(green + "--------------------------------------------------------------------" + reset);
        informasiTwinSunFlower();
        System.out.println(green + "--------------------------------------------------------------------" + reset);
        informasiTangleKelp();
        System.out.println(green + "--------------------------------------------------------------------" + reset);
        informasiPeashooter();
        System.out.println(green + "--------------------------------------------------------------------" + reset);
        informasiRepeater();
        System.out.println(green + "--------------------------------------------------------------------" + reset);
        informasiSnowPea();
        System.out.println(green + "--------------------------------------------------------------------" + reset);
        informasiSquash();
        System.out.println(green + "--------------------------------------------------------------------" + reset);
        informasiTallnut();
        System.out.println(green + "--------------------------------------------------------------------" + reset);
        informasiLilypad();
        System.out.println(green + "--------------------------------------------------------------------" + reset);
        informasiWallnut();
        System.out.println(yellow + "====================================================================" + reset);
    }
    
    public void zombiesList() {
        String red = "\u001B[31m";    // ANSI code for red
        String yellow = "\u001B[33m"; // ANSI code for yellow
        String reset = "\u001B[0m";   // ANSI code to reset color
    
        String titleZombies = "=== List of All Zombies ===";
        int paddingSizeZombies = (68 - titleZombies.length()) / 2;
        String paddingZombies = " ".repeat(paddingSizeZombies);
    
        System.out.println(yellow + "====================================================================" + reset);
        System.out.println(yellow + paddingZombies + titleZombies + paddingZombies + reset);
        System.out.println(yellow + "====================================================================" + reset);
        System.out.println();
        informasiNormalZombie();
        System.out.println(red + "--------------------------------------------------------------------" + reset);
        informasiConeheadZombie();
        System.out.println(red + "--------------------------------------------------------------------" + reset);
        informasiBucketheadZombie();
        System.out.println(red + "--------------------------------------------------------------------" + reset);
        informasiFootballZombie();
        System.out.println(red + "--------------------------------------------------------------------" + reset);
        informasiPolevaultingZombie();
        System.out.println(red + "--------------------------------------------------------------------" + reset);
        informasiScreendoorZombie();
        System.out.println(red + "--------------------------------------------------------------------" + reset);
        informasiWallnutZombie();
        System.out.println(red + "--------------------------------------------------------------------" + reset);
        informasiDolphinriderZombie();
        System.out.println(red + "--------------------------------------------------------------------" + reset);
        informasiDuckytubeConeheadZombie();
        System.out.println(red + "--------------------------------------------------------------------" + reset);
        informasiDuckytubeZombie();
        System.out.println(yellow + "====================================================================" + reset);
    }    
    
    public void informasiNormalZombie() {
        NormalZombie normalZombie = new NormalZombie();
        System.out.println("Name:         " + normalZombie.getName());
        System.out.println("Description:  Classic, slow-walking undead in common areas. It");
        System.out.println("              can't walk in pools. Perfect for beginners, it's");
        System.out.println("              the typical zombie everyone knows!");
        System.out.println("Health:       " + normalZombie.getHealth());
        System.out.println("Damage:       " + normalZombie.getDamage());
        System.out.println("Speed:        " + normalZombie.getSpeed());
        System.out.println("Aquatic:      " + normalZombie.isAquatic());
        System.out.println();
    }
    
    public void informasiConeheadZombie() {
        ConeheadZombie coneheadZombie = new ConeheadZombie();
        System.out.println("Name:         " + coneheadZombie.getName());
        System.out.println("Description:  Tougher with a cone on its head, but still slow.");
        System.out.println("              It's a bit faster than the normal zombie, but");
        System.out.println("              still slow enough to be taken down easily.");
        System.out.println("Health:       " + coneheadZombie.getHealth());
        System.out.println("Damage:       " + coneheadZombie.getDamage());
        System.out.println("Speed:        " + coneheadZombie.getSpeed());
        System.out.println("Aquatic:      " + coneheadZombie.isAquatic());
        System.out.println();
    }
    
    public void informasiBucketheadZombie() {
        BucketheadZombie bucketheadZombie = new BucketheadZombie();
        System.out.println("Name:         " + bucketheadZombie.getName());
        System.out.println("Description:  Tough with a bucket on its head, harder to kill.");
        System.out.println("              It's a bit faster than the conehead zombie, but");
        System.out.println("              still slow enough to be taken down easily.");
        System.out.println("Health:       " + bucketheadZombie.getHealth());
        System.out.println("Damage:       " + bucketheadZombie.getDamage());
        System.out.println("Speed:        " + bucketheadZombie.getSpeed());
        System.out.println("Aquatic:      " + bucketheadZombie.isAquatic());
        System.out.println();
    }
    
    public void informasiFootballZombie() {
        FootballZombie footballZombie = new FootballZombie();
        System.out.println("Name:         " + footballZombie.getName());
        System.out.println("Description:  Fast and tough, wearing football gear. It's");
        System.out.println("              faster than the normal zombie, but still slow");
        System.out.println("              enough to be taken down easily. Perfect for");
        System.out.println("              beginners who want a bit of a challenge.");
        System.out.println("Health:       " + footballZombie.getHealth());
        System.out.println("Damage:       " + footballZombie.getDamage());
        System.out.println("Speed:        " + footballZombie.getSpeed());
        System.out.println("Aquatic:      " + footballZombie.isAquatic());
        System.out.println();
    }
    
    public void informasiPolevaultingZombie() {
        PolevaultingZombie polevaultingZombie = new PolevaultingZombie();
        System.out.println("Name:         " + polevaultingZombie.getName());
        System.out.println("Description:  Fast and can jump over obstacles. It's faster");
        System.out.println("              than the normal zombie, but still slow enough");
        System.out.println("              to be taken down easily. Perfect for beginners");
        System.out.println("              who want a bit of a challenge.");
        System.out.println("Health:       " + polevaultingZombie.getHealth());
        System.out.println("Damage:       " + polevaultingZombie.getDamage());
        System.out.println("Speed:        " + polevaultingZombie.getSpeed());
        System.out.println("Aquatic:      " + polevaultingZombie.isAquatic());
        System.out.println();
    }
    
    public void informasiScreendoorZombie() {
        ScreendoorZombie screendoorZombie = new ScreendoorZombie();
        System.out.println("Name:         " + screendoorZombie.getName());
        System.out.println("Description:  Tough with a screen door as a shield. It's a bit");
        System.out.println("              faster than the conehead zombie, but still slow");
        System.out.println("              enough to be taken down easily.");
        System.out.println("Health:       " + screendoorZombie.getHealth());
        System.out.println("Damage:       " + screendoorZombie.getDamage());
        System.out.println("Speed:        " + screendoorZombie.getSpeed());
        System.out.println("Aquatic:      " + screendoorZombie.isAquatic());
        System.out.println();
    }
    
    public void informasiWallnutZombie() {
        WallnutZombie wallnutZombie = new WallnutZombie();
        System.out.println("Name:         " + wallnutZombie.getName());
        System.out.println("Description:  Extremely tough with a hard shell. It's a bit");
        System.out.println("              faster than the conehead zombie, but still slow");
        System.out.println("              enough to be taken down easily.");
        System.out.println("Health:       " + wallnutZombie.getHealth());
        System.out.println("Damage:       " + wallnutZombie.getDamage());
        System.out.println("Speed:        " + wallnutZombie.getSpeed());
        System.out.println("Aquatic:      " + wallnutZombie.isAquatic());
        System.out.println();
    }
    
    public void informasiDolphinriderZombie() {
        DolphinriderZombie dolphinriderZombie = new DolphinriderZombie();
        System.out.println("Name:         " + dolphinriderZombie.getName());
        System.out.println("Description:  Rides a dolphin, moving quickly in pools. It's");
        System.out.println("              faster than the normal zombie, but still slow");
        System.out.println("              enough to be taken down easily. Perfect for");
        System.out.println("              beginners who want a bit of a challenge.");
        System.out.println("Health:       " + dolphinriderZombie.getHealth());
        System.out.println("Damage:       " + dolphinriderZombie.getDamage());
        System.out.println("Speed:        " + dolphinriderZombie.getSpeed());
        System.out.println("Aquatic:      " + dolphinriderZombie.isAquatic());
        System.out.println();
    }
    
    public void informasiDuckytubeConeheadZombie() {
        DuckytubeConeheadZombie duckytubeConeheadZombie = new DuckytubeConeheadZombie();
        System.out.println("Name:         " + duckytubeConeheadZombie.getName());
        System.out.println("Description:  Combines a conehead with the ability to float.");
        System.out.println("              It's a bit faster than the normal zombie, but");
        System.out.println("              still slow enough to be taken down easily.");
        System.out.println("Health:       " + duckytubeConeheadZombie.getHealth());
        System.out.println("Damage:       " + duckytubeConeheadZombie.getDamage());
        System.out.println("Speed:        " + duckytubeConeheadZombie.getSpeed());
        System.out.println("Aquatic:      " + duckytubeConeheadZombie.isAquatic());
        System.out.println();
    }
    
    public void informasiDuckytubeZombie() {
        DuckytubeZombie duckytubeZombie = new DuckytubeZombie();
        System.out.println("Name:         " + duckytubeZombie.getName());
        System.out.println("Description:  Classic, slow-walking undead that can float");
        System.out.println("              in pools. Perfect for beginners, it's the");
        System.out.println("              typical zombie everyone knows!");
        System.out.println("Health:       " + duckytubeZombie.getHealth());
        System.out.println("Damage:       " + duckytubeZombie.getDamage());
        System.out.println("Speed:        " + duckytubeZombie.getSpeed());
        System.out.println("Aquatic:      " + duckytubeZombie.isAquatic());
        System.out.println();
    }
    
    public void informasiSunFlower() {
        SunFlower sunFlower = new SunFlower();
        System.out.println("Name:         " + sunFlower.getName());
        System.out.println("Description:  Produces sun, essential for planting more");
        System.out.println("              plants.");
        System.out.println("Health:       " + sunFlower.getHealth());
        System.out.println("Cost:         " + sunFlower.getCost());
        System.out.println("Attack Damage:" + sunFlower.getAttackDamage());
        System.out.println("Attack Speed: " + sunFlower.getAttackSpeed());
        System.out.println("Cooldown:     " + sunFlower.getCooldown());
        System.out.println("Jumpable:     " + sunFlower.isJumpable());
        System.out.println();
    }
    
    public void informasiTwinSunFlower() {
        TwinSunFlower twinSunFlower = new TwinSunFlower();
        System.out.println("Name:         " + twinSunFlower.getName());
        System.out.println("Description:  Produces more sun than the Sunflower.");
        System.out.println("Health:       " + twinSunFlower.getHealth());
        System.out.println("Cost:         " + twinSunFlower.getCost());
        System.out.println("Attack Damage:" + twinSunFlower.getAttackDamage());
        System.out.println("Attack Speed: " + twinSunFlower.getAttackSpeed());
        System.out.println("Cooldown:     " + twinSunFlower.getCooldown());
        System.out.println("Jumpable:     " + twinSunFlower.isJumpable());
        System.out.println();
    }
    
    public void informasiTangleKelp() {
        TangleKelp tangleKelp = new TangleKelp();
        System.out.println("Name:         " + tangleKelp.getName());
        System.out.println("Description:  Instantly kills any zombie it grabs. It’s");
        System.out.println("              your go-to for taking down tough zombies in");
        System.out.println("              a pinch!");
        System.out.println("Health:       " + tangleKelp.getHealth());
        System.out.println("Cost:         " + tangleKelp.getCost());
        System.out.println("Attack Damage:" + tangleKelp.getAttackDamage());
        System.out.println("Attack Speed: " + tangleKelp.getAttackSpeed());
        System.out.println("Cooldown:     " + tangleKelp.getCooldown());
        System.out.println("Jumpable:     " + tangleKelp.isJumpable());
        System.out.println();
    }
    
    public void informasiPeashooter() {
        Peashooter peashooter = new Peashooter();
        System.out.println("Name:         " + peashooter.getName());
        System.out.println("Description:  Basic plant that shoots peas at zombies.");
        System.out.println("Health:       " + peashooter.getHealth());
        System.out.println("Cost:         " + peashooter.getCost());
        System.out.println("Attack Damage:" + peashooter.getAttackDamage());
        System.out.println("Attack Speed: " + peashooter.getAttackSpeed());
        System.out.println("Cooldown:     " + peashooter.getCooldown());
        System.out.println("Jumpable:     " + peashooter.isJumpable());
        System.out.println();
    }
    
    public void informasiRepeater() {
        Repeater repeater = new Repeater();
        System.out.println("Name:         " + repeater.getName());
        System.out.println("Description:  Shoots peas twice as fast as the Peashooter.");
        System.out.println("Health:       " + repeater.getHealth());
        System.out.println("Cost:         " + repeater.getCost());
        System.out.println("Attack Damage:" + repeater.getAttackDamage());
        System.out.println("Attack Speed: " + repeater.getAttackSpeed());
        System.out.println("Cooldown:     " + repeater.getCooldown());
        System.out.println("Jumpable:     " + repeater.isJumpable());
        System.out.println();
    }
    
    public void informasiSnowPea() {
        SnowPea snowPea = new SnowPea();
        System.out.println("Name:         " + snowPea.getName());
        System.out.println("Description:  Slows down zombies, cutting their speed by");
        System.out.println("              50% for 3 seconds. The effect doesn’t stack,");
        System.out.println("              but it’s great for giving you more time to");
        System.out.println("              defend!");
        System.out.println("Health:       " + snowPea.getHealth());
        System.out.println("Cost:         " + snowPea.getCost());
        System.out.println("Attack Damage:" + snowPea.getAttackDamage());
        System.out.println("Attack Speed: " + snowPea.getAttackSpeed());
        System.out.println("Cooldown:     " + snowPea.getCooldown());
        System.out.println("Jumpable:     " + snowPea.isJumpable());
        System.out.println();
    }
    
    public void informasiSquash() {
        Squash squash = new Squash();
        System.out.println("Name:         " + squash.getName());
        System.out.println("Description:  Instantly kills any zombie it lands on. It’s");
        System.out.println("              your go-to for taking down tough zombies in");
        System.out.println("              a pinch!");
        System.out.println("Health:       " + squash.getHealth());
        System.out.println("Cost:         " + squash.getCost());
        System.out.println("Attack Damage:" + squash.getAttackDamage());
        System.out.println("Attack Speed: " + squash.getAttackSpeed());
        System.out.println("Cooldown:     " + squash.getCooldown());
        System.out.println("Jumpable:     " + squash.isJumpable());
        System.out.println();
    }
    
    public void informasiTallnut() {
        Tallnut tallnut = new Tallnut();
        System.out.println("Name:         " + tallnut.getName());
        System.out.println("Description:  Can take a lot of damage, perfect for");
        System.out.println("              protection.");
        System.out.println("Health:       " + tallnut.getHealth());
        System.out.println("Cost:         " + tallnut.getCost());
        System.out.println("Attack Damage:" + tallnut.getAttackDamage());
        System.out.println("Attack Speed: " + tallnut.getAttackSpeed());
        System.out.println("Cooldown:     " + tallnut.getCooldown());
        System.out.println("Jumpable:     " + tallnut.isJumpable());
        System.out.println();
    }
    
    public void informasiLilypad() {
        Lilypad lilypad = new Lilypad();
        System.out.println("Name:         " + lilypad.getName());
        System.out.println("Description:  Allows you to plant other plants on water.");
        System.out.println("              It adds its health to any plant you place");
        System.out.println("              on it, making it a crucial part of your");
        System.out.println("              water defenses!");
        System.out.println("Health:       " + lilypad.getHealth());
        System.out.println("Cost:         " + lilypad.getCost());
        System.out.println("Attack Damage:" + lilypad.getAttackDamage());
        System.out.println("Attack Speed: " + lilypad.getAttackSpeed());
        System.out.println("Cooldown:     " + lilypad.getCooldown());
        System.out.println("Jumpable:     " + lilypad.isJumpable());
        System.out.println();
    }
    
    public void informasiWallnut() {
        Wallnut wallnut = new Wallnut();
        System.out.println("Name:         " + wallnut.getName());
        System.out.println("Description:  Can take a lot of damage, perfect for");
        System.out.println("              protection.");
        System.out.println("Health:       " + wallnut.getHealth());
        System.out.println("Cost:         " + wallnut.getCost());
        System.out.println("Attack Damage:" + wallnut.getAttackDamage());
        System.out.println("Attack Speed: " + wallnut.getAttackSpeed());
        System.out.println("Cooldown:     " + wallnut.getCooldown());
        System.out.println("Jumpable:     " + wallnut.isJumpable());
        System.out.println();
    }
    
}