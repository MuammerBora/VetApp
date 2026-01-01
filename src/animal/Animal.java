
package animal;
//Bu satır, Animal sınıfının animal paketine ait olduğunu belirtir.
// Projedeki hayvanla ilgili tüm sınıflar bu paket altında toplanır.
// Paketleme, kodun düzenli ve okunabilir olmasını sağlar.


import medical.MedicalRecord;
//Animal sınıfı, hayvanın tıbbi geçmişini tutmak için
//MedicalRecord sınıfını kullanacağı için bu import eklenmiştir.
// Böylece farklı paketler arasında bağlantı kurulmuş olur.


public abstract class Animal {
//Bu sınıf soyut (abstract) bir sınıftır.
// new Animal() ile nesne üretilemez.
//Sadece alt sınıflar tarafından miras alınmak için vardır
//(örneğin Dog, Cat, Bird).


    protected AnimalIdentity identity;
    //Hayvanın kimlik bilgilerini tutar.
    // protected olduğu için:
    //Alt sınıflar (Dog, Cat) erişebilir
    //Dışarıdan doğrudan erişilemez
    // Kimlik bilgileri ayrı bir sınıfta tutulur (AnimalIdentity).

    private MedicalRecord medicalRecord;
//Hayvanın tüm tıbbi geçmişini tutar.
// private yapılarak encapsulation (kapsülleme) sağlanmıştır.
// Dışarıdan doğrudan değiştirilemez, sadece metodlar aracılığıyla erişilir.


    public Animal(AnimalIdentity identity) {
        //Bu constructor, tüm hayvan türleri için ortak yapıcı metottur.
        // Her hayvan oluşturulurken kimlik bilgisi zorunlu olarak verilir.


        this.identity = identity;
        this.medicalRecord = new MedicalRecord(); // Tıbbi geçmiş başlatılır
    }
    //Hayvanın tıbbi geçmişine kontrollü erişim sağlar.
    // Veteriner veya sistem bu metot üzerinden kayıt ekleyebilir.

    public AnimalIdentity getIdentity() {
        return identity;
    }

    public MedicalRecord getMedicalRecord() {
        return medicalRecord;
    }

    public abstract String getAnimalType();

    public abstract String getName();
}
//Bu metod abstracttır.
// Her hayvan türü (Dog, Cat, Bird) bu metodu override etmek zorundadır.
// Bu sayede polymorphism uygulanır.



//Animal sınıfı ne sağlar?
//Abstract class ✔
//Encapsulation ✔
//Polymorphism altyapısı ✔
//Tüm hayvanlar için ortak yapı ✔