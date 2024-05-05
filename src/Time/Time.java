// Time.java
package Time;

public class Time {
    private int totalSeconds;

    public Time(int secondInitial) {
        totalSeconds = secondInitial;
    }

    public int getTotalSeconds() {
        return totalSeconds;
    }

    public void setTotalSeconds(int totalSeconds) {
        this.totalSeconds = totalSeconds;
    }

    // 200 jumlah second dalam dua hari
    public int getDay() {
        return (totalSeconds / 200) + 1;
    }

    // nambahin totalSeconds setiap ada penambahan
    public void tick() {
        totalSeconds++;
    }

    public void increaseTime(int time) {
        totalSeconds += time;
    }

    public void decreaseTime(int time) {
        totalSeconds -= time;
    }

    public String getCurrentPhase() {
        if ((totalSeconds % 200) <= 100) {
            return "Pagi";
        } else {
            return "Malam";
        }
    }
}
