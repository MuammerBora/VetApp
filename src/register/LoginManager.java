package register;

import people.*;
import java.util.ArrayList;
import java.util.Scanner;

public class LoginManager {
    // Veritabanı niyetine tüm kullanıcıları tutan liste
    private static ArrayList<Person> allUsers = new ArrayList<>();

    static {
        // Test verileri
        allUsers.add(new Veterinarian("admin", "Dr. Bora", "1234", 50000, "VET-001"));
        allUsers.add(new PetOwner("111", "Ahmet Yilmaz", "111"));
    }

    public static void register(Scanner sc) {
        System.out.println("\n--- REGISTER ---");
        System.out.print("ID (TC No): ");
        String id = sc.next();
        System.out.print("Name: ");
        String name = sc.next();
        System.out.print("Password: ");
        String pass = sc.next();

        allUsers.add(new PetOwner(id, name, pass));
        System.out.println("Registration successful! You can login now.");
    }

    public static Person login(String id, String pass) {
        for (Person p : allUsers) {
            if (p.getId().equals(id) && p.getPassword().equals(pass)) {
                return p; // Giriş başarılı
            }
        }
        return null; // Giriş başarısız
    }
}