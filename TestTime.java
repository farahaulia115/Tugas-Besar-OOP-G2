import Time.*;

public class TestTime {
    public static void main(String[] args) {
        Time time = new Time(0); // Membuat objek Time dengan nilai awal 0 detik
        TimeThread timeThread = new TimeThread(time); // Membuat objek TimeThread dengan objek Time yang telah dibuat
        timeThread.start(); // Menjalankan thread

        // Menunggu beberapa saat untuk memberikan waktu kepada thread untuk berjalan
        try {
            Thread.sleep(5000); // Menunggu 5 detik
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Menghentikan thread
        timeThread.stopThread();

        // Menampilkan waktu setelah beberapa saat
        System.out.println("Waktu setelah 5 detik: " + time.getTotalSeconds() + " detik");
    }
}
