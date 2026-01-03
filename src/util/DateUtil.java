package util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static String formatCurrentDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(new Date());
    }
}