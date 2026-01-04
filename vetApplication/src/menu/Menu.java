package menu;

import animal.*;
import appointment.*;
import prescription.*;
import medical.*;

import people.PetOwner;
import people.Veterinarian;
import repository.AnimalFileRepository;
import repository.VeterinarianRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private final Scanner sc = new Scanner(System.in);

    // Appointment altyapısı
    private final AppointmentManager appointmentManager =
            new AppointmentManager(new AppointmentFileStore("appointments.txt"));

    // ================= START =================

    public void start() {
        while (true) {
            System.out.println("\n=== SELECT ROLE ===");
            System.out.println("1- Pet Owner");
            System.out.println("2- Veterinarian");
            System.out.println("3- Exit");
            System.out.print("Choice: ");

            switch (sc.nextLine()) {
                case "1" -> petOwnerAuth();
                case "2" -> veterinarianAuth();
                case "3" -> {
                    System.out.println("Goodbye.");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    // ================= PET OWNER AUTH =================

    private void petOwnerAuth() {
        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("TC: ");
        String tc = sc.nextLine();

        try {
            PetOwner owner = new PetOwner(name, tc);
            petOwnerMenu(owner);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    // ================= PET OWNER MENU =================

    private void petOwnerMenu(PetOwner owner) {
        while (true) {
            System.out.println("\n=== PET OWNER MENU ===");
            System.out.println("1- Register Animal");
            System.out.println("2- List My Animals");
            System.out.println("3- Create Appointment");
            System.out.println("4- View My Appointments");
            System.out.println("5- Cancel Appointment");
            System.out.println("6- Logout");

            switch (sc.nextLine()) {
                case "1" -> registerAnimal(owner);
                case "2" -> listAnimals(owner);
                case "3" -> createAppointment(owner);
                case "4" -> listOwnerAppointments(owner);
                case "5" -> cancelAppointment(owner.getTc());
                case "6" -> { return; }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    // ================= ANIMAL =================

    private void registerAnimal(PetOwner owner) {
        try {
            System.out.print("Animal type (CAT/DOG/BIRD): ");
            String type = sc.nextLine().toUpperCase();

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Age: ");
            int age = Integer.parseInt(sc.nextLine());

            System.out.print("Weight: ");
            double weight = Double.parseDouble(sc.nextLine());

            System.out.print("Gender (MALE/FEMALE): ");
            Gender gender = Gender.valueOf(sc.nextLine().toUpperCase());

            System.out.print("Breed: ");
            String breed = sc.nextLine();

            Animal animal = switch (type) {
                case "CAT" -> new Cat(name, age, weight, gender, breed, owner);
                case "DOG" -> new Dog(name, age, weight, gender, breed, owner);
                default -> null;
            };

            if (animal == null) {
                System.out.println("Invalid animal type.");
                return;
            }

            // Çip numarasını otomatik ata veya sor (Dosya formatına uyması için)
            // Arkadaşların sisteminde AnimalIdentity otomatik atanıyor olabilir
            // Biz şimdilik kaydı yapalım:
            AnimalFileRepository.saveAnimal(animal);
            System.out.println("Animal registered successfully.");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void listAnimals(PetOwner owner) {
        System.out.println("\n=== MY ANIMALS ===");

        AnimalFileRepository.readAllAnimals().stream()
                .filter(line -> line.contains(owner.getTc()))
                .forEach(System.out::println);
    }

    // ================= APPOINTMENT (PET OWNER) =================

    private void createAppointment(PetOwner owner) {
        try {
            System.out.print("Chip Number: ");
            String chip = sc.nextLine();

            System.out.println("Select Veterinarian:");
            List<Veterinarian> vets = VeterinarianRepository.getAllVeterinarians();
            for (int i = 0; i < vets.size(); i++) {
                System.out.println((i + 1) + "- " + vets.get(i).getName());
            }

            int index = Integer.parseInt(sc.nextLine()) - 1;
            Veterinarian vet = vets.get(index);

            System.out.print("Date (YYYY-MM-DD): ");
            LocalDate date = LocalDate.parse(sc.nextLine());

            System.out.print("Time (HH:MM): ");
            LocalTime time = LocalTime.parse(sc.nextLine());

            Appointment a = new Appointment(
                    owner.getTc(),
                    vet.getTc(),
                    chip,
                    date,
                    time,
                    AppointmentStatus.REQUESTED
            );

            appointmentManager.addAppointment(a);
            System.out.println("Appointment created.");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void listOwnerAppointments(PetOwner owner) {
        System.out.println("\n=== MY APPOINTMENTS ===");

        appointmentManager.getAllAppointments().stream()
                .filter(a -> a.getOwnerTc().equals(owner.getTc()))
                .forEach(System.out::println);
    }

    private void cancelAppointment(String tc) {
        List<Appointment> list = appointmentManager.getAllAppointments();

        for (int i = 0; i < list.size(); i++) {
            Appointment a = list.get(i);
            if (a.getOwnerTc().equals(tc)
                    && a.getStatus() == AppointmentStatus.REQUESTED) {

                System.out.println((i + 1) + "- " +
                        a.getDate() + " " + a.getTime() +
                        " | Chip=" + a.getChipNumber());
            }
        }

        System.out.print("Select appointment to cancel: ");
        int index = Integer.parseInt(sc.nextLine()) - 1;
        appointmentManager.cancelAppointment(list.get(index));
        System.out.println("Appointment cancelled.");
    }

    // ================= VETERINARIAN =================

    private void veterinarianAuth() {
        System.out.print("Enter TC: ");
        String tc = sc.nextLine();

        Veterinarian vet = VeterinarianRepository.getAllVeterinarians()
                .stream()
                .filter(v -> v.getTc().equals(tc))
                .findFirst()
                .orElse(null);

        if (vet == null) {
            System.out.println("Invalid veterinarian.");
            return;
        }

        veterinarianMenu(vet);
    }


    private void veterinarianMenu(Veterinarian vet) {
        while (true) {
            System.out.println("\n=== VETERINARIAN MENU ===");
            System.out.println("1- View Appointments");
            System.out.println("2- Approve Appointment");
            System.out.println("3- Cancel Appointment");
            System.out.println("4- Write Prescription (File I/O)"); // EKLENDİ
            System.out.println("5- Add Medical Operation");         // EKLENDİ
            System.out.println("6- View Medical History");          // EKLENDİ
            System.out.println("0- Logout");

            switch (sc.nextLine()) {
                case "1" -> listVetAppointments(vet);
                case "2" -> approveAppointment(vet);
                case "3" -> cancelAppointment(vet.getTc());
                case "4" -> writePrescription(vet);      // EKLENDİ
                case "5" -> addMedicalOperation(vet);    // EKLENDİ
                case "6" -> viewMedicalHistory();        // EKLENDİ
                case "0" -> { return; }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private void listVetAppointments(Veterinarian vet) {
        System.out.println("\n=== APPOINTMENTS ===");

        appointmentManager.getAllAppointments().stream()
                .filter(a -> a.getVetTc().equals(vet.getTc()))
                .forEach(System.out::println);
    }

    private void approveAppointment(Veterinarian vet) {
        List<Appointment> list = appointmentManager.getAllAppointments();

        for (int i = 0; i < list.size(); i++) {
            Appointment a = list.get(i);
            if (a.getVetTc().equals(vet.getTc())
                    && a.getStatus() == AppointmentStatus.REQUESTED) {

                System.out.println((i + 1) + "- " +
                        a.getDate() + " " + a.getTime() +
                        " | Chip=" + a.getChipNumber());
            }
        }

        System.out.print("Select appointment to approve: ");
        int index = Integer.parseInt(sc.nextLine()) - 1;
        appointmentManager.approveAppointment(list.get(index), vet);
        System.out.println("Appointment approved.");
    }

    //MEDICAL- PRESCRIPTION

    private void writePrescription(Veterinarian vet) {
        System.out.println("\n--- WRITE PRESCRIPTION ---");
        System.out.print("Enter Animal Chip ID: ");
        String chip = sc.nextLine();

        // Basit kontrol: Bu çip sistemde var mı?
        boolean exists = AnimalFileRepository.readAllAnimals().stream()
                .anyMatch(line -> line.contains(chip));

        if (!exists) {
            System.out.println(" Animal with this chip not found!");
            return;
        }

        System.out.print("Medicine Name: ");
        String medName = sc.nextLine();

        System.out.print("Dosage Info (e.g. Daily): ");
        String doseInfo = sc.nextLine();

        // Geçici nesneler oluşturuyoruz (Rapor çıktısı için)
        // Burada gerçek hayvandan ziyade raporlama için geçici bir hayvan nesnesi oluşturuyoruz
        // çünkü AnimalFileRepository String tutuyor.
        Animal tempAnimal = new Cat("Unknown", 0, 0, Gender.MALE, "Unknown", null);
        // Not: Gerçek isimleri dosyadan çekmek parsing gerektirir,
        // şimdilik chip ID üzerinden rapor basacağız.

        Medicine med = new Medicine(medName, "General", 100.0);
        Dosage dosage = new Dosage(1, 1, doseInfo);

        // Senin Prescription sınıfın
        Prescription p = new Prescription(vet, tempAnimal, med, dosage);

        // !!! İŞTE SENİN FILE PROCESSING KISMIN BURADA ÇAĞRILIYOR !!!
        p.printToFile();

        System.out.println(" Prescription written and SAVED TO FILE successfully. ");
    }

    private void addMedicalOperation(Veterinarian vet) {
        System.out.println("\n--- ADD OPERATION ---");

        System.out.print("Animal Chip Number: ");
        String chip = sc.nextLine();

        // Basit kontrol: Bu çip sistemde var mı?
        boolean exists = AnimalFileRepository.readAllAnimals().stream()
                .anyMatch(line -> line.contains(chip));

        if (!exists) {
            System.out.println(" Animal with this chip not found!");
            return;
        }

        System.out.print("Operation Type (Surgery/Checkup): ");
        String opType = sc.nextLine();

        System.out.print("Description: ");
        String desc = sc.nextLine();

        System.out.print("Cost: ");
        double cost = Double.parseDouble(sc.nextLine());

        // Şimdilik dosyadan parse etmediğimiz için geçici hayvan nesnesi:
        Animal tempAnimal = new Cat("Unknown", 0, 0, Gender.MALE, "Unknown", null);

        MedicalOperation op;
        if (opType.equalsIgnoreCase("Surgery")) {
            op = new Surgery(tempAnimal, vet, desc, cost);
        } else {
            op = new Checkup(tempAnimal, vet, desc, cost);
        }

        op.printDetails();
        System.out.println(" Operation recorded (Simulated). ");
    }
    private void viewMedicalHistory() {
        System.out.println("Feature coming soon based on File Repository integration.");
    }
}