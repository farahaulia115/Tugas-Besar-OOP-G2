package Time;

public class TimeThread extends Thread{
    private Time time;
    private volatile boolean running = true;


    
    public TimeThread(Time time){
        this.time = time;
    }
    
    public void stopThread(){
        running = false;
    }

    @Override
    public void run (){
        while (running) {
            try {
                Thread.sleep(1000); // Menghentikan thread selama 1 detik
                time.tick(); // Menambahkan waktu satu detik
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
