import Zombie.Zombie;
import Zombie.ZombieFactory;

public class Tes {
    public static void main(String[] args) {
        ZombieFactory zombieFactory = new ZombieFactory();
        Zombie zombie = zombieFactory.createZombie(1);
        System.out.println(zombie.getName());
        System.out.println(zombie.getHealth());
        System.out.println(zombie.getDamage());
        System.out.println(zombie.getSpeed());
        System.out.println(zombie.isAquatic());

        
  
    }
}
