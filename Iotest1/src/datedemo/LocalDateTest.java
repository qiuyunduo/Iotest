package datedemo;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTest {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        int dayOfMonth = localDateTime.getDayOfMonth();
        System.out.println(dayOfMonth);
        localDateTime = localDateTime.minusDays(dayOfMonth-1);
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(Instant.now());
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = now.format(dateTimeFormatter);
        System.out.println(format);

    }
}
