package date.time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class TimeExample3 {
    public static void main(String[] args) throws ParseException {
        String date1= "22-04-2005";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate localDate = LocalDate.parse(date1, dateTimeFormatter);
        System.out.println("localDate :: "+ localDate);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = simpleDateFormat.parse(date1);
        System.out.println(date.getTime());
        System.out.println(date);

    }
}
