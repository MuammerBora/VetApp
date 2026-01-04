package chip;

import java.time.LocalDate;
import java.util.UUID;

public class Chip {

    private final String chipNumber;
    private final LocalDate registerDate;

    public Chip() {
        this.chipNumber = UUID.randomUUID().toString();
        this.registerDate = LocalDate.now();
    }

    public String getChipNumber() {
        return chipNumber;
    }

    public LocalDate getRegisterDate() {
        return registerDate;
    }

    @Override
    public String toString() {
        return "Chip No: " + chipNumber;
    }
}