package medical;

import animal.Animal;
import people.Veterinarian;

public class Surgery extends MedicalOperation {
    private int durationMinutes; // Dakika cinsinden süre
    private boolean isAnesthesiaRequired;

    public Surgery(Animal patient, Veterinarian doctor, String description, double cost, int durationMinutes) {
        super(patient, doctor, description, cost);
        this.durationMinutes = durationMinutes;
        this.isAnesthesiaRequired = true; // Varsayılan olarak anestezi var
    }

    @Override
    public void printReport() {
        // Ameliyata özel rapor çıktısı
        System.out.println("[SURGERY REPORT]");
        System.out.println("Patient: " + patient.getName());
        System.out.println("Operation: " + description);
        System.out.println("Duration: " + durationMinutes + " minutes");
        System.out.println("Anesthesia: " + (isAnesthesiaRequired ? "Yes" : "No"));
    }
}