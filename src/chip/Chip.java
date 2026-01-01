package chip;

import animal.Animal;

public class Chip {
    //Bir hayvana takılan mikroçipi temsil eder
    //Her çip benzersiz bir numaraya sahiptir

    private String chipId;
    private Animal animal;

    public Chip(String chipId, Animal animal) {
        this.chipId = chipId;
        this.animal = animal;
    }

    public Animal getAnimal() {
        return animal;
    }
}
