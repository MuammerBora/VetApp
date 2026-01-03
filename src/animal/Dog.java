package animal;

public class Dog extends Animal {
    public Dog(String chipId, String name, int age, String breed) {
        super(chipId, name, age, breed);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " says: Woof Woof!");
    }
}