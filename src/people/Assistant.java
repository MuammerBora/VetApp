package people;

public class Assistant extends Employee {
    public Assistant(String id, String name, String password, double salary) {
        super(id, name, password, salary);
    }

    @Override
    public void showMenu() {
        System.out.println("--- ASSISTANT MENU ---");
        System.out.println("1. View Schedule");
        System.out.println("0. Logout");
    }
}
