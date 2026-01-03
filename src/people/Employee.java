package people;

public abstract class Employee extends Person {
    private double salary;

    public Employee(String id, String name, String password, double salary) {
        super(id, name, password);
        this.salary = salary;
    }
}