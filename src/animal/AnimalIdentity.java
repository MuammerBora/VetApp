package animal;
//Hayvanın kimlik kartı gibi
public class AnimalIdentity {
    private String name;
    private int age;
    private double weight;
    private Breed breed;

    public AnimalIdentity(String name, int age, double weight, Breed breed) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.breed = breed;
    }
//Kimlik bilgileri tek seferde oluşturulur
//Hayvan kimliği sonradan parçalanmaz
    public String getName() { return name; }
    public int getAge() { return age; }
}
