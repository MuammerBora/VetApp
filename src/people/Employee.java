package people;
//Employee nesnesi oluşturulamaz
//Sadece Veterinarian ve Assistant için temel olur
public abstract class Employee extends Person {
    protected String department;
//protected → alt sınıflar erişebilir
    public Employee(String id, String name, String email, String password, String department) {
        super(id, name, email, password);
        this.department = department;
    }
}
//super(...) ile Person constructor’ı çağrılır
//Böylece id, isim, email tekrar yazılmaz
//Inheritance düzgün kullanılır




//Employee sınıfı ne sağlar?
//Inheritance ✔
//Abstract class ✔
//Kod tekrarını azaltır