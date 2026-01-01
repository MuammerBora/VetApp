package main;

import people.PetOwner;
import animal.*;

public class Main {
    public static void main(String[] args) {

        PetOwner owner = new PetOwner("1", "Ali", "ali@mail.com", "123");

        AnimalIdentity id =
                new AnimalIdentity("Boncuk", 3, 5.2, Breed.MALTESE_TERRIER);

        Animal dog = new Dog(id);

        owner.addAnimal(dog);

        System.out.println("Hayvan başarıyla eklendi.");
    }
}
