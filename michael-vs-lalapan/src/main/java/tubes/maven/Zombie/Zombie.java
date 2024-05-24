package tubes.maven.Zombie;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = ConeheadZombie.class, name = "ConeheadZombie"),
    @JsonSubTypes.Type(value = DolphinriderZombie.class, name = "DolphinriderZombie"),
    @JsonSubTypes.Type(value = NormalZombie.class, name = "NormalZombie"),
    @JsonSubTypes.Type(value = BucketheadZombie.class, name = "BucketheadZombie"),
    @JsonSubTypes.Type(value = DuckytubeConeheadZombie.class, name = "DuckytubeConeheadZombie"),
    @JsonSubTypes.Type(value = PolevaultingZombie.class, name = "PolevaultingZombie"),
    @JsonSubTypes.Type(value = ScreendoorZombie.class, name = "ScreendoorZombie"),
    @JsonSubTypes.Type(value = FootballZombie.class, name = "FootballZombie"),
    @JsonSubTypes.Type(value = WallnutZombie.class, name = "WallnutZombie"),
    @JsonSubTypes.Type(value = DuckytubeZombie.class, name = "DuckytubeZombie"),
    
})

public interface Zombie {
    String getName();
    int getHealth();
    int getDamage();
    int getSpeed();
    int getTimeSpawn();
    boolean isAquatic();
    void setPosition(int x, int y);
    void setTimeSpawn();
    void setHealth(int i);
    void setMoveInterval(int moveInterval);
    int getMoveInterval();
    int getX();
    int getY();
    void setSpeed(int speed);
    void setAquatic(boolean aquatic);
    void setX(int x);
    void setY(int y);
    void setDamage(int damage);
    void slowEffect();
    void checkSlowEffect();
     
}
