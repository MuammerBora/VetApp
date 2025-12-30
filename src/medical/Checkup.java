package medical;

/*
chechkup=Hemogram biyokimya
 */

import animal.Animal;
import people.Veterinarian;

public class Checkup extends MedicalOperation {
    // Sağlık durumu (Stable, Critical, Healthy vb.)
    private String healthStatus;

    public Checkup(Animal patient, Veterinarian doctor, String description, double cost, String healthStatus) {
        super(patient, doctor, description, cost);
        this.healthStatus = healthStatus;
    }

    @Override
    public void printReport() {
        // Genel muayene raporu
        System.out.println("[GENERAL CHECKUP]");
        System.out.println("Patient: " + patient.getName());
        System.out.println("Status: " + healthStatus);
        System.out.println("Notes: " + description);
    }
}