package people;

public class Assistant extends Employee {

    public Assistant(String id, String name, String email, String password, String department) {
        super(id, name, email, password, department);
    }

    @Override
    public void showRole() {
        System.out.println("Rol: ASİSTAN");
    }
}
