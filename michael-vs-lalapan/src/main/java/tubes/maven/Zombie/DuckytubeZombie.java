package tubes.maven.Zombie;
import tubes.maven.Thread.Time;
import com.fasterxml.jackson.annotation.JsonTypeName;
@JsonTypeName("DuckytubeZombie")
public class DuckytubeZombie implements Zombie {
    private String name = "Ducky Tube Zombie";
    private int health = 100;
    private int damage = 100;
    private int speed = 1;
    private boolean aquatic = true;
    private int timeSpawn;
    private int x;
    private int y;
    private int moveInterval = 10;
    private boolean slowed = false;
    private int timeSlowed;
    private int slowDuration = 3;

    public DuckytubeZombie() {
        this.timeSpawn = Time.getTime().getTotalSeconds();
    }

    public DuckytubeZombie(String name, int health, int damage, int speed, boolean aquatic, int x, int y, int timeSpawn, int moveInterval, boolean slowed, int timeSlowed, int slowDuration) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.speed = speed;
        this.aquatic = aquatic;
        this.x = x;
        this.y = y;
        this.timeSpawn = timeSpawn;
        this.moveInterval = moveInterval;
        this.slowed = slowed;
        this.timeSlowed = timeSlowed;
        this.slowDuration = slowDuration;
    }

    
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void setTimeSpawn(int timeSpawn) {
        this.timeSpawn = timeSpawn;
    }
    public void setSlowed(boolean slowed) {
        this.slowed = slowed;
    }
    public void setTimeSlowed(int timeSlowed) {
        this.timeSlowed = timeSlowed;
    }
    public void setSlowDuration(int slowDuration) {
        this.slowDuration = slowDuration;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setAquatic(boolean aquatic) {
        this.aquatic = aquatic;
    }

    public int getMoveInterval() {
        return moveInterval;
    }
    public void setMoveInterval(int moveInterval) {
        this.moveInterval = moveInterval;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    @Override
    public void setHealth(int i) {
        health = i;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public int getDamage() {
        return damage;
    }

    public int getTimeSpawn() {
        return timeSpawn;
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public boolean isAquatic() {
        return aquatic;
    }

    @Override
    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void setTimeSpawn(){
        timeSpawn = Time.getTime().getTotalSeconds();
    }
    // @Override
    // public void attack() {
    //     // Implementasi serangan
    //     if ((Time.getTime().getTotalSeconds() - timeSpawn) % speed == 0) {
    //         if (Map.getMapInstance().getMapDetail()[x][y].isAdaTanaman()) {
    //             if (Map.getMapInstance().getMapDetail()[x][y].getPlant().getHealth() - damage > 0) {
    //                 Map.getMapInstance().getMapDetail()[x][y].getPlant().setHealth(Map.getMapInstance().getMapDetail()[x][y].getPlant().getHealth()-damage) ;
    //             }
    //             else {
    //                 Map.getMapInstance().getMapDetail()[x][y].plantDie();
    //             }
    //         }
    //     }
    // }
    
    // @Override
    // public void move() {
    //     if ((Time.getTime().getTotalSeconds() - timeSpawn) % 5 == 0) {
    //         // remove zombie di tile lama
    //         Map.getMapInstance().getMapDetail()[x][y].getZombieList().remove(this);
    //         // ubah koordinat
    //         y++;
    //         // tambah zombie di tile baru
    //         Map.getMapInstance().getMapDetail()[x][y].getZombieList().add(this);
    //     }
    // }
    @Override
    public void slowEffect() {
        while (!slowed) {
            speed = 2;
            moveInterval = 20;
            timeSlowed = Time.getTime().getTotalSeconds();
            slowed = true;
        }
    }

    @Override
    public void checkSlowEffect() {
        if (slowed && Time.getTime().getTotalSeconds() - timeSlowed >= slowDuration) {
            speed = 1;
            moveInterval = 10;
            slowed = false; 
        }
    }
}
