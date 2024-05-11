// Time.java
package Time;

public class Time {
    private static Time time = null;
    private int totalSeconds;

    private Time() {
        totalSeconds = 0;
    }

    public int getTotalSeconds() {
        return totalSeconds;
    }

    public static Time getTime(){
        if (time == null){
            return new Time();
        }
        return time;
    }
    
    public void setTotalSeconds(int totalSeconds) {
        this.totalSeconds = totalSeconds;
    }

    // 200 jumlah second dalam satu hari

    
    // public static int getDay() {
    //     return (this.totalSeconds / 200) + 1;
    // }

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
