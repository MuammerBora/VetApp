package medical;

import java.util.ArrayList;

// Hayvanın sağlık karnesi (Bütün geçmişi burada tutulur)
public class MedicalRecord {
    private ArrayList<MedicalOperation> pastOperations;
    private ArrayList<FutureOperation> futureOperations;
    private ArrayList<String> allergies;

    public MedicalRecord() {
        this.pastOperations = new ArrayList<>();
        this.futureOperations = new ArrayList<>();
        this.allergies = new ArrayList<>();
    }

    // Listeye yeni bir işlem ekler (Polymorphism sayesinde her türlü işlem gelebilir)
    public void addOperation(MedicalOperation op) {
        this.pastOperations.add(op);
    }

    // Gelecek işlem ekler
    public void addFutureOperation(FutureOperation op) {
        this.futureOperations.add(op);
    }

    // Tüm geçmişi ekrana basar
    public void showHistory() {
        System.out.println("\n--- MEDICAL HISTORY ---");
        if (pastOperations.isEmpty()) {
            System.out.println("No medical records found.");
        } else {
            for (MedicalOperation op : pastOperations) {
                // Burada hangi sınıf geldiyse onun printReport() metodu çalışır
                op.printReport();
                System.out.println("-----------------------");
            }
        }
    }

    // Gelecek planları listeler
    public void showFuturePlans() {
        System.out.println("\n--- UPCOMING APPOINTMENTS ---");
        for (FutureOperation op : futureOperations) {
            System.out.println(op.toString());
        }
    }
}