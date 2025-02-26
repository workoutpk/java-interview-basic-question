package date.time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class TimeExample2 {
    // Method using SimpleDateFormat (Java 7 and earlier)
    public static long convertToMillisUsingSimpleDateFormat(String dateString) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date date = sdf.parse(dateString);
        return date.getTime();
    }

    // Method using java.time API (Java 8 and later)
    public static long convertToMillisUsingJavaTime(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate localDate = LocalDate.parse(dateString, formatter);
        return localDate.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }
    public static void main(String[] args) throws ParseException {
        String date1= "22-04-2005";

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate localDate =  LocalDate.parse(date1, dateTimeFormatter);
        Long timStamp = localDate.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
        System.out.println("localDate uf ::: " + localDate);
        System.out.println("localDate wf ::: " + localDate.format(formatter));

        try {
            // Using SimpleDateFormat (Java 7 and earlier)
            long millisUsingSimpleDateFormat = convertToMillisUsingSimpleDateFormat(date1);
            System.out.println("Milliseconds using SimpleDateFormat: " + millisUsingSimpleDateFormat);

            // Using java.time API (Java 8 and later)
            long millisUsingJavaTime = convertToMillisUsingJavaTime(date1);
            System.out.println("Milliseconds using java.time API: " + millisUsingJavaTime);

        } catch (ParseException e) {
            System.out.println("Error parsing the date: " + e.getMessage());

        }
    }
}
