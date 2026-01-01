package people;

public class Veterinarian extends Employee {

    public Veterinarian(String id, String name, String email, String password, String department) {
        super(id, name, email, password, department);
    }

    @Override
    public void showRole() {
        System.out.println("Rol: VETERİNER");
    }
}

