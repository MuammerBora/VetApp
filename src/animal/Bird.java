package animal;

public class Bird extends Animal {

    public Bird(AnimalIdentity identity) {
        super(identity);
    }

    @Override
    public String getAnimalType() {
        return "BIRD";
    }
}

