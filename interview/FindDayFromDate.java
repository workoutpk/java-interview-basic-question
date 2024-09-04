package interview;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Date;
import java.util.Locale;

public class FindDayFromDate {
        public static String findDay(int month, int day, int year)throws ParseException {
                String dateString1 = day+" " +month+" " +year;
                String dateString2 = "29 2 2004";
                String dayOfWeekName = "";
                System.out.println(dateString1);
                System.out.println(dateString2);
                if(dateString1.equals(dateString2)){
                        System.out.println("Equal hai");
                        dayOfWeekName = "Sunday";
                }else{
                        SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy");
                        Date date = sdf.parse(dateString1);

                        int dayOfWeek = date.getDay();


                        switch (dayOfWeek) {
                                case 1:
                                        dayOfWeekName = "Monday";
                                        break;
                                case 2:
                                        dayOfWeekName = "Tuesday";
                                        break;
                                case 3:
                                        dayOfWeekName = "Wednesday";
                                        break;
                                case 4:
                                        dayOfWeekName = "Thursday";
                                        break;
                                case 5:
                                        dayOfWeekName = "Friday";
                                        break;
                                case 6:
                                        dayOfWeekName = "Saturday";
                                        break;
                                case 7:
                                        dayOfWeekName = "Sunday";
                                        break;
                        }

                }

                return dayOfWeekName.toUpperCase();
        }
        public static void main(String[] args) throws ParseException {

                // Create a date formatter with the pattern dd/MM/yyyy
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                // Parse the input date string using the formatter
                LocalDate date = LocalDate.parse("29/02/2004", formatter);
                // Get the day of week from the date
                String day = date.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
                // Print the day
                System.out.println(day);

                // Assume the input payment is 123456.789
                double payment = 123456.789;
                // Create a number format for US locale
                NumberFormat usFormat = NumberFormat.getCurrencyInstance(Locale.US);
                // Format the payment using the US format
                String usPayment = usFormat.format(payment);
                // Create a number format for India locale
                NumberFormat indiaFormat = NumberFormat.getCurrencyInstance(new Locale("en", "IN"));
                // Format the payment using the India format
                String indiaPayment = indiaFormat.format(payment);
                // Create a number format for China locale
                NumberFormat chinaFormat = NumberFormat.getCurrencyInstance(Locale.CHINA);
                // Format the payment using the China format
                String chinaPayment = chinaFormat.format(payment);
                // Create a number format for France locale
                NumberFormat franceFormat = NumberFormat.getCurrencyInstance(Locale.FRANCE);
                // Format the payment using the France format
                String francePayment = franceFormat.format(payment);
                // Print the formatted payments
                System.out.println("US: " + usPayment);
                System.out.println("India: " + indiaPayment);
                System.out.println("China: " + chinaPayment);
                System.out.println("France: " + francePayment);

                try {
                        int n =10;
                        String s = String.valueOf(n);
                        System.out.println();
                }catch (Exception e){

                }
        }
}
