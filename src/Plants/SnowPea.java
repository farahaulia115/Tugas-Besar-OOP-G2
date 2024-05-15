package Plants;

import Zombie.Zombie;

public class SnowPea extends Plants implements Attack {
    public SnowPea() {
        setName("Snow Pea");
        setCost(175);
        setHealth(100);
        setAttackDamage(25);
        setAttackSpeed(4);
        setRange(-1);
        setCooldown(10);
        setJumpable(true);
    }
    @Override
    public void attack(Zombie zombie) {
        zombie.setHealth(zombie.getHealth()-getAttackDamage());
    }
}
