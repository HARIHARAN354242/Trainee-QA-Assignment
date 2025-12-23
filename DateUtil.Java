package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtil {

    public static String getNextMonthDate() {
        LocalDate nextMonth = LocalDate.now().plusMonths(1);
        return nextMonth.format(DateTimeFormatter.ofPattern("dd MMM yyyy"));
    }
}
