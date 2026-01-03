package util;

import java.util.UUID;

public class IdGenerator {
    //  Unique ID üretir random atama kodu buradda
    public static String generateId() {
        return UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }
}