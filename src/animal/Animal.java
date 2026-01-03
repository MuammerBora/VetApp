package animal;

import chip.Chip;
import people.PetOwner;

public abstract class Animal {

    private String name;
    private int age;
    private double weight;
    private Gender gender;
    private String breed;
    private PetOwner owner;
    private Chip chip;

    public Animal(String name, int age, double weight, Gender gender, String breed, PetOwner owner) {

        if (age <= 0) {
            throw new IllegalArgumentException("Yaş 0 veya negatif olamaz.");
        }

        if (weight <= 0) {
            throw new IllegalArgumentException("Kilo 0 veya negatif olamaz.");
        }

        this.name = name;
        this.age = age;
        this.weight = weight;
        this.gender = gender;
        this.breed = breed;
        this.owner = owner;
        this.chip = new Chip();
    }

    public String getName() {
        return name;
    }

    public Chip getChip() {
        return chip;
    }

    public PetOwner getOwner() {
        return owner;
    }

    public abstract String getAnimalInfo();
}

//Animal sınıfı ne sağlar?
//Abstract class ✔
//Encapsulation ✔
//Polymorphism altyapısı ✔
//Tüm hayvanlar için ortak yapı ✔