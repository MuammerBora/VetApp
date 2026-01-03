package medical;

import prescription.Prescription;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MedicalRecord {
    private ArrayList<MedicalOperation> pastOperations;
    private ArrayList<FutureOperation> futureOperations;
    private ArrayList<Prescription> prescriptions;

    public MedicalRecord() {
        this.pastOperations = new ArrayList<>();
        this.futureOperations = new ArrayList<>();
        this.prescriptions = new ArrayList<>();
    }

    public void addOperation(MedicalOperation op) {
        this.pastOperations.add(op);
        System.out.println("Operation added to records.");
    }

    public void showHistory() {
        System.out.println("\n--- MEDICAL HISTORY ---");
        if (pastOperations.isEmpty()) {
            System.out.println("No medical records found.");
        } else {
            for (MedicalOperation op : pastOperations) {
                op.printDetails();
                System.out.println("-----------------------");
            }
        }
    }

    public void addPrescription(Prescription p) {
        this.prescriptions.add(p);
        System.out.println("Prescription saved.");
        // İstersen reçete eklenir eklenmez dosyaya yazdırabilirsin:
        // p.printToFile();
    }

    public void showPrescriptions() {
        System.out.println("\n--- PRESCRIPTION HISTORY ---");
        if (prescriptions.isEmpty()) {
            System.out.println("No prescriptions found.");
        } else {
            for (Prescription p : prescriptions) {
                System.out.println(p.toString());
                System.out.println("----------------------------");
            }
        }
    }

    // --- YENİ EKLENEN KISIM: TÜM GEÇMİŞİ DOSYAYA DÖKME ---
    public void saveReportToFile(String animalName) {
        String fileName = "Rapor_" + animalName + ".txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("=== MEDICAL REPORT FOR: " + animalName + " ===\n\n");

            writer.write("--- OPERATIONS ---\n");
            for(MedicalOperation op : pastOperations) {
                // Burada basitçe toString gibi veri yazıyoruz
                writer.write("Operation Cost: " + op.cost + "\n");
            }

            writer.write("\n--- PRESCRIPTIONS ---\n");
            for(Prescription p : prescriptions) {
                writer.write(p.toString() + "\n");
            }

            System.out.println("📄 [FILE I/O] Tüm rapor kaydedildi: " + fileName);
        } catch (IOException e) {
            System.out.println("❌ Rapor kaydedilemedi.");
        }
    }
}