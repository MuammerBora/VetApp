package animal;

public class Dog extends Animal {
    public Dog(AnimalIdentity identity) {
        super(identity);
    }
//Animal constructor’ı çağrılır
//Kimlik bilgisi üst sınıfta tutulur
    @Override
    public String getAnimalType() {
        return "Köpek";
    }
}
