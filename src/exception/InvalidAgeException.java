package exception;

// Kendi hata sınıfımız (Custom Exception)
public class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}