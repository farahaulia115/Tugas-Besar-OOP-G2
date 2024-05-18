package Zombie;
import Thread.Time;

public class ConeheadZombie implements Zombie {
    private String name = "Conehead Zombie";
    private int health = 250;
    private int damage = 100;
    private int speed = 1;
    private boolean aquatic = false;
    private int timeSpawn;
    private int x;
    private int y;
    private int moveInterval = 5;
    private boolean slowed = false;
    private int timeSlowed;
    private int slowDuration = 3;

    public ConeheadZombie() {
        this.timeSpawn = Time.getTime().getTotalSeconds();
    }

    @Override
    public String getName() {
        return name;
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

    @Override
    public boolean isAquatic() {
        return aquatic;
    }

    @Override
    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int getTimeSpawn() {
        return timeSpawn;
    }

    public void setTimeSpawn(){
        timeSpawn = Time.getTime().getTotalSeconds();
    }

    @Override
    public void setHealth(int i) {
        health = i;
    }
   
    @Override
    public void slowEffect() {
        while (!slowed) {
            speed = 2;
            moveInterval = 10;
            timeSlowed = Time.getTime().getTotalSeconds();
            slowed = true;
        }
    }

    @Override
    public void checkSlowEffect() {
        if (slowed && Time.getTime().getTotalSeconds() - timeSlowed >= slowDuration) {
            speed = 1;
            moveInterval = 5;
            slowed = false; 
        }
    }
}
