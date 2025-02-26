package date.time;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class DurationAndPeriodExample {



    public static void durationExamples() {
        System.out.println("Duration Examples:");
        // Creating Durations
        Duration twoHours = Duration.ofHours(2);
        Duration tenMinutes = Duration.ofMinutes(10);
        Duration threeSeconds = Duration.ofSeconds(3);
        Duration microSeconds = Duration.ofNanos(1_000_000);

        System.out.println("Two hours: " + twoHours);
        System.out.println("Ten minutes: " + tenMinutes);
        System.out.println("Three seconds: " + threeSeconds);
        System.out.println("Microseconds: " + microSeconds);

        // Performing operations with Durations
        Duration totalDuration = twoHours.plus(tenMinutes).plus(threeSeconds);
        System.out.println("Total duration: " + totalDuration);

        // Using Duration between two Instants
        Instant start = Instant.now();
        Instant end = start.plus(1, ChronoUnit.DAYS);
        Duration betweenInstants = Duration.between(start, end);
        System.out.println("Duration between two instants: " + betweenInstants);

        // Converting Duration to different units
        System.out.println("Total duration in seconds: " + totalDuration.getSeconds());
        System.out.println("Total duration in minutes: " + totalDuration.toMinutes());

        System.out.println();
    }

    public static void periodExamples() {
        System.out.println("Period Examples:");

        // Creating Periods
        Period tenDays = Period.ofDays(10);
        Period threeWeeks = Period.ofWeeks(3);
        Period twoYearsSixMonthsOneDay = Period.of(2, 6, 1);

        System.out.println("Ten days: " + tenDays);
        System.out.println("Three weeks: " + threeWeeks);
        System.out.println("Two years, six months, one day: " + twoYearsSixMonthsOneDay);

        // Performing operations with Periods
        Period totalPeriod = tenDays.plus(threeWeeks);
        System.out.println("Total period: " + totalPeriod);

        // Using Period between two LocalDates
        LocalDate startDate = LocalDate.of(2023, 1, 1);
        LocalDate endDate = LocalDate.of(2024, 6, 30);
        Period betweenDates = Period.between(startDate, endDate);
        System.out.println("Period between two dates: " + betweenDates);

        // Getting individual components of a Period
        System.out.println("Years in period: " + betweenDates.getYears());
        System.out.println("Months in period: " + betweenDates.getMonths());
        System.out.println("Days in period: " + betweenDates.getDays());

        System.out.println();
    }

    public static void compareDurationAndPeriod() {
        System.out.println("Comparing Duration and Period:");

        // Duration example: precise time-based amount
        LocalDateTime start = LocalDateTime.of(2023, 3, 26, 2, 0); // Just before daylight saving change
        LocalDateTime end = LocalDateTime.of(2023, 3, 26, 4, 0);   // Just after daylight saving change
        Duration duration = Duration.between(start, end);
        System.out.println("Duration between 2 AM and 4 AM during daylight saving change: " + duration);

        // Period example: date-based amount
        LocalDate startDate = LocalDate.of(2023, 2, 28);
        LocalDate endDate = LocalDate.of(2024, 2, 29);  // Leap year
        Period period = Period.between(startDate, endDate);
        System.out.println("Period from Feb 28, 2023 to Feb 29, 2024: " + period);
    }
    public static void main(String[] args) {
        durationExamples();
        periodExamples();
        compareDurationAndPeriod();
    }
}
