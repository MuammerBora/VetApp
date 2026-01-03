package people;

public class PetOwner extends Person {

    public PetOwner(String name, String tc) {
        super(name, tc);
    }

    @Override
    public void showMenu() {
        System.out.println("1- Randevu Al");
        System.out.println("2- Randevu Listem");
        System.out.println("3- Hayvan Ekle");
        System.out.println("4- Kayıtlı Hayvanlarım");
        System.out.println("5- Reçetelerim");
    }
}
//PetOwner sınıfı ne sağlar?
//Inheritance ✔
//Polymorphism ✔
//Collection kullanımı ✔