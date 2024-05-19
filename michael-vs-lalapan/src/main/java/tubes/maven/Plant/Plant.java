package tubes.maven.Plant;

public interface Plant {
    String getName();
    int getCost();
    int getHealth();
    int getAttackDamage();
    int getAttackSpeed();
    int getRange();
    int getCooldown();
    boolean isJumpable();
    void setName(String name);
    void setCost(int cost);
    void setHealth(int health);
    void setAttackDamage(int attackDamage);
    void setRange(int range);
    void setCooldown(int cooldown);
    int getTimePlantCreated();
    
}
