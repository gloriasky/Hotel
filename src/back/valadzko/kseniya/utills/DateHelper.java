package back.valadzko.kseniya.utills;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateHelper {
    public static Date stringToDate(String stringDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate localDateOfRelease = LocalDate.parse(stringDate, formatter);
        return Date.from(localDateOfRelease.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public static String dateToString(Date date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate localDateTime = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return localDateTime.format(formatter);
    }


}
