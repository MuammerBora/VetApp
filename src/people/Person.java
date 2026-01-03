package people;

// ABSTRACT CLASS: Bu sınıftan doğrudan nesne üretilemez, şablon görevi görür.
public abstract class Person {
    private String id; // TC veya Kimlik No
    private String name;
    private String password;

    public Person(String id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    // ENCAPSULATION: private değişkenlere erişim için Getter/Setter kullanımı.
    public String getId() { return id; }
    public String getName() { return name; }
    public String getPassword() { return password; }

    // POLYMORPHISM: Her alt sınıf bu metodu kendine göre dolduracak.
    public abstract void showMenu();
}