package chip;

import animal.Animal;
import java.util.HashMap;

public class ChipService {

    private HashMap<String, Animal> chipMap = new HashMap<>();

    public void registerChip(String chipId, Animal animal) {
        chipMap.put(chipId, animal);
    }

    public Animal findAnimalByChip(String chipId) {
        return chipMap.get(chipId);
    }
}
