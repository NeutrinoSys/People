package datastore;

import java.time.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TimeTest {
    public static void main(String[] args) {
        LocalDate d1 = LocalDate.of(2000, 1, 1);
        LocalDate d2 = LocalDate.of(2002, 6, 10);
        System.out.println(d1.compareTo(d2));
        LocalTime lt1 = LocalTime.of(10, 30);
        LocalTime lt2 = LocalTime.of(13, 57, 39);
        System.out.println(lt1.equals(lt2));

        LocalDateTime ldt1 = LocalDateTime.of(d1, lt1);
        LocalDateTime ldt2 = LocalDateTime.of(d2, lt2);
        System.out.println(ldt1.equals(ldt2));
        //        System.out.println(LocalTime.now());

        Period diff = Period.between(d1, d2);
        System.out.printf("%d years, %d months, %d days%n", diff.getYears(), diff.getMonths(), diff.getDays());
//        ZoneId.of("")


        LocalDateTime xmas = LocalDateTime.of(2021, 12, 25, 20, 00);
        // California - GMT-08
        ZonedDateTime zxmas = ZonedDateTime.of(xmas, ZoneId.of("-8"));
        System.out.println(zxmas.withZoneSameInstant(ZoneId.of("+0")));

        System.out.println(xmas.toInstant(ZoneOffset.ofHours(0)));
        System.out.println(zxmas.toInstant());

        System.out.println(Instant.now().atZone(ZoneId.of("-8")));

        System.out.println(new Date());
        System.out.println(Calendar.getInstance().get(Calendar.DAY_OF_WEEK));
        Calendar oldXmas = Calendar.getInstance();
        oldXmas.set(2020, 11, 25, 20, 0, 0);
        System.out.println(oldXmas.getTime());

        oldXmas.add(Calendar.HOUR, -3);
        System.out.println(oldXmas.getTime());

        System.out.println(oldXmas.toInstant().atZone(ZoneId.of("+0")));
        System.out.println(Date.from(zxmas.toInstant()));
        GregorianCalendar gregXmas = GregorianCalendar.from(zxmas);
        System.out.println(Calendar.getInstance().getClass());
    }
}
