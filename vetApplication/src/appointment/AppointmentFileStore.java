package appointment;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class AppointmentFileStore {

    // Dosya yolu bulma mantığımız (Aynı kalıyor)
    private static final String FILE_NAME_DEFAULT = "appointments.txt";
    private static final String FILE_NAME_NESTED = "vetApplication/appointments.txt";

    private final String fileName;

    public AppointmentFileStore(String fileNameIgnored) {
        this.fileName = getFilePath();
    }

    private String getFilePath() {
        File file = new File(FILE_NAME_DEFAULT);
        if (file.exists()) {
            return FILE_NAME_DEFAULT;
        }
        File nestedFile = new File(FILE_NAME_NESTED);
        if (nestedFile.exists()) {
            return FILE_NAME_NESTED;
        }
        return FILE_NAME_DEFAULT;
    }

    // --- İŞTE DÜZELTİLEN KISIMLAR ---

    // Eskiden 'add' idi, şimdi 'append' oldu
    public void append(Appointment appointment) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(appointment.getChipNumber() + "," +
                    appointment.getVetTc() + "," +
                    appointment.getOwnerTc() + "," +
                    appointment.getDate() + "," +
                    appointment.getTime() + "," +
                    appointment.getStatus());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("❌ Appointment file write error: " + e.getMessage());
        }
    }

    // Eskiden 'getAll' idi, şimdi 'loadAll' oldu
    public List<Appointment> loadAll() {
        List<Appointment> appointments = new ArrayList<>();
        File file = new File(fileName);

        if (!file.exists()) {
            // Dosya yoksa boş liste dön, hata verme
            return appointments;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                // Basit bir koruma: Satırda eksik bilgi varsa atla
                if (parts.length >= 6) {
                    appointments.add(new Appointment(
                            parts[2], // OwnerTC
                            parts[1], // VetTC
                            parts[0], // Chip
                            LocalDate.parse(parts[3]),
                            LocalTime.parse(parts[4]),
                            AppointmentStatus.valueOf(parts[5])
                    ));
                }
            }
        } catch (IOException e) {
            System.out.println("❌ Appointment file read error.");
        }
        return appointments;
    }

    // Eskiden 'update' idi, şimdi 'overwriteAll' oldu
    public void overwriteAll(List<Appointment> appointments) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Appointment appointment : appointments) {
                writer.write(appointment.getChipNumber() + "," +
                        appointment.getVetTc() + "," +
                        appointment.getOwnerTc() + "," +
                        appointment.getDate() + "," +
                        appointment.getTime() + "," +
                        appointment.getStatus());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("❌ File overwrite error: " + e.getMessage());
        }
    }
}