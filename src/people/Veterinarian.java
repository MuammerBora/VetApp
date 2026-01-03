package people;

public class Veterinarian extends Person {

    public Veterinarian(String name, String tc) {
        super(name, tc);
    }

    @Override
    public void showMenu() {
        System.out.println("1- Kayıtlı Randevular");
        System.out.println("2- Kayıtlı Hayvanlar");
        System.out.println("3- Operasyon Geçmişi");
        System.out.println("4- Operasyon Ekle");
        System.out.println("5- İlaç Yaz");
    }
}