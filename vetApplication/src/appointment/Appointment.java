package appointment;
import appointment.AppointmentStatus;
import java.time.LocalDate;
import java.time.LocalTime;

public class Appointment {

    private String vetTc;
    private String ownerTc;
    private String chipNumber;
    private LocalDate date;
    private LocalTime time;
    private AppointmentStatus status;

    public Appointment(String vetTc,
                       String ownerTc,
                       String chipNumber,
                       LocalDate date,
                       LocalTime time,
                       AppointmentStatus status) {

        this.vetTc = vetTc;
        this.ownerTc = ownerTc;
        this.chipNumber = chipNumber;
        this.date = date;
        this.time = time;
        this.status = status;
    }

    public String getVetTc() {
        return vetTc;
    }

    public String getOwnerTc() {
        return ownerTc;
    }

    public String getChipNumber() {
        return chipNumber;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public AppointmentStatus getStatus() {
        return status;
    }

    public void setStatus(AppointmentStatus status) {
        this.status = status;
    }
}