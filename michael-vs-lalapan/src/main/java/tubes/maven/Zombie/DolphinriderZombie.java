package tubes.maven.Zombie;
import tubes.maven.Map.*;
import tubes.maven.Thread.Time;

public class DolphinriderZombie implements Zombie, CanJump {
    private String name = "Dolphin Rider Zombie";
    private int health = 175;
    private int damage = 100;
    private int speed = 1;
    private boolean aquatic = true;
    private int timeSpawn;
    private int x;
    private int y;
    private boolean jumped;
    private boolean slowed = false;
    private int moveInterval = 10;
    private int timeSlowed;
    private int slowDuration = 3;


    public DolphinriderZombie() {
        this.timeSpawn = Time.getTime().getTotalSeconds();
        jumped = false;
    }
    @Override
    public void setHealth(int i) {
        health = i;
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
    public void jump() {
        // implementasi jump
        jumped = true;
    }

    @Override
    public boolean alreadyJumped(){
        return jumped;
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
