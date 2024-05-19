package tubes.maven.Zombie;


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
                return new FootballZombie();
            case 5:
                return new PolevaultingZombie();
            case 6:
                return new ScreendoorZombie();
            case 7:
                return new WallnutZombie();
            case 8:
                return new DolphinriderZombie();
            case 9:
                return new DuckytubeConeheadZombie();
            case 10:
                return new DuckytubeZombie();
            default:
                return null;
        }
    }
}
