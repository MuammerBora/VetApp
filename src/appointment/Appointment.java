package appointment;

import animal.Animal;
import people.Veterinarian;
import java.util.Date;

public class Appointment {
    private String appointmentId;
    private Date appointmentDate;
    private Animal patient;
    private Veterinarian doctor;
    private String reason; // Muayene mi, Aşı mı, Ameliyat mı?

    public Appointment(Animal patient, Veterinarian doctor, String reason) {
        this.appointmentId = "APP-" + (int)(Math.random() * 9000 + 1000);
        this.appointmentDate = new Date(); // Gerçek sistemde kullanıcıdan tarih alınır
        this.patient = patient;
        this.doctor = doctor;
        this.reason = reason;
    }

    // Getters
    public String getAppointmentId() { return appointmentId; }
    public Animal getPatient() { return patient; }
    public Veterinarian getDoctor() { return doctor; }
    public String getReason() { return reason; }

    @Override
    public String toString() {
        return "[" + appointmentId + "] Patient: " + patient.getName() +
                " | Doctor: " + doctor.getName() + " | Reason: " + reason;
    }
}