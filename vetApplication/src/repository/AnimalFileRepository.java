package repository;

import animal.*;
import people.PetOwner;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AnimalFileRepository {

    private static final String FILE_NAME = "animals.txt";

    public static void saveAnimal(Animal animal) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true))) {

            String type = animal.getClass().getSimpleName().toUpperCase();
            bw.write(
                    type + ";" +
                            animal.getName() + ";" +
                            animal.getOwner().getTc() + ";" +
                            animal.getChip().getChipNumber()
            );
            bw.newLine();

        } catch (IOException e) {
            System.out.println("Animal file write error.");
        }
    }

    public static List<String> readAllAnimals() {
        List<String> animals = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                animals.add(line);
            }
        } catch (IOException e) {
            System.out.println("Animal file read error.");
        }
        return animals;
    }
}