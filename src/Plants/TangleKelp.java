package Plants;
import Zombie.Zombie;
import Map.NotShovelableException;
import Map.Tile;

public class TangleKelp extends Plants implements Attack, SelfDestruct {
    public TangleKelp() {
        setName("Tangle Kelp");
        setCost(50);
        setHealth(100);
        setAttackDamage(5000);
        setAttackSpeed(0);
        setRange(1);
        setCooldown(20);
        setJumpable(true);
    }

    @Override
    public void attack(Zombie z) {
        z.setHealth(z.getHealth()-getAttackDamage());
        selfDestruct(tile);
    }

    @Override
    public void selfDestruct(Tile tile) {
        try {
            tile.gali();
        } catch (NotShovelableException e) {
            e.printStackTrace();
        }
    }
}