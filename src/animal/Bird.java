package animal;

public class Bird extends Animal {
    public Bird(String chipId, String name, int age, String breed) {
        super(chipId, name, age, breed);
    }

    @Override
    public void makeSound() {
        System.out.println("Cik cik cik!");
    }
}