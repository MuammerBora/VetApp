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
        this.date = new Date(); // Şu anki zamanı alır
    }

    public void printPrescription() {
        // Ekrana basılan reçete formatı (İngilizce)
        System.out.println("=== PRESCRIPTION DETAILS ===");
        System.out.println("Date: " + date);
        System.out.println("Patient: " + patient.getName());
        // Doktor sınıfı hazır olunca aşağıdaki yorumu açabilirsin
        // System.out.println("Doctor: " + doctor.getName());
        System.out.println("Medicine: " + medicine.toString());
        System.out.println("Dosage: " + dosage.toString());
        System.out.println("============================");
    }
}