package animal;

import medical.MedicalRecord;

public abstract class Animal {
    private String chipId;
    private String name;
    private int age;
    private String breed; //tür cins mesela Maltese Terrier, French Bulldog , Tekir falan
    private MedicalRecord medicalRecord; // COMPOSITION: Her hayvanın bir karnesi vardır.

    public Animal(String chipId, String name, int age, String breed) {
        this.chipId = chipId;
        this.name = name;
        this.age = age;
        this.breed = breed;
        this.medicalRecord = new MedicalRecord(); // Karne otomatik oluşur
    }

    // GETTERS & SETTERS (Encapsulation)
    public String getChipId() { return chipId; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public MedicalRecord getMedicalRecord() { return medicalRecord; }

    // POLYMORPHISM: Her hayvan farklı ses çıkarır
    public abstract void makeSound();
}