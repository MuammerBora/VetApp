package people;

import java.util.ArrayList;
import animal.Animal;

public class PetOwner extends Person {
    private ArrayList<Animal> pets; // COMPOSITION: Bir sahibin birden fazla hayvanı olabilir.

    public PetOwner(String id, String name, String password) {
        super(id, name, password);
        this.pets = new ArrayList<>();
    }

    public void addPet(Animal animal) { pets.add(animal); }
    public ArrayList<Animal> getPets() { return pets; }

    @Override
    public void showMenu() {
        System.out.println("\n--- PET OWNER MENU ---");
        System.out.println("1. My Animals & History\n2. Get Appointment\n3. Profile Info\n0. Logout");
    }
}