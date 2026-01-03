package report;

import people.PetOwner;
import appointment.Appointment;
import java.util.List;

public class OwnerInfoReport implements Report {
    private String ownerId;
    private List<Appointment> appointments;

    public OwnerInfoReport(String ownerId, List<Appointment> appointments) {
        this.ownerId = ownerId;
        this.appointments = appointments;
    }

    @Override
    public String generate() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== SAHİP RAPORU ===\n");
        sb.append("Owner ID: ").append(ownerId).append("\n");

        int total = 0;
        if(appointments != null) total = appointments.size();

        sb.append("Total Appointments: ").append(total).append("\n");
        return sb.toString();
    }
}