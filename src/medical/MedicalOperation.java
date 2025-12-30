package medical;

/*
kısırlaştırma:
kırık:
traş:
diş çekimi
sezaryan

 */



/*
ortalama olarak her şırınga başına(enjeksiyon başına) 200tl
ama kiloya göre değişiyor. 5 kiloya 1cc iken 15kg'a 3cc yapılır.
iç dış(parazit) hapları: ikisi beraber 1200tl, tekken iç 500 dış 700tl.
röntgen ultrason fiyatı 500tl
günlük kalma ücreti 1500tl
hemogram biyokimya 1500-3000tl arası
ortalama bir operasyon başına(kısırlaştırma bazlı):
dişi köpek=9000tl, dişi kedi:6000tl
erkek köpek=7000tl, erkek kedi:4000tl
iç dış parazit tasması( hangi hayvana takılırsa ona daha dikkatli davranılması gerekiyor. 6 ay kadar tasma etkisini gösteriyor. ücreti:3600tl(kiloya göre değişir

*/




import animal.Animal;
import people.Veterinarian;
import java.util.Date;

// ABSTRACT: Bu sınıftan nesne üretilemez, miras alınır.
public abstract class MedicalOperation {
    protected Animal patient;
    protected Veterinarian doctor;
    protected Date operationDate;
    protected String description;
    protected double cost;

    public MedicalOperation(Animal patient, Veterinarian doctor, String description, double cost) {
        this.patient = patient;
        this.doctor = doctor;
        this.description = description;
        this.cost = cost;
        this.operationDate = new Date();
    }

    public double getCost() { return cost; }

    // Abstract Metot: Alt sınıflar bu metodu (Rapor yazdırmayı) kendisi tanımlamak ZORUNDA.
    public abstract void printReport();
}