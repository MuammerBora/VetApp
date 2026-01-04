package animal;
import animal.Animal;
import animal.Gender ;
import people.PetOwner;

public class Dog extends Animal {

    public Dog(String name, int age, double weight, Gender gender, String breed, PetOwner owner) {
        super(name, age, weight, gender, breed, owner);
    }

    @Override
    public String getAnimalInfo() {
        return "Dog: " + getName();
    }
}