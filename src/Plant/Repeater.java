package Plant;

import Main.Game;
import Thread.Time;
import Zombie.Zombie;

public class Repeater implements Plant, Attack{
    private String name = "Repeater";
    private int cost = 200;
    private int health = 100;
    private int attackDamage = 25;
    private int attackSpeed = 2;
    private int range = -1;
    private int cooldown = 10;
    private boolean jumpable = true;
    private int timeCreated;

    public Repeater() {
        this.timeCreated = Time.getTime().getTotalSeconds();
    }
    public int getTimePlantCreated() {
        return timeCreated;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setCost(int cost) {
        this.cost = cost;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }
    public void setRange(int range) {
        this.range = range;
    }
    public void setCooldown(int cooldown) {
        this.cooldown = cooldown;
    }

    public void setJumpable(boolean jumpable) {
        this.jumpable = jumpable;
    }

    // public void startRepeaterAttackThread (){
    //     Thread RepeaterAttackThread = new Thread(() -> {
    //         while (Game.getStatusGame()) {
    //             try {
    //                 Thread.sleep(attackSpeed * 100); // Tunggu interval produksi
    //                 attack();
    //             } catch (InterruptedException e) {
    //                 e.printStackTrace();
    //             }
    //         }
    //     });
    //     RepeaterAttackThread.start(); // Mulai thread
    // }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    public int getHealth() {
        return health;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public int getAttackSpeed() {
        return attackSpeed;
    }

    public int getRange() {
        return range;
    }

    public int getCooldown() {
        return cooldown;
    }

    public boolean isJumpable() {
        return jumpable;
    }

    public void attack() {
        
    }
    @Override
    public void attack(Zombie zombie) {
        zombie.setHealth(zombie.getHealth() - attackDamage);
    }

}
