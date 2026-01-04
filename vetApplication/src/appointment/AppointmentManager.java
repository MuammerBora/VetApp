package appointment;

import people.Veterinarian;
import java.util.List;

public class AppointmentManager {

    private final AppointmentFileStore fileStore;
    private final List<Appointment> appointments;

    public AppointmentManager(AppointmentFileStore fileStore) {
        this.fileStore = fileStore;
        // Dosyadaki eski kayıtları hafızaya yükle
        this.appointments = fileStore.loadAll();
    }

    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
        // Hem listeye hem dosyaya ekle
        fileStore.append(appointment);
    }

    public List<Appointment> getAllAppointments() {
        return appointments;
    }

    public void cancelAppointment(Appointment appointment) {
        appointment.setStatus(AppointmentStatus.CANCELLED);
        // Durum değiştiği için dosyayı güncelle
        fileStore.overwriteAll(appointments);
    }

    public void approveAppointment(Appointment appointment, Veterinarian vet) {
        appointment.setStatus(AppointmentStatus.APPROVED);
        // Gerekirse veteriner bilgisini de güncelleyebilirsin
        // appointment.setVetTc(vet.getTc());

        // Dosyayı güncelle
        fileStore.overwriteAll(appointments);
    }
}