package Main;
import Zombie.*;
import Plant.*;
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
        System.out.println("=== List of All Plants ===");
        informasiSunFlower();
        System.out.println("***************************");
        informasiTwinSunFlower();
        System.out.println("***************************");
        informasiTangleKelp();
        System.out.println("***************************");
        informasiPeashooter();
        System.out.println("***************************");
        informasiRepeater();
        System.out.println("***************************");
        informasiSnowPea();
        System.out.println("***************************");
        informasiSquash();
        System.out.println("***************************");
        informasiTallnut();
        System.out.println("***************************");
        informasiLilypad();
        System.out.println("***************************");
        informasiWallnut();
        System.out.println("==========================");
    }

    public void zombiesList() {
        System.out.println("=== List of All Zombies ===");
        informasiNormalZombie();
        System.out.println("***************************");
        informasiConeheadZombie();
        System.out.println("***************************");
        informasiBucketheadZombie();
        System.out.println("***************************");
        informasiFootballZombie();
        System.out.println("***************************");
        informasiPolevaultingZombie();
        System.out.println("***************************");
        informasiScreendoorZombie();
        System.out.println("***************************");
        informasiWallnutZombie();
        System.out.println("***************************");
        informasiDolphinriderZombie();
        System.out.println("***************************");
        informasiDuckytubeConeheadZombie();
        System.out.println("***************************");
        informasiDuckytubeZombie();
        System.out.println("==========================");
    }
    
    public void informasiNormalZombie(){
        NormalZombie normalZombie = new NormalZombie();
        System.out.println("Name: " + normalZombie.getName());
        System.out.println("Health: " + normalZombie.getHealth());
        System.out.println("Damage: " + normalZombie.getDamage());
        System.out.println("Speed: " + normalZombie.getSpeed());
        System.out.println("Aquatic: " + normalZombie.isAquatic());
    }
    public void informasiConeheadZombie(){
        ConeheadZombie coneheadZombie = new ConeheadZombie();
        System.out.println("Name: " + coneheadZombie.getName());
        System.out.println("Health: " + coneheadZombie.getHealth());
        System.out.println("Damage: " + coneheadZombie.getDamage());
        System.out.println("Speed: " + coneheadZombie.getSpeed());
        System.out.println("Aquatic: " + coneheadZombie.isAquatic());
    }
    public void informasiBucketheadZombie(){
        BucketheadZombie bucketheadZombie = new BucketheadZombie();
        System.out.println("Name: " + bucketheadZombie.getName());
        System.out.println("Health: " + bucketheadZombie.getHealth());
        System.out.println("Damage: " + bucketheadZombie.getDamage());
        System.out.println("Speed: " + bucketheadZombie.getSpeed());
        System.out.println("Aquatic: " + bucketheadZombie.isAquatic());
    }
    public void informasiFootballZombie(){
        FootballZombie footballZombie = new FootballZombie();
        System.out.println("Name: " + footballZombie.getName());
        System.out.println("Health: " + footballZombie.getHealth());
        System.out.println("Damage: " + footballZombie.getDamage());
        System.out.println("Speed: " + footballZombie.getSpeed());
        System.out.println("Aquatic: " + footballZombie.isAquatic());
    }
    public void informasiPolevaultingZombie(){
        PolevaultingZombie polevaultingZombie = new PolevaultingZombie();
        System.out.println("Name: " + polevaultingZombie.getName());
        System.out.println("Health: " + polevaultingZombie.getHealth());
        System.out.println("Damage: " + polevaultingZombie.getDamage());
        System.out.println("Speed: " + polevaultingZombie.getSpeed());
        System.out.println("Aquatic: " + polevaultingZombie.isAquatic());
    }
    public void informasiScreendoorZombie(){
        ScreendoorZombie screendoorZombie = new ScreendoorZombie();
        System.out.println("Name: " + screendoorZombie.getName());
        System.out.println("Health: " + screendoorZombie.getHealth());
        System.out.println("Damage: " + screendoorZombie.getDamage());
        System.out.println("Speed: " + screendoorZombie.getSpeed());
        System.out.println("Aquatic: " + screendoorZombie.isAquatic());
    }
    public void informasiWallnutZombie(){
        WallnutZombie wallnutZombie = new WallnutZombie();
        System.out.println("Name: " + wallnutZombie.getName());
        System.out.println("Health: " + wallnutZombie.getHealth());
        System.out.println("Damage: " + wallnutZombie.getDamage());
        System.out.println("Speed: " + wallnutZombie.getSpeed());
        System.out.println("Aquatic: " + wallnutZombie.isAquatic());
    }
    public void informasiDolphinriderZombie(){
        DolphinriderZombie dolphinriderZombie = new DolphinriderZombie();
        System.out.println("Name: " + dolphinriderZombie.getName());
        System.out.println("Health: " + dolphinriderZombie.getHealth());
        System.out.println("Damage: " + dolphinriderZombie.getDamage());
        System.out.println("Speed: " + dolphinriderZombie.getSpeed());
        System.out.println("Aquatic: " + dolphinriderZombie.isAquatic());
    }
    public void informasiDuckytubeConeheadZombie(){
        DuckytubeConeheadZombie duckytubeConeheadZombie = new DuckytubeConeheadZombie();
        System.out.println("Name: " + duckytubeConeheadZombie.getName());
        System.out.println("Health: " + duckytubeConeheadZombie.getHealth());
        System.out.println("Damage: " + duckytubeConeheadZombie.getDamage());
        System.out.println("Speed: " + duckytubeConeheadZombie.getSpeed());
        System.out.println("Aquatic: " + duckytubeConeheadZombie.isAquatic());
    }
    public void informasiDuckytubeZombie(){
        DuckytubeZombie duckytubeZombie = new DuckytubeZombie();
        System.out.println("Name: " + duckytubeZombie.getName());
        System.out.println("Health: " + duckytubeZombie.getHealth());
        System.out.println("Damage: " + duckytubeZombie.getDamage());
        System.out.println("Speed: " + duckytubeZombie.getSpeed());
        System.out.println("Aquatic: " + duckytubeZombie.isAquatic());
    }

    public void informasiSunFlower(){
        SunFlower sunFlower = new SunFlower();
        System.out.println("Name: " + sunFlower.getName());
        System.out.println("Health: " + sunFlower.getHealth());
        System.out.println("Cost: " + sunFlower.getCost());
        System.out.println("Attack Damage: " + sunFlower.getAttackDamage());
        System.out.println("Attack Speed: " + sunFlower.getAttackSpeed());
        System.out.println("Cooldown: " + sunFlower.getCooldown());
        System.out.println("Jumpable: " + sunFlower.isJumpable());
    }

    public void informasiTwinSunFlower(){
        TwinSunFlower twinSunFlower = new TwinSunFlower();
        System.out.println("Name: " + twinSunFlower.getName());
        System.out.println("Health: " + twinSunFlower.getHealth());
        System.out.println("Cost: " + twinSunFlower.getCost());
        System.out.println("Attack Damage: " + twinSunFlower.getAttackDamage());
        System.out.println("Attack Speed: " + twinSunFlower.getAttackSpeed());
        System.out.println("Cooldown: " + twinSunFlower.getCooldown());
        System.out.println("Jumpable: " + twinSunFlower.isJumpable());
    }

    public void informasiTangleKelp(){
        TangleKelp tangleKelp = new TangleKelp();
        System.out.println("Name: " + tangleKelp.getName());
        System.out.println("Health: " + tangleKelp.getHealth());
        System.out.println("Cost: " + tangleKelp.getCost());
        System.out.println("Attack Damage: " + tangleKelp.getAttackDamage());
        System.out.println("Attack Speed: " + tangleKelp.getAttackSpeed());
        System.out.println("Cooldown: " + tangleKelp.getCooldown());
        System.out.println("Jumpable: " + tangleKelp.isJumpable());
    }

    public void informasiPeashooter(){
        Peashooter peashooter = new Peashooter();
        System.out.println("Name: " + peashooter.getName());
        System.out.println("Health: " + peashooter.getHealth());
        System.out.println("Cost: " + peashooter.getCost());
        System.out.println("Attack Damage: " + peashooter.getAttackDamage());
        System.out.println("Attack Speed: " + peashooter.getAttackSpeed());
        System.out.println("Cooldown: " + peashooter.getCooldown());
        System.out.println("Jumpable: " + peashooter.isJumpable());
    }

    public void informasiRepeater(){
        Repeater repeater = new Repeater();
        System.out.println("Name: " + repeater.getName());
        System.out.println("Health: " + repeater.getHealth());
        System.out.println("Cost: " + repeater.getCost());
        System.out.println("Attack Damage: " + repeater.getAttackDamage());
        System.out.println("Attack Speed: " + repeater.getAttackSpeed());
        System.out.println("Cooldown: " + repeater.getCooldown());
        System.out.println("Jumpable: " + repeater.isJumpable());
    }

    public void informasiSnowPea(){
        SnowPea snowPea = new SnowPea();
        System.out.println("Name: " + snowPea.getName());
        System.out.println("Health: " + snowPea.getHealth());
        System.out.println("Cost: " + snowPea.getCost());
        System.out.println("Attack Damage: " + snowPea.getAttackDamage());
        System.out.println("Attack Speed: " + snowPea.getAttackSpeed());
        System.out.println("Cooldown: " + snowPea.getCooldown());
        System.out.println("Jumpable: " + snowPea.isJumpable());
    }

    public void informasiSquash(){
        Squash squash = new Squash();
        System.out.println("Name: " + squash.getName());
        System.out.println("Health: " + squash.getHealth());
        System.out.println("Cost: " + squash.getCost());
        System.out.println("Attack Damage: " + squash.getAttackDamage());
        System.out.println("Attack Speed: " + squash.getAttackSpeed());
        System.out.println("Cooldown: " + squash.getCooldown());
        System.out.println("Jumpable: " + squash.isJumpable());
    }

    public void informasiTallnut(){
        Tallnut tallnut = new Tallnut();
        System.out.println("Name: " + tallnut.getName());
        System.out.println("Health: " + tallnut.getHealth());
        System.out.println("Cost: " + tallnut.getCost());
        System.out.println("Attack Damage: " + tallnut.getAttackDamage());
        System.out.println("Attack Speed: " + tallnut.getAttackSpeed());
        System.out.println("Cooldown: " + tallnut.getCooldown());
        System.out.println("Jumpable: " + tallnut.isJumpable());
    }

    public void informasiLilypad(){
        Lilypad lilypad = new Lilypad();
        System.out.println("Name: " + lilypad.getName());
        System.out.println("Health: " + lilypad.getHealth());
        System.out.println("Cost: " + lilypad.getCost());
        System.out.println("Attack Damage: " + lilypad.getAttackDamage());
        System.out.println("Attack Speed: " + lilypad.getAttackSpeed());
        System.out.println("Cooldown: " + lilypad.getCooldown());
        System.out.println("Jumpable: " + lilypad.isJumpable());
    }

    public void informasiWallnut(){
        Wallnut wallnut = new Wallnut();
        System.out.println("Name: " + wallnut.getName());
        System.out.println("Health: " + wallnut.getHealth());
        System.out.println("Cost: " + wallnut.getCost());
        System.out.println("Attack Damage: " + wallnut.getAttackDamage());
        System.out.println("Attack Speed: " + wallnut.getAttackSpeed());
        System.out.println("Cooldown: " + wallnut.getCooldown());
        System.out.println("Jumpable: " + wallnut.isJumpable());
    }
}