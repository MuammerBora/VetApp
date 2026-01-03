package exception;

public class MedicineOutOfStockException extends RuntimeException {
    public MedicineOutOfStockException(String message) {
        super(message);
    }
}