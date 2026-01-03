package report;

/**
 * WHY:
 * - Tüm raporlar bir "sözleşmeye" uysun
 * - Her rapor generate() metodu üretmek zorunda olsun
 * - Polymorphism göstermek için ideal
 */
public interface Report {

    /**
     * Her rapor kendine özgü bir çıktı üretir.
     */
    String generate();
}



package report;

import appointment.Appointment;
import appointment.AppointmentStatus;
import util.DateUtil;

import java.time.LocalDate;
import java.util.List;


//Günlük klinik raporu
// Randevu listesinden filtreleyerek çıktı üretir

public class DailyClinicReport implements Report {

    private final LocalDate date;
    private final List<Appointment> appointments;

    // WHY: Report nesnesi oluşturulurken ihtiyacı olan veriler verilir
    public DailyClinicReport(LocalDate date, List<Appointment> appointments) {
        this.date = date;
        this.appointments = appointments;
    }

    @Override
    public String generate() {
        StringBuilder sb = new StringBuilder();

        sb.append("=== GUNLUK KLINIK RAPORU ===\n");
        sb.append("Tarih: ").append(DateUtil.formatDate(date)).append("\n\n");

        int total = 0;
        int cancelled = 0;
        int completed = 0;

        for (Appointment a : appointments) {
            if (!date.equals(a.getDate())) continue;

            total++;

            if (AppointmentStatus.CANCELLED.equals(a.getStatus())) cancelled++;
            else if (AppointmentStatus.COMPLETED.equals(a.getStatus())) completed++;

            sb.append(DateUtil.formatTime(a.getTime())).append(" | ")
                    .append("Vet=").append(a.getVetId()).append(" | ")
                    .append("Pet=").append(a.getPetId()).append(" | ")
                    .append("Durum=").append(a.getStatus())
                    .append("\n");
        }

        sb.append("\nToplam: ").append(total)
                .append("\nTamamlanan: ").append(completed)
                .append("\nIptal: ").append(cancelled);

        return sb.toString();
    }
}



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

Burda ekstradan animalhistoryreport a gerek yok gibi geldi zaten neredeyse aynı bilgileri tutuyor ,Bu kısmı inceleyim aynı gibiyse eklemeyelim

package report;

import appointment.Appointment;
import util.DateUtil;

import java.util.List;

/**
 * WHY:
 * - Bir hayvanın tüm klinik geçmişini göstermek
 */
public class AnimalHistoryReport implements Report {

    private final String petId;
    private final List<Appointment> appointments;

    public AnimalHistoryReport(String petId, List<Appointment> appointments) {
        this.petId = petId;
        this.appointments = appointments;
    }

    @Override
    public String generate() {
        StringBuilder sb = new StringBuilder();

        sb.append("=== HAYVAN GECMISI ===\n");
        sb.append("Pet ID: ").append(petId).append("\n\n");

        int total = 0;

        for (Appointment a : appointments) {
            if (!petId.equals(a.getPetId())) continue;

            total++;

            sb.append(DateUtil.formatDate(a.getDate())).append(" ")
                    .append(DateUtil.formatTime(a.getTime()))
                    .append(" | Owner=").append(a.getOwnerId())
                    .append(" | Vet=").append(a.getVetId())
                    .append(" | Durum=").append(a.getStatus())
                    .append("\n");
        }

        sb.append("\nToplam ziyaret: ").append(total);
        return sb.toString();
    }
}