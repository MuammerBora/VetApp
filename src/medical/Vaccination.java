package medical;

public class Vaccination extends MedicalOperation {
    private String vaccineType;

    public Vaccination(String description, double cost, String vaccineType) {
        super(description, cost);
        this.vaccineType = vaccineType;
    }

    @Override
    public void printDetails() {
        System.out.println("[VACCINATION] Type: " + vaccineType + " | Cost: " + cost);
    }
}