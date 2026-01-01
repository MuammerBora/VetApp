package people;

import java.util.ArrayList;
import animal.Animal;

public class PetOwner extends Person {

    private ArrayList<Animal> animals = new ArrayList<>();
//Hasta sahibinin sahip olduğu hayvanlar tutulur
    public PetOwner(String id, String name, String email, String password) {
        super(id, name, email, password);
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }
//Sahibe yeni hayvan ekler
//Hayvan–sahip ilişkisi burada kurulur
    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    @Override
    public void showRole() {
        System.out.println("Rol: HASTA SAHİBİ");
    }
}

//Person’daki abstract metod burada override edilir
//Polymorphism çalışır

//PetOwner sınıfı ne sağlar?
//Inheritance ✔
//Polymorphism ✔
//Collection kullanımı ✔