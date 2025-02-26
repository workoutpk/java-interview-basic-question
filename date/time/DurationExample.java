package date.time;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;

public class DurationExample {
    public static void main(String[] args) {
        LocalTime time1 = LocalTime.now();
        Duration duration = Duration.ofHours(5);
        LocalTime time2 = time1.plus(duration);
        LocalDate time3 = LocalDate.of(2015, Month.AUGUST,15);
        System.out.println("Time before duration of hours   ::: " + time1);
        System.out.println("Time after duration of 5 hours  ::: " + time2);
        Duration difference  = Duration.between(time1, time2);
        System.out.println("Duration Difference  " + difference.toMinutes());
        System.out.println("Duration Difference  " + difference.getSeconds());

    }
}
