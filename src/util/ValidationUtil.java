package util;

import exception.InvalidAgeException;

public class ValidationUtil {
    // Sadece true/false döndüren basit kontrol
    public static boolean isValidAge(int age) {
        return age >= 0;
    }

    // Hata fırlatan gelişmiş kontrol (Main'de kullandığımız bu)
    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 0) {
            throw new InvalidAgeException("Age cannot be negative! (Input: " + age + ")");
        }
    }
}