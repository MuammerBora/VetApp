package animal;

public class Cat extends Animal {
    public Cat(String chipId, String name, int age, String breed) {
        super(chipId, name, age, breed);
    }

    @Override
    public void makeSound() {
        System.out.println("Meow meow!");
    }
}