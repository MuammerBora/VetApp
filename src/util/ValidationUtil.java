package util;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * WHY:
 * - Konsol uygulamasında kullanıcı boş, hatalı, eksik input girebilir.
 * - Aynı kontrol kodunu her yerde yazmak yerine tek yerde toplarız.
 * - Bu utility, "iş kuralı" değil; sadece "input doğrulama" sağlar.
 */
public final class ValidationUtil {

    private ValidationUtil() {}

    /**
     * Boş/space input kontrolü. (null, "", "   " -> true)
     */
    public static boolean isBlank(String s) {
        return s == null || s.trim().isEmpty();
    }

    /**
     * Basit ID doğrulama:
     * - boş olmasın
     * - çok kısa olmasın
     */
    public static boolean isValidId(String id) {
        return !isBlank(id) && id.trim().length() >= 2;
    }

    /**
     * Tarih ve saat parse edilmiş mi kontrol eder.
     * (DateUtil.parseDate/parseTime null dönebilir)
     */
    public static boolean isValidDateTime(LocalDate date, LocalTime time) {
        return date != null && time != null;
    }

    /**
     * Rapor/manager çağrılarında alan boşsa direkt hata fırlatmak istersen diye.
     * Konsolda try/catch ile yakalayıp mesaj gösterebilirsin.
     */
    public static String requireNonBlank(String value, String fieldName) {
        if (isBlank(value)) {
            throw new IllegalArgumentException(fieldName + " bos olamaz.");
        }
        return value.trim();
    }
}