package Plant;

public  interface Plant {
    String getName();
    int getCost();
    int getHealth();
    int getAttackDamage();
    int getAttackSpeed();
    int getRange();
    int getCooldown();
    boolean isJumpable();
    void attack();
}
