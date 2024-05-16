package Zombie;
import Map.*;
import Thread.Time;

public class DuckytubeZombie implements Zombie {
    private String name = "Ducky Tube Zombie";
    private int health = 100;
    private int damage = 100;
    private int speed = 1;
    private boolean aquatic = true;
    private int timeSpawn;
    private int x;
    private int y;
    private int moveInterval = 5;

    public DuckytubeZombie() {
        this.timeSpawn = Time.getTime().getTotalSeconds();
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
}
