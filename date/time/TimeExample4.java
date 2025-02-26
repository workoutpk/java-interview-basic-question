package date.time;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;

public class TimeExample4 {
    public static void main(String[] args) {
        Long currentTImeStamp = System.currentTimeMillis();
        Instant currentDateTime  = Instant.now();
        Long currentDateTimeStamp  = Instant.now().toEpochMilli();
        Instant timeStampToDate = Instant.ofEpochMilli(currentTImeStamp);
        ZonedDateTime zonedDateTime =  ZonedDateTime.now();
        System.out.println("Current time is ....  " + currentTImeStamp);
        System.out.println("Current currentDateTime is ....  " + currentDateTime);

        LocalDate localDate =  LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime dateTime  = LocalDateTime.now();
        System.out.println("Local Date is .... " + localDate);
        System.out.println("Local Time is .... " + localTime);
        System.out.println("Local dateTime is .... " + dateTime);
        String date1= "22-04-2005";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date2 =  LocalDate.parse(date1,dateTimeFormatter);
        System.out.println("Date is .... " + date2);
        System.out.println("Date is .... " + date2.getDayOfMonth());
        System.out.println("getMonth is .... " + date2.getMonth());
        System.out.println("getMonth is .... " + date2.getMonthValue());
        System.out.println("Year is .... " + date2.getYear());
        Long timStamp = date2.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();

        System.out.println("date2 timestamp ::  "+timStamp);
        System.out.println(" timeStampToDate ::  "+timeStampToDate);
        System.out.println(" zonedDateTime ::  "+zonedDateTime);
        ZoneId zoneId = ZoneId.of("Asia/Tokyo");
        ZonedDateTime zonedDateTime1 = zonedDateTime.withZoneSameLocal(zoneId);

    }
}
