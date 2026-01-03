package people;

public abstract class Person {

    private String name;
    private String tc;

    public Person(String name, String tc) {

        if (tc == null || tc.length() != 11) {
            throw new IllegalArgumentException("TC kimlik numarası 11 haneli olmalıdır.");
        }

        this.name = name;
        this.tc = tc;
    }

    public String getName() {
        return name;
    }

    public String getTc() {
        return tc;
    }

    public boolean login(String tc) {
        return this.tc.equals(tc);
    }

    public abstract void showMenu();
}

//Person sınıfı ne sağlar?
//Abstract class ✔
//Encapsulation ✔
//Polymorphism altyapısı ✔
//Tüm kullanıcıların ortak temeli ✔