package Zombie;
import Map.*;
import Time.*;

public class BucketheadZombie implements Zombie {
    private String name = "Buckethead Zombie";
    private int health = 300;
    private int damage = 100;
    private int speed = 1;
    private boolean aquatic = false;
    private int timeSpawn;
    private int x;
    private int y;

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

    @Override
    public void attack() {
        // Implementasi serangan
        if ((Time.getTime().getTotalSeconds() - timeSpawn) % speed == 0) {
            if (Map.getMapInstance().getMapDetail()[x][y].isAdaTanaman()) {
                if (Map.getMapInstance().getMapDetail()[x][y].getPlant().getHealth() - damage > 0) {
                    Map.getMapInstance().getMapDetail()[x][y].getPlant().setHealth(Map.getMapInstance().getMapDetail()[x][y].getPlant().getHealth()-damage) ;
                }
                else {
                    Map.getMapInstance().getMapDetail()[x][y].plantDie();
                }
            }
        }
    }
    
    @Override
    public void move() {
        if ((Time.getTime().getTotalSeconds() - timeSpawn) % 5 == 0) {
            // remove zombie di tile lama
            Map.getMapInstance().getMapDetail()[x][y].getZombieList().remove(this);
            // ubah koordinat
            y++;
            // tambah zombie di tile baru
            Map.getMapInstance().getMapDetail()[x][y].getZombieList().add(this);
        }
    }
}
