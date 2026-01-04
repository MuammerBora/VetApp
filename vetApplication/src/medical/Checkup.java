package medical;

import animal.Animal;
import people.Veterinarian;

public class Checkup extends MedicalOperation {

    public Checkup(Animal patient,
                   Veterinarian doctor,
                   String description,
                   double cost) {
        super(patient, doctor, description, cost);
    }

    @Override
    public void printReport() {

    }

    @Override
    public void printDetails() {
        System.out.println(
                "[CHECK-UP] " + description +
                        " | Patient: " + patient.getName() +
                        " | Doctor: " + doctor.getName() +
                        " | Cost: " + cost + " TL"
        );
    }
}