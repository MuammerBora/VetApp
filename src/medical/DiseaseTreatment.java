package medical;

import animal.Animal;
import people.Veterinarian;
import prescription.Prescription;

public class DiseaseTreatment extends MedicalOperation {
    private String diseaseName;
    private Prescription prescription; // Reçete nesnesi

    public DiseaseTreatment(Animal patient, Veterinarian doctor, String description, double cost, String diseaseName) {
        super(patient, doctor, description, cost);
        this.diseaseName = diseaseName;
    }

    // Tedaviye sonradan reçete eklemek için setter metodu
    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }

    @Override
    public void printReport() {
        System.out.println("[DISEASE TREATMENT]");
        System.out.println("Diagnosis: " + diseaseName);
        System.out.println("Applied Procedure: " + description);

        if(prescription != null) {
            System.out.println("--> Prescription has been issued.");
            // İstersek reçeteyi de yazdırabiliriz: prescription.printPrescription();
        }
    }
}