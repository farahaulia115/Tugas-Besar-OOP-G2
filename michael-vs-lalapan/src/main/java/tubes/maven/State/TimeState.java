package tubes.maven.State;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TimeState {
    private int totalSeconds;
    private int day;
    public TimeState() {
        // Konstruktor default
    }
    // Constructor
    @JsonCreator
    public TimeState(@JsonProperty("totalSeconds") int totalSeconds, @JsonProperty("day") int day) {
        this.totalSeconds = totalSeconds;
        this.day = day;
    }

    // Getter and Setter for totalSeconds
    public int getTotalSeconds() {
        return totalSeconds;
    }

    public void setTotalSeconds(int totalSeconds) {
        this.totalSeconds = totalSeconds;
    }

    // Getter and Setter for day
    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}
