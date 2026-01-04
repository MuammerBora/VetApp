package medical;

import animal.Animal;
import people.Veterinarian;

public abstract class DiseaseTreatment extends MedicalOperation {

    public DiseaseTreatment(Animal patient,
                            Veterinarian doctor,
                            String description,
                            double cost) {
        super(patient, doctor, description, cost);
    }

    @Override
    public void printDetails() {
        System.out.println(
                "[TREATMENT] " + description +
                        " | Patient: " + patient.getName() +
                        " | Doctor: " + doctor.getName() +
                        " | Cost: " + cost + " TL"
        );
    }
}