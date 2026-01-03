package repository;

import appointment.Appointment;
import java.util.ArrayList;

public class AppointmentRepository {
    private static ArrayList<Appointment> allAppointments = new ArrayList<>();

    public static void addAppointment(Appointment app) {
        allAppointments.add(app);
    }

    public static ArrayList<Appointment> getAllAppointments() {
        return allAppointments;
    }

    // Sadece belirli bir hekime ait randevuları filtrelemek için
    public static ArrayList<Appointment> getAppointmentsForVet(String vetId) {
        ArrayList<Appointment> vetApps = new ArrayList<>();
        for (Appointment a : allAppointments) {
            if (a.getDoctor().getId().equals(vetId)) {
                vetApps.add(a);
            }
        }
        return vetApps;
    }
}