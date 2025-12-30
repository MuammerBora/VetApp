package prescription;

public class Dosage {
    // İlacın günde kaç kez kullanılacağı
    private int timesPerDay;

    // İlacın miktarı (mg cinsinden)
    private double amountMg;

    // Kullanım talimatı (Tok karnına vb.)
    private String instructions;

    public Dosage(int timesPerDay, double amountMg, String instructions) {
        this.timesPerDay = timesPerDay;
        this.amountMg = amountMg;
        this.instructions = instructions;
    }

    @Override
    public String toString() {
        // Çıktı İngilizce olmalı: "3x Daily, 500.0 mg (After meals)"
        return timesPerDay + "x Daily, " + amountMg + " mg (" + instructions + ")";
    }
}