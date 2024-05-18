package Zombie;
import Thread.Time;

public class FootballZombie implements Zombie{
    private String name = "Football Zombie";
    private int health = 300;
    private int damage = 150;
    private int speed = 1;
    private boolean aquatic = false;
    private int timeSpawn;
    private int x;
    private int y;
    private int moveInterval = 5;
    private boolean slowed = false;
    private int timeSlowed;
    private int slowDuration = 3;

    public FootballZombie() {
        this.timeSpawn = Time.getTime().getTotalSeconds();
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int getMoveInterval() {
        return moveInterval;
    }
    public void setMoveInterval(int moveInterval) {
        this.moveInterval = moveInterval;
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
