package prescription;

public class Dosage {
    private int timesPerDay;
    private int quantity;
    private String duration; // örn: "1 Week"

    public Dosage(int timesPerDay, int quantity, String duration) {
        this.timesPerDay = timesPerDay;
        this.quantity = quantity;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return quantity + "x " + timesPerDay + " times/day for " + duration;
    }
}