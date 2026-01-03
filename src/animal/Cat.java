package animal;

import people.PetOwner;

public class Cat extends Animal {

    public Cat(String name, int age, double weight, Gender gender, String breed, PetOwner owner) {
        super(name, age, weight, gender, breed, owner);
    }

    @Override
    public String getAnimalInfo() {
        return "Kedi: " + getName();
    }
}