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
package prescription;

import people.Veterinarian;
import animal.Animal;
import java.io.BufferedWriter;
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
        // null kontrolü yapıyoruz ki hata vermesin
        String docName = (doctor != null) ? doctor.getName() : "Unknown Vet";
        String patName = (patient != null) ? patient.getName() : "Unknown Patient";

        return "=== PRESCRIPTION ===\n" +
                "Date: " + date + "\n" +
                "Doctor: " + docName + "\n" +
                "Patient: " + patName + "\n" +
                "Medicine: " + medicine.toString() + "\n" +
                "Dosage: " + dosage.toString() + "\n";
    }

    // --- DOSYAYA YAZDIRMA METODU ---
    public void printToFile() {
        String pName = (patient != null) ? patient.getName() : "Unknown";
        String fileName = "Recete_" + pName + "_" + System.currentTimeMillis() + ".txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(this.toString());
            System.out.println(" Reçete dosyaya yazdırıldı: " + fileName);
        } catch (IOException e) {
            System.out.println(" Dosya yazma hatası: " + e.getMessage());
        }
    }
}