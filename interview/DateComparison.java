package interview;

import java.time.LocalDate;

public class DateComparison {
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
        }

}
