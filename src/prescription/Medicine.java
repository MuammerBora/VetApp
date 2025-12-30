package prescription;

public class Medicine {
    private String name;
    private String type; // Antibiotic, Painkiller vb.
    private double price;

    public Medicine(String name, String type, double price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }

    // Kapsülleme (Encapsulation) için Getter metodları
    public String getName() { return name; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return name + " (" + type + ")";
    }
}