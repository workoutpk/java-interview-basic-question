package interview;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateComparison {
        //Comparing LocalDate Objects:
        //
        //isAfter(LocalDate other): Checks if this LocalDate is after the specified LocalDate.
        //isBefore(LocalDate other): Checks if this LocalDate is before the specified LocalDate.
        //isEqual(LocalDate other): Checks if this LocalDate is equal to the specified LocalDate

        //Getting Information from a LocalDate:
        //
        //getYear(): Returns the year of the LocalDate.
        //getMonthValue(): Returns the month of the LocalDate as an integer (1-12).
        //getDayOfMonth(): Returns the day of the month of the LocalDate.
        //getDayOfWeek(): Returns the day of the week of the LocalDate.
        //getDayOfYear(): Returns the day of the year of the LocalDate.


        //Modifying a LocalDate:
        //
        //plus(TemporalAdjuster adjuster): Adds the specified amount of time to the LocalDate.
        //minus(TemporalAdjuster adjuster): Subtracts the specified amount of time from the LocalDate.
        //with(TemporalField field, long newValue): Sets the value of the specified field to the given value.
        //withYear(int year): Sets the year of the LocalDate.
        //withMonth(int month): Sets the month of the LocalDate.
        //withDayOfMonth(int dayOfMonth): Sets the day of the month of the LocalDate.
        public static LocalDate greatestDate(LocalDate date1, LocalDate date2) {
                if (date1.isAfter(date2)) {
                        return date1;
                } else {
                        return date2;
                }
        }

        public static void main(String[] args) {
                LocalDate date1 = LocalDate.of(2023, 7, 24);
                LocalDate date2 = LocalDate.of(2023, 7, 25);

                LocalDate greatestDate = greatestDate(date1, date2);
                System.out.println("The greatest date is: " + greatestDate);
                LocalDate today = LocalDate.now();
                System.out.println("Today is: " + today.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

                LocalDate birthday = LocalDate.of(1990, 12, 25);
                System.out.println("Birthday: " + birthday.format(DateTimeFormatter.ofPattern("MMM dd, yyyy")));

                LocalDate newDate = today.plusDays(10);
                System.out.println("New date: " + newDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        }

}
