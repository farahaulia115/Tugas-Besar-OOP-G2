package tubes.maven.Plant;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = SunFlower.class, name = "Sunflower"),
    @JsonSubTypes.Type(value = Peashooter.class, name = "Peashooter"),
    @JsonSubTypes.Type(value = Wallnut.class, name = "Wallnut"),
    @JsonSubTypes.Type(value = Lilypad.class, name = "Lilypad"),
    @JsonSubTypes.Type(value = Tallnut.class, name = "Tallnut"),
    @JsonSubTypes.Type(value = Squash.class, name = "Squash"),
    @JsonSubTypes.Type(value = Repeater.class, name = "Repeater"),
    @JsonSubTypes.Type(value = TangleKelp.class, name = "TangleKelp"),
    @JsonSubTypes.Type(value = SnowPea.class, name = "SnowPea"),
    @JsonSubTypes.Type(value = TwinSunFlower.class, name = "TwinSunFlower"),
})
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
