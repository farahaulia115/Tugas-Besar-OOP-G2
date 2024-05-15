package Thread;

import Main.Sun;

public class Time implements Runnable {
    private static Time instance;
    private int totalSeconds;

    private Time() {
        totalSeconds = 0;
    }

    public static Time getTime() {
        if (instance == null) {
            instance = new Time();
        }
        return instance;
    }

    public int getTotalSeconds() {
        return totalSeconds;
    }

    public void setTotalSeconds(int totalSeconds) {
        this.totalSeconds = totalSeconds;
    }

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

    @Override
    public void run() {
        while (){
            try {
                Thread.sleep(1000); // Menghentikan thread selama 1 detik
                tick(); // Menambahkan waktu satu detik
                if (Time.getTime().getCurrentPhase().equalsIgnoreCase("Pagi")) {
                    if (Time.getTime().getTotalSeconds() % 25 == 0) {
                        Sun.increaseSun(25);
                    }
                } 
            } catch (Exception e) {
                Thread.currentThread().interrupt(); // Set the interrupt flag
            }
        }
    }
}
