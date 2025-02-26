package date.time;

import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class TimeExample1 {
    public static void main(String[] args) {

        Long aLongTIme = System.currentTimeMillis();
        Instant instant = Instant.now();
        Instant instant1 = Instant.ofEpochMilli(aLongTIme);
        // Get the current time in milliseconds
        long currentMilliseconds = Instant.now().toEpochMilli();

        System.out.println("Current time in milliseconds: " + currentMilliseconds);
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("aLongTIme :: "+aLongTIme);
        System.out.println("instant :: " +instant);
        System.out.println("instant1 :: " +instant1);
        System.out.println("localDateTime :: " +localDateTime);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        Date date = new Date(aLongTIme);
        Time time = new Time(aLongTIme);
        System.out.println("data ::: " + date);
        System.out.println("time ::: " + time);
        System.out.println("instant1 ::: " + instant1);
        System.out.println("sdf ::: " + sdf.format(date));
        System.out.println("dateTimeFormatter :: " + localDateTime.format(dateTimeFormatter));
        LocalDateTime dateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());

        // the current date
        LocalDate localDate = LocalDate.now();
        System.out.println("the current date is "+
                localDate);


        // the current time
        LocalTime localTime = LocalTime.now();
        System.out.println("the current time is "+
                localTime);

        System.out.println(" localDateTime Month ::" + localDateTime.getMonth());
        System.out.println(" localDateTime Month ::" + localDateTime.getSecond());
        System.out.println(" localDateTime Month ::" + localDateTime.getDayOfMonth());
        // printing some specified date
        LocalDate date2 = LocalDate.of(1950,1,26);
        System.out.println("the republic day :"+date2);
        ZonedDateTime zonedDateTime =  ZonedDateTime.now();
        System.out.println("zonedDateTime :: " +zonedDateTime);
        System.out.println("zonedDateTime :: " +zonedDateTime.getZone());
        ZoneId tokyo = ZoneId.of("Asia/Tokyo");
        ZonedDateTime  zonedDateTime1 = zonedDateTime.withZoneSameLocal(tokyo);
        System.out.println("zonedDateTime1 ::: " +zonedDateTime1);
        Month month = Month.of(3);
        System.out.println("month :: " +  month);

    }


}
