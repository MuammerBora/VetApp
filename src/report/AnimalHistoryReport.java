package report;

import animal.Animal;
import medical.MedicalOperation;

public class AnimalHistoryReport implements Report {
    private Animal animal;

    public AnimalHistoryReport(Animal animal) {
        this.animal = animal;
    }

    @Override
    public String generate() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== ANIMAL MEDICAL REPORT ===\n");
        sb.append("Patient: ").append(animal.getName()).append("\n");
        sb.append("Chip ID: ").append(animal.getChipId()).append("\n");
        sb.append("-----------------------------\n");
        // Burada MedicalRecord'a erişip işlemleri yazdırabiliriz
        // Şimdilik basit tutalım:
        sb.append("Total Operations: ").append("Check Medical Record").append("\n");
        return sb.toString();
    }
}