package people;

public class Veterinarian extends Employee {
    private String diplomaNo;

    public Veterinarian(String id, String name, String password, double salary, String diplomaNo) {
        super(id, name, password, salary);
        this.diplomaNo = diplomaNo;
    }

    @Override
    public void showMenu() {
        System.out.println("\n--- VETERINARIAN MENU ---");
        System.out.println("1. Scan Chip (Animal Info)\n2. Write Prescription\n3. Give Appointment\n0. Logout");
    }
}