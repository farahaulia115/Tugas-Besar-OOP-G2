package Plants;
import Map.*;
import Thread.Time;
import Zombie.Zombie;

public class Peashooter extends Plants implements Attack {
    public Peashooter() {
        setName("Peashooter");
        setCost(100);
        setHealth(100);
        setAttackDamage(25);
        setAttackSpeed(4);
        setRange(-1);
        setCooldown(10);
        setJumpable(true);
    }

    @Override
    public void attack(Zombie z) {
        z.setHealth(z.getHealth()-getAttackDamage());
    }
}
