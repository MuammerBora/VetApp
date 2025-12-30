package medical;

import animal.Animal;
import people.Veterinarian;

public class Vaccination extends MedicalOperation {
    // Aşı türü (Rabies, Parasite vb.)
    private String vaccineType;

    public Vaccination(Animal patient, Veterinarian doctor, String description, double cost, String vaccineType) {
        super(patient, doctor, description, cost);
        this.vaccineType = vaccineType;
    }

    @Override
    public void printReport() {
        // Aşıya özel rapor çıktısı
        System.out.println("[VACCINATION REPORT]");
        System.out.println("Patient: " + patient.getName());
        System.out.println("Vaccine Type: " + vaccineType);
        System.out.println("Details: " + description);
        System.out.println("Cost: $" + cost);
    }
}