package tubes.maven.Zombie;
import tubes.maven.Thread.Time;
import com.fasterxml.jackson.annotation.JsonTypeName;
@JsonTypeName("NormalZombie")
public class NormalZombie implements Zombie {
    private String name = "Normal Zombie";
    private int health = 125;
    private int damage = 100;
    private int speed = 1;
    private boolean aquatic = false;
    private int timeSpawn;
    private int x;
    private int y;
    private int moveInterval = 10;
    private boolean slowed = false;
    private int timeSlowed;
    private int slowDuration = 3;

    public NormalZombie() {
        this.timeSpawn = Time.getTime().getTotalSeconds();
    }

    public NormalZombie(String name, int health, int damage, int speed, boolean aquatic, int x, int y, int timeSpawn, int moveInterval, boolean slowed, int timeSlowed, int slowDuration) {
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
    public String getName() {
        return name;
    }
    @Override
    public void setHealth(int i) {
        health = i;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    public int getTimeSpawn() {
        return timeSpawn;
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
