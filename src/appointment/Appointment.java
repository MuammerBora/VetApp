package appointment;

import java.time.LocalDate;
import java.time.LocalTime;

public class Appointment {
    //private Veterinarian veterinarian;
    private String ownerId;
    private String vetId;
    private String petId;

    private LocalDate date;
    private LocalTime time;
    private String status;

    public Appointment(String ownerId, String vetId,
                       LocalDate date, LocalTime time, String status){
        this.ownerId=ownerId;
        this.vetId=vetId;
        this.date=date;
        this.time=time;
        this.status=status;

    }
    public Appointment(String ownerId, String vetId,String petId
                       LocalDate date, LocalTime time, String status) {
        this.ownerId = ownerId;
        this.vetId = vetId;
        this.date = date;
        this.time = time;
        this.status = status;
        this.petId = petId;
    }

    //getter-setter metodları

    public String getPetId() {
        return petId;
    }
    public String getOwnerId() {
        return ownerId;
    }
    public boolean getVetId() {
        return vetId;
    }

    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }
    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(AppointmentStatus status) {
        this.status = status;
    }


}