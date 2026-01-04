package appointment;
import appointment.Appointment;
import appointment.AppointmentStatus;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class AppointmentFileStore {

    private final Path filePath;

    public AppointmentFileStore(String fileName) {
        this.filePath = Paths.get(fileName);
        ensureFileExists();
    }

    private void ensureFileExists() {
        try {
            if (!Files.exists(filePath)) {
                Files.createFile(filePath);
            }
        } catch (IOException e) {
            throw new RuntimeException("File could not be created", e);
        }
    }

    public List<Appointment> loadAll() {
        List<Appointment> list = new ArrayList<>();

        try (BufferedReader br = Files.newBufferedReader(filePath)) {
            String line;

            while ((line = br.readLine()) != null) {
                if (line.isBlank()) continue;

                // vetTc,ownerTc,chip,date,time,status
                String[] p = line.split(",");
                if (p.length != 6) continue;

                Appointment a = new Appointment(
                        p[0],
                        p[1],
                        p[2],
                        LocalDate.parse(p[3]),
                        LocalTime.parse(p[4]),
                        AppointmentStatus.valueOf(p[5])
                );

                list.add(a);
            }
        } catch (IOException e) {
            throw new RuntimeException("File read error", e);
        }

        return list;
    }

    public void append(Appointment a) {
        try (BufferedWriter bw = Files.newBufferedWriter(
                filePath, StandardOpenOption.APPEND)) {

            bw.write(toLine(a));
            bw.newLine();

        } catch (IOException e) {
            throw new RuntimeException("File write error", e);
        }
    }

    public void overwriteAll(List<Appointment> appointments) {
        try (BufferedWriter bw = Files.newBufferedWriter(
                filePath, StandardOpenOption.TRUNCATE_EXISTING)) {

            for (Appointment a : appointments) {
                bw.write(toLine(a));
                bw.newLine();
            }

        } catch (IOException e) {
            throw new RuntimeException("File update error", e);
        }
    }

    private String toLine(Appointment a) {
        return a.getVetTc() + "," +
                a.getOwnerTc() + "," +
                a.getChipNumber() + "," +
                a.getDate() + "," +
                a.getTime() + "," +
                a.getStatus().name();
    }
}
