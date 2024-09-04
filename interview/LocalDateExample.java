package interview;

import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

public class LocalDateExample {
        public static void main(String[] args) {
                LocalDate today = LocalDate.now();
                System.out.println("Current Date="+today);
                //Creating LocalDate by providing input arguments
                LocalDate firstDay_2014 = LocalDate.of(2014, Month.JANUARY, 1);
                System.out.println("Specific Date="+firstDay_2014);
                //Current date in "Asia/Kolkata", you can get it from ZoneId javadoc
                LocalDate todayKolkata = LocalDate.now(ZoneId.of("Asia/Kolkata"));
                System.out.println("Current Date in IST="+todayKolkata);

                //Getting date from the base date i.e= 01/01/1970
                LocalDate dateFromBase = LocalDate.ofEpochDay(365);
                System.out.println("365th day from base date= "+dateFromBase);


                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                LocalDate localDate = LocalDate.parse("29-02-2004",formatter);
                String day = localDate.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.US);
                System.out.println(day.toUpperCase());

        }
}
