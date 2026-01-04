package people;

public class PetOwner extends Person {

    public PetOwner(String name, String tc) {
        super(name, tc);
    }

    @Override
    public void showMenu() {
        System.out.println("1- Make an Appointment");
        System.out.println("2- My Appointments");
        System.out.println("3- Add Pet");
        System.out.println("4- My Registered Pets");
        System.out.println("5- View Prescriptions");
    }
}