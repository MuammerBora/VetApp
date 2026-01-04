//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package repository;

import animal.Animal;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AnimalFileRepository {
    private static final String FILE_NAME = "animals.txt";

    public AnimalFileRepository() {
    }

    public static void saveAnimal(Animal animal) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("animals.txt", true))) {
            String type = animal.getClass().getSimpleName().toUpperCase();
            bw.write(type + ";" + animal.getName() + ";" + animal.getOwner().getTc() + ";" + animal.getChip().getChipNumber());
            bw.newLine();
        } catch (IOException var6) {
            System.out.println("Animal file write error.");
        }

    }

    public static List<String> readAllAnimals() {
        List<String> animals = new ArrayList();

        String line;
        try (BufferedReader br = new BufferedReader(new FileReader("animals.txt"))) {
            while((line = br.readLine()) != null) {
                animals.add(line);
            }
        } catch (IOException var6) {
            System.out.println("Animal file read error.");
        }

        return animals;
    }
}
