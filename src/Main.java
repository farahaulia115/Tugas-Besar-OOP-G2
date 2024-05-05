// Main.java
import Time.Time;
import Time.TimeThread;

public class Main {
    public static void main(String[] args) {
        Time time = new Time(0);
        TimeThread timeThread = new TimeThread(time);
        timeThread.start();

        // Cetak waktu dan fase saat ini
        System.out.println("Waktu saat ini: " + time.getTotalSeconds() + " detik");
        System.out.println("Fase saat ini: " + time.getCurrentPhase());

        // Simulasi penambahan waktu dan pemeriksaan status setiap 5 detik
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000); 
                System.out.println("Waktu saat ini: " + time.getTotalSeconds() + " detik");
                System.out.println("Fase saat ini: " + time.getCurrentPhase());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Menghentikan thread setelah pengujian selesai
        timeThread.stopThread();
    }
}
