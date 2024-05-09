package Zombie;


public class ZombieFactory {

    // LIST ZOMBIE 
    // Normal Zombie
    // Conehead Zombie
    // Buckethead Zombie
    // Dolphin Rider Zombie
    // Ducky Tube Conehead Zombie
    // Ducky Tube Zombie
    // Football Zombie
    // Pole Vaulting Zombie
    // Screen Door Zombie
    // Wallnut Zombie



    public Zombie createZombie(int type){
        switch (type) {
            case 1:
                return new NormalZombie();
            case 2:
                return new ConeheadZombie();
            case 3:
                return new BucketheadZombie();
            case 4:
                return new DolphinriderZombie();
            case 5:
                return new DuckytubeConeheadZombie();
            case 6:
                return new DuckytubeZombie();
            case 7:
                return new FootballZombie();
            case 8:
                return new PolevaultingZombie();
            case 9:
                return new ScreendoorZombie();
            case 10:
                return new WallnutZombie();
            default:
                return null;
        }
    }
}
