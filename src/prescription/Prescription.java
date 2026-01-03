package prescription;

/*
ecotonic=kuşlar için vitamin
albadox=Antibiyotik(kuş için)-bütün kanatlılar için oluyor

Kortizan=iltihap giderici, bağışıklık güçlendirici,acil durumlarda hızlı etki
dodeks=iştahsızlık,yorgunluk,vitamin eksikliği
sylunox=geniş spektrumlu antibiyotik
Baytrill-k %5=antibiyotik
Pavet=ağrıkesici
Kemodur-K= demir takviyesi

3 lü test
gia, ccv, cpv.
tedavi yöntemi.(tedavi yöntemleri)

4 lü test tedavi yöntemi:-->Hemogram biyokimya-->röntgen ultrason(tedavisi için)
EHR, LSH, ANA, CHW.
otoskop:kulağın iç bakımı
*/


import people.Veterinarian;
import animal.Animal;
import java.io.BufferedWriter; // Dosya yazma kütüphanesi
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Prescription {
    private Veterinarian doctor;
    private Animal patient;
    private Medicine medicine;
    private Dosage dosage;
    private Date date;

    public Prescription(Veterinarian doctor, Animal patient, Medicine medicine, Dosage dosage) {
        this.doctor = doctor;
        this.patient = patient;
        this.medicine = medicine;
        this.dosage = dosage;
        this.date = new Date();
    }

    @Override
    public String toString() {
        return "=== PRESCRIPTION ===\n" +
                "Date: " + date + "\n" +
                "Doctor: " + doctor.getName() + "\n" +
                "Patient: " + patient.getName() + " (" + patient.getChipId() + ")\n" +
                "Medicine: " + medicine.getName() + "\n" +
                "Dosage: " + dosage.toString() + "\n";
    }

    // --- FILE PROCESSING KISMI (BUNU EKLEDİK) ---
    public void printToFile() {
        // Dosya ismi dinamik olsun: Reçete_Pamuk_ZamanDamgası.txt
        String fileName = "Recete_" + patient.getName() + "_" + System.currentTimeMillis() + ".txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(this.toString());
            System.out.println("📄 [FILE I/O] Reçete dosyaya yazdırıldı: " + fileName);
        } catch (IOException e) {
            System.out.println("❌ Dosya yazma hatası: " + e.getMessage());
        }
    }
}