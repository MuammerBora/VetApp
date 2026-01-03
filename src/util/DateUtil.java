util;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
/**
 * - Kullanıcı tarih/saat girer
 * - Sistem LocalDate/LocalTime ile çalışır (en doğru yol)
 * - Gösterimde Türkçe/insani format kullanırız (dd.MM.yyyy, HH:mm)
 */
public final class DateUtil {

    private DateUtil() {}

    // Kullanıcıdan beklenen formatlar
    private static final DateTimeFormatter DATE_INPUT =
            DateTimeFormatter.ofPattern("dd.MM.yyyy");

    private static final DateTimeFormatter TIME_INPUT =
            DateTimeFormatter.ofPattern("HH:mm");

    // Rapor / konsol çıktısı için aynı formatları kullanabiliriz
    private static final DateTimeFormatter DATE_OUTPUT = DATE_INPUT;
    private static final DateTimeFormatter TIME_OUTPUT = TIME_INPUT;

    /**
     * Kullanıcıdan alınan "dd.MM.yyyy" tarihini parse eder(stringi anlamlı bir veri tipine çevirir) .
     * Hatalıysa null döner.
     */
    public static LocalDate parseDate(String input) {
        try {
            return LocalDate.parse(input.trim(),DateUtil.DATE_INPUT);
        } catch (DateTimeParseException e){
            System.out.println("Tarih formatı hatalı!");
        } catch (NullPointerException e){
            System.out.println("Tarih boş girildi!");
        }
        return null;
    }


    /**
     * Kullanıcıdan alınan "HH:mm" saatini parse eder.
     * Format veya içerik yanlışsa → DateTimeParseException
     */
    public static LocalTime parseTime(String input) {
        try {
            return LocalTime.parse(input.trim(), DateUtil.TIME_INPUT);
        } catch (DateTimeParseException | NullPointerException e) {
            return null;
        }
    }

    /**
     * LocalDate'i ekranda okunabilir string'e çevirir.
     */
    public static String formatDate(LocalDate date) {
        return date == null ? "-" : date.format(DateUtil.DATE_OUTPUT);
    }

    /**
     * LocalTime'i ekranda okunabilir string'e çevirir.
     */
    public static String formatTime(LocalTime time) {
        return time == null ? "-" : time.format(DateUtil.TIME_OUTPUT);
    }
}