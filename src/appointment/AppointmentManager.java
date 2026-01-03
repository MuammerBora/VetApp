package appointment;
import people.Veterinarian;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

public class AppointmentManager {
    private List<Appointment> appointments = new ArrayList<>();

    //RANDEVU EKLEmek için kod (pet owner randevu alırken bu kod )
    public boolean addAppointment(Appointment a) {
        //çakışma durumunu kontrol ediyor eğer true dönerse çakışma var yani randevu ekleyemiyor
        if (hasConflict(a.getVetId(), a.getDate(), a.getTime())) {
            return false;
        }
        appointments.add(a);
        return true;
    }


    //çakışma kontrolü(private olarak tanımladım çünkü bu kod daha çok arkaplan)
    private boolean hasConflict(String vetId, LocalDate date, LocalTime time) {
        for (Appointment a : appointments) {
            if (Objects.equals(a.getVetId(), vetId)
                    && Objects.equals(a.getDate(), date)
                    && Objects.equals(a.getTime(), time)
                    && a.getStatus() != AppointmentStatus.CANCELLED) {
                return true;
            }
        }
        return false;
    }
    //RANDEVU İPTAL edildiği durumda(randevuyu iptal etmek için bu kod hekim de petowner da kullanabilir

    public boolean cancelAppointment(Appointment a) {

        if (a.getStatus() == AppointmentStatus.CANCELLED)
            return false;

        a.setStatus(AppointmentStatus.CANCELLED);
        return true;
    }


    //RANDEVU ONAY durumda(hekim onaylıyor )??
    public boolean approveAppointment(Appointment a, Veterinarian vet) {
        // Bu randevu bu hekime mi ait?
        if (!Objects.equals(a.getVetId(), vet.getId())) {
            return false;
        }

        // Sadece bekleyen randevu onaylanabilir
        if (a.getStatus() != AppointmentStatus.REQUESTED) {
            return false;
        }
        a.setStatus(AppointmentStatus.APPROVED);
        return true;
    }

    // gerçekleşen randevu
    public void completePastAppointments() {
        LocalDateTime now = LocalDateTime.now();

        for (Appointment a : appointments) {
            // İptal edilmişse dokunma
            if (a.getStatus() == AppointmentStatus.CANCELLED) {
                continue;
            }
//buraya gözat ?
            LocalDateTime appointmentTime =
                    LocalDateTime.of(a.getDate(), a.getTime());

            // Tarih-saat geçtiyse COMPLETED
            if (appointmentTime.isBefore(now)) {
                a.setStatus(AppointmentStatus.COMPLETED);
            }
        }
    }


    // RANDEVU LİSTeliyor (hekim de petowner da kullanabilir
    public List<Appointment> getAllAppointments() {
        return new ArrayList<>(appointments);
    }
}