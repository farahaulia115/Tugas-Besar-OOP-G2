package tubes.maven.State;

public class SunState {
    private int amount;
    public SunState() {
        // Konstruktor default
    }
    // Constructor
    public SunState(int amount) {
        this.amount = amount;
    }

    // Getter and Setter for amount
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}

