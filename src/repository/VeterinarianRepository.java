package repository;

import people.Veterinarian;
import java.util.ArrayList;
import java.util.List;

public class VeterinarianRepository {

    private static List<Veterinarian> veterinarians = new ArrayList<>();

    static {
        veterinarians.add(new Veterinarian("Ayşe", "11111111111"));
        veterinarians.add(new Veterinarian("Ali",  "22222222222"));
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