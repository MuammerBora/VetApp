package appointment;

import exception.DuplicateAppointmentException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AppointmentService {

    private List<Appointment> appointments = new ArrayList<>();

    public void addAppointment(Appointment appointment) {
        checkConflict(appointment.getDateTime());
        appointments.add(appointment);
    }

    private void checkConflict(LocalDateTime dateTime) {
        for (Appointment a : appointments) {
            if (a.getDateTime().equals(dateTime)) {
                throw new DuplicateAppointmentException(
                        "There is already an appointment at this date and time."
                );
            }
        }
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }
}