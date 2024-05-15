package Zombie;
import Map.*;
import Thread.Time;

public class BucketheadZombie implements Zombie {
    private String name = "Buckethead Zombie";
    private int health = 300;
    private int damage = 100;
    private int speed = 1;
    private boolean aquatic = false;
    private int timeSpawn;
    private int x;
    private int y;

    public BucketheadZombie() {
        this.timeSpawn = Time.getTime().getTotalSeconds();
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int getTimeSpawn() {
        return timeSpawn;
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
    
}
