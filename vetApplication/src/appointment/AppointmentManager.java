package appointment;
import appointment.Appointment;
import appointment.AppointmentStatus;
import appointment.AppointmentFileStore;
import exception.AppointmentConflictException;
import people.Veterinarian;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AppointmentManager {

    private final List<Appointment> appointments;
    private final AppointmentFileStore store;

    public AppointmentManager(AppointmentFileStore store) {
        this.store = store;
        this.appointments = store.loadAll();
    }

    // ================= ADD =================

    public void addAppointment(Appointment a) throws AppointmentConflictException {
        checkConflict(a.getVetTc(), a.getDate(), a.getTime());
        appointments.add(a);
        store.append(a);
    }

    // ================= CONFLICT =================

    private void checkConflict(String vetTc, LocalDate date, LocalTime time) throws AppointmentConflictException {
        for (Appointment a : appointments) {
            if (Objects.equals(a.getVetTc(), vetTc)
                    && Objects.equals(a.getDate(), date)
                    && Objects.equals(a.getTime(), time)
                    && a.getStatus() != AppointmentStatus.CANCELLED) {

                throw new AppointmentConflictException(
                        "This veterinarian already has an appointment at this time.");
            }
        }
    }

    // ================= CANCEL =================

    public boolean cancelAppointment(Appointment a) {
        if (a.getStatus() == AppointmentStatus.CANCELLED) {
            return false;
        }
        a.setStatus(AppointmentStatus.CANCELLED);
        store.overwriteAll(appointments);
        return true;
    }

    // ================= APPROVE (NEW) =================

    public boolean approveAppointment(Appointment a, Veterinarian vet) {

        // Bu randevu bu veterinere mi ait?
        if (!a.getVetTc().equals(vet.getTc())) {
            return false;
        }

        // Sadece REQUESTED olan randevu onaylanır
        if (a.getStatus() != AppointmentStatus.REQUESTED) {
            return false;
        }

        a.setStatus(AppointmentStatus.APPROVED);
        store.overwriteAll(appointments);
        return true;
    }

    // ================= AUTO COMPLETE =================

    public void completePastAppointments() {
        LocalDateTime now = LocalDateTime.now();
        boolean changed = false;

        for (Appointment a : appointments) {
            if (a.getStatus() != AppointmentStatus.REQUESTED
                    && a.getStatus() != AppointmentStatus.APPROVED) {
                continue;
            }

            LocalDateTime appTime =
                    LocalDateTime.of(a.getDate(), a.getTime());

            if (appTime.isBefore(now)) {
                a.setStatus(AppointmentStatus.COMPLETED);
                changed = true;
            }
        }

        if (changed) {
            store.overwriteAll(appointments);
        }
    }

    // ================= LIST =================

    public List<Appointment> getAllAppointments() {
        return new ArrayList<>(appointments);
    }
}
