package medical;

public class Checkup extends MedicalOperation {
    public Checkup(String description, double cost) {
        super(description, cost);
    }

    @Override
    public void printDetails() {
        System.out.println("[CHECK-UP] " + description + " - Cost: " + cost + " TL");
    }
}