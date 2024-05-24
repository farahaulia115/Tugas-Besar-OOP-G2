package tubes.maven.Zombie;


public class ZombieFactory {

    //List of zombie types
    //1. Normal Zombie
    //2. Conehead Zombie
    //3. Buckethead Zombie
    //4. Football Zombie
    //5. Polevaulting Zombie
    //6. Screendoor Zombie
    //7. Wallnut Zombie
    //8. Dolphinrider Zombie
    //9. Duckytube Conehead Zombie
    //10. Duckytube Zombie
    
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
