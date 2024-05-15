package Plants;

import Zombie.Zombie;

public class Repeater extends Plants implements Attack {
    public Repeater() {
        setName("Peashooter");
        setCost(200);
        setHealth(100);
        setAttackDamage(25);
        setAttackSpeed(2);
        setRange(-1);
        setCooldown(10);
        setJumpable(true);
    }
    @Override
    public void attack(Zombie zombie) {
        zombie.setHealth(zombie.getHealth()-getAttackDamage());
    }
}
