package report;

import appointment.Appointment;
import util.DateUtil;

import java.util.List;

/**
 * WHY:
 * - Belirli bir owner'ın randevu geçmişini gösterir
 */
public class OwnerInfoReport implements Report {

    private final String ownerId;
    private final List<Appointment> appointments;

    public OwnerInfoReport(String ownerId, List<Appointment> appointments) {
        this.ownerId = ownerId;
        this.appointments = appointments;
    }

    @Override
    public String generate() {
        StringBuilder sb = new StringBuilder();

        sb.append("=== SAHIP RAPORU ===\n");
        sb.append("Owner ID: ").append(ownerId).append("\n\n");

        int total = 0;

        for (Appointment a : appointments) {
            if (!ownerId.equals(a.getOwnerId())) continue;

            total++;

            sb.append(DateUtil.formatDate(a.getDate())).append(" ")
                    .append(DateUtil.formatTime(a.getTime()))
                    .append(" | Vet=").append(a.getVetId())
                    .append(" | Pet=").append(a.getPetId())
                    .append(" | Durum=").append(a.getStatus())
                    .append("\n");
        }

        sb.append("\nToplam randevu: ").append(total);
        return sb.toString();
    }
}