package date.time;

import java.text.NumberFormat;
import java.time.*;

public class PeriodExample {
    public static void main(String[] args) {
        LocalDate date1 = LocalDate.now();
        LocalDate date2 = LocalDate.of(2005, Month.DECEMBER, 4);
        Period period = Period.between(date2, date1);
        System.out.println("period getYears :: " + period.getYears());
        System.out.println("period getMonths :: " + period.getMonths());
        System.out.println("period getDays :: " + period.getDays());
        Long aLong = System.currentTimeMillis();
        ZoneId zoneId = ZoneId.systemDefault();
        Instant instant = Instant.now();
        LocalDateTime dateTime1 = LocalDateTime.ofInstant(instant,zoneId);

    }
}
