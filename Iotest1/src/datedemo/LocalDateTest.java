package datedemo;

import java.time.LocalDateTime;

public class LocalDateTest {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        int dayOfMonth = localDateTime.getDayOfMonth();
        System.out.println(dayOfMonth);
        localDateTime = localDateTime.minusDays(dayOfMonth-1);
        System.out.println(localDateTime.getDayOfMonth());
    }
}
