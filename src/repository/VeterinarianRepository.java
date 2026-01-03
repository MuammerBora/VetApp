package repository;

import people.Veterinarian;
import java.util.ArrayList;
import java.util.List;

public class VeterinarianRepository {

    private static List<Veterinarian> veterinarians = new ArrayList<>();

    static {
        // DÜZELTME: Başına 'veterinarians.add' ekledik. Yoksa listeye girmez.
        veterinarians.add(new Veterinarian("vet1", "Ahmet", "123", 50000.0, "DIP-001"));
    }

    public static List<Veterinarian> getAllVeterinarians() {
        return veterinarians;
    }

    public static Veterinarian getVeterinarianByIndex(int index) {
        if (index >= 0 && index < veterinarians.size()) {
            return veterinarians.get(index);
        }
        return null;
    }
}