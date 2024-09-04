package interview;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Random;

public class DataTypeConversionExample {
        public static void main(String[] args) {
                int a=10;
                String s1= String.valueOf(a);
                int b= Integer.valueOf(s1);
                int number = 12345;
                String string = Integer.toString(number);


                System.out.println(a);
                System.out.println(b);
                System.out.println(s1);
                System.out.println(string);

                Random random = new Random();
                System.out.println(random.nextInt(100));
                System.out.println(random.nextDouble(100));
                System.out.println(random.nextFloat(100));
                System.out.println(random.nextLong(100));


        }
}
