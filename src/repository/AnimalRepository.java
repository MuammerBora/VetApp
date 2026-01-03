package repository;

import animal.Animal;
import java.util.ArrayList;

public class AnimalRepository {
    // Statik liste: Program çalıştığı sürece tüm hayvanlar burada toplanır.
    private static ArrayList<Animal> allRegisteredAnimals = new ArrayList<>();

    // Yeni hayvan ekleme metodu
    public static void addAnimal(Animal animal) {
        allRegisteredAnimals.add(animal);
    }

    // Çip numarasına göre arama (Hekimin kullandığı kısım)
    public static Animal findByChipId(String chipId) {
        for (Animal a : allRegisteredAnimals) {
            if (a.getChipId().equalsIgnoreCase(chipId)) {
                return a;
            }
        }
        return null;
    }

    // Ekstra: Sistemdeki tüm hayvanları görmek için (Opsiyonel)
    public static ArrayList<Animal> getAllAnimals() {
        return allRegisteredAnimals;
    }
}