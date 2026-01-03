package medical;

import prescription.Prescription;
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

    // OPERASYON EKLEME
    public void addOperation(MedicalOperation op) {
        this.pastOperations.add(op);
        System.out.println("Operation added to records.");
    }

    // OPERASYON GEÇMİŞİ
    public void showHistory() {
        System.out.println("\n--- MEDICAL HISTORY ---");
        if (pastOperations.isEmpty()) {
            System.out.println("No medical records found.");
        } else {
            for (MedicalOperation op : pastOperations) {
                // DÜZELTME 1: printReport() yerine printDetails() yapıldı.
                // Çünkü MedicalOperation sınıfında metodun adı printDetails.
                op.printDetails();
                System.out.println("-----------------------");
            }
        }
    }

    // İLAÇ YAZMA
    public void addPrescription(Prescription p) {
        this.prescriptions.add(p);
        System.out.println("Prescription saved.");
    }

    // REÇETE GÖRME
    public void showPrescriptions() {
        System.out.println("\n--- PRESCRIPTION HISTORY ---");
        if (prescriptions.isEmpty()) {
            System.out.println("No prescriptions found.");
        } else {
            // DÜZELTME 2: Burası eksikti, reçeteleri yazdıran döngüyü ekledim.
            for (Prescription p : prescriptions) {
                System.out.println(p.toString());
                System.out.println("----------------------------");
            }
        }
    }
}