
///ana sınıf biraz kabarık yayabilirsiniz ama swicht case leri burada gerekli buldum

package main;

import people.*;
import register.LoginManager;
import animal.*;
import util.ValidationUtil;
import repository.AnimalRepository;
import repository.AppointmentRepository;
import appointment.Appointment;
import prescription.*;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Person activeUser = null;

        while (true) {
            try {
                System.out.println("\n======= VETCORE SYSTEM =======");
                System.out.println("1. Login");
                System.out.println("2. Register");
                System.out.println("0. Exit");
                System.out.print("Choice: ");

                int choice = scanner.nextInt();

                if (choice == 0) break;

                if (choice == 2) {
                    LoginManager.register(scanner);
                    continue;
                }

                if (choice == 1) {
                    System.out.print("Enter ID/Name: ");
                    String id = scanner.next();
                    System.out.print("Enter Password: ");
                    String pass = scanner.next();

                    activeUser = LoginManager.login(id, pass);

                    if (activeUser != null) {
                        System.out.println("\n✅ Login Successful! Welcome, " + activeUser.getName() + "!");

                        // ALT MENÜ DÖNGÜSÜ
                        boolean stayInMenu = true;
                        while (stayInMenu) {
                            activeUser.showMenu(); // Polimorfizm: Kim girdiyse onun menüsü gelir
                            System.out.print("Action: ");
                            int action = scanner.nextInt();

                            if (action == 0) {
                                stayInMenu = false; // Çıkış yap
                                System.out.println("Logging out...");
                            } else {
                                // Kullanıcı tipine göre işlemleri yönlendiriyoruz
                                if (activeUser instanceof PetOwner) {
                                    handlePetOwnerActions(action, (PetOwner) activeUser, scanner);
                                } else if (activeUser instanceof Veterinarian) {
                                    handleVetActions(action, (Veterinarian) activeUser, scanner);
                                }
                            }
                        }
                    } else {
                        System.out.println("\n❌ Invalid ID or Password!");
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("\n⚠️ Error: Please enter a valid number!");
                scanner.nextLine(); // Scanner hafızasını temizle
            }
        }
    }

    // --- PET OWNER İŞLEMLERİ ---
    private static void handlePetOwnerActions(int action, PetOwner owner, Scanner sc) {
        switch (action) {
            case 1: // Add Animal
                System.out.print("Animal Name: ");
                String name = sc.next();
                System.out.print("Animal Age: ");
                int age = sc.nextInt();

                // Negatif yaş engelleme
                if (!ValidationUtil.isValidAge(age)) {
                    System.out.println("❌ ERROR: Age cannot be negative!");
                } else {
                    System.out.print("Breed: ");
                    String breed = sc.next();

                    // 1. Hayvanı oluştur
                    Dog newDog = new Dog("CHIP-" + (int)(Math.random()*1000), name, age, breed);

                    // 2. Sahibine ekle
                    owner.addPet(newDog);

                    // 3. GLOBAL SİSTEME EKLE (Hekim bulabilsin diye)
                    AnimalRepository.addAnimal(newDog);

                    System.out.println("✅ " + name + " added successfully! (Chip ID: " + newDog.getChipId() + ")");
                }
                break; // Break ekledik, yoksa alttaki kodlar da çalışır!

            case 2: // List My Animals
                if (owner.getPets().isEmpty()) {
                    System.out.println("You don't have any animals yet.");
                } else {
                    System.out.println("\n--- MY PETS ---");
                    for (Animal a : owner.getPets()) {
                        System.out.println("- " + a.getName() + " [" + a.getChipId() + "] Age: " + a.getAge());
                    }
                }
                break;

            case 3: // Get Appointment
                if (owner.getPets().isEmpty()) {
                    System.out.println("❌ First add a pet to get an appointment!");
                } else {
                    System.out.println("Select Pet:");
                    for (int i = 0; i < owner.getPets().size(); i++) {
                        System.out.println(i + ". " + owner.getPets().get(i).getName());
                    }
                    int pIdx = sc.nextInt();

                    if (pIdx >= 0 && pIdx < owner.getPets().size()) {
                        Animal selectedPet = owner.getPets().get(pIdx);

                        System.out.print("Reason for appointment: ");
                        String reason = sc.next();

                        // Randevu oluştur ve depoya ekle
                        Appointment newApp = new Appointment(selectedPet, null, reason);
                        AppointmentRepository.addAppointment(newApp);

                        System.out.println("✅ Appointment request sent for " + selectedPet.getName());
                    } else {
                        System.out.println("Invalid selection.");
                    }
                }
                break;

            default:
                System.out.println("Invalid option.");
                break;

            // handlePetOwnerActions metodunun içindeki switch'e ekle:

            case 4: // REPORT MISSING ANIMAL (Kayıp İhbarı Ver)
                if (owner.getPets().isEmpty()) {
                    System.out.println("❌ First add a pet!");
                } else {
                    System.out.println("Which pet is missing?");
                    // Hayvan seçtirme
                    for (int i = 0; i < owner.getPets().size(); i++) {
                        System.out.println(i + ". " + owner.getPets().get(i).getName());
                    }
                    int mIdx = sc.nextInt();

                    if (mIdx >= 0 && mIdx < owner.getPets().size()) {
                        animal.Animal lostPet = owner.getPets().get(mIdx);

                        System.out.print("Last Seen Location: ");
                        String loc = sc.next(); // Tek kelime alır (Örn: Kadıköy)

                        System.out.print("Reward Amount ($): ");
                        double reward = sc.nextDouble();

                        // İhbar oluştur ve kaydet
                        alert.MissingAlert alert = new alert.MissingAlert(lostPet, owner, loc, reward);
                        repository.AlertRepository.addAlert(alert);

                        System.out.println("⚠️ ALERT CREATED! We hope " + lostPet.getName() + " is found soon.");
                    }
                }
                break;

        }
    }

    // --- VETERINARIAN İŞLEMLERİ ---
    private static void handleVetActions(int action, Veterinarian vet, Scanner sc) {
        switch (action) {
            case 1: // SCAN CHIP
                System.out.print("Enter Chip ID to scan: ");
                String searchChip = sc.next();

                // Repository'den hayvanı sorgula
                Animal foundAnimal = AnimalRepository.findByChipId(searchChip);

                if (foundAnimal != null) {
                    System.out.println("\n✅ ANIMAL FOUND!");
                    System.out.println("Name: " + foundAnimal.getName());
                    System.out.println("Age: " + foundAnimal.getAge());
                    System.out.println("Breed: " + foundAnimal.getClass().getSimpleName()); // Irkı sınıf isminden alabiliriz

                    // Tıbbi Geçmişi Dök
                    foundAnimal.getMedicalRecord().showHistory();
                    foundAnimal.getMedicalRecord().showPrescriptions();
                } else {
                    System.out.println("❌ ERROR: No animal found with this Chip ID!");
                }
                break;

            case 2: // WRITE PRESCRIPTION (İlaç Yazma)
                System.out.print("Enter Chip ID for Prescription: ");
                String pChip = sc.next();
                Animal pAnimal = AnimalRepository.findByChipId(pChip);

                if (pAnimal != null) {
                    System.out.print("Medicine Name: ");
                    String mName = sc.next();

                    Medicine med = new Medicine(mName, "General", 100.0);
                    Dosage dos = new Dosage(2, 1, "Daily");

                    Prescription newP = new Prescription(vet, pAnimal, med, dos);
                    pAnimal.getMedicalRecord().addPrescription(newP);
                    System.out.println("✅ Prescription written successfully.");
                } else {
                    System.out.println("❌ Animal not found!");
                }
                break;

            case 3: // View Appointments
                ArrayList<Appointment> apps = AppointmentRepository.getAllAppointments();
                System.out.println("\n--- UPCOMING APPOINTMENTS ---");
                if (apps.isEmpty()) {
                    System.out.println("No appointments found.");
                } else {
                    for (Appointment a : apps) {
                        System.out.println(a.toString());
                    }
                }
                break;

            default:
                System.out.println("Invalid option.");
                break;

            // handleVetActions metodunun içindeki switch'e ekle:

            case 4: // VIEW MISSING ALERTS
                System.out.println("\n📢 --- MISSING ANIMAL ALERTS ---");
                java.util.ArrayList<alert.MissingAlert> alerts = repository.AlertRepository.getAllAlerts();

                if (alerts.isEmpty()) {
                    System.out.println("Good news! No missing animals reported.");
                } else {
                    for (alert.MissingAlert a : alerts) {
                        System.out.println("---------------------------");
                        System.out.println(a.toString());
                    }
                }
                break;

        }
    }
}