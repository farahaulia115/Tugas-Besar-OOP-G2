// Time.java
package Time;

public class Time {
    private static int totalSeconds;

    public Time() {
        totalSeconds = 0;
    }
    public Time(int secondInitial) {
        totalSeconds = secondInitial;
    }

    public static int getTotalSeconds() {
        return totalSeconds;
    }

    public void setTotalSeconds(int totalSeconds) {
        Time.totalSeconds = totalSeconds;
    }

    // 200 jumlah second dalam satu hari
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
