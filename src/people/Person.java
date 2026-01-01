package people;

public abstract class Person {
    private String id;
    private String name;
    private String email;
    private String password;
// private olmaları encapsulation (kapsülleme) sağlar.
    public Person(String id, String name, String email, String password) {
        //Bu constructor, alt sınıflar tarafından çağrılır.
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }

    public boolean checkPassword(String input) {
        return password.equals(input);
    }
//Kullanıcının girdiği şifreyi kontrol eder.
//Giriş sistemi bu metodu kullanır.
//Şifre kontrolü tek merkezden yapılmış olur
    // POLYMORPHISM
    public abstract void showRole();
}
//Bu metod abstracttır.
//Her alt sınıf kendi rolünü yazmak zorundadır.
//Bu sayede polymorphism oluşur.

//Person sınıfı ne sağlar?
//Abstract class ✔
//Encapsulation ✔
//Polymorphism altyapısı ✔
//Tüm kullanıcıların ortak temeli ✔