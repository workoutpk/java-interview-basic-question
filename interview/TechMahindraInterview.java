package interview;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TechMahindraInterview {

        public static String reverse(String string) {
                return Stream.of(string)
                        .map(word->new StringBuilder(word).reverse())
                        .collect(Collectors.joining(" "));
        }
        public static void main(String[] args) {
                String str = "Hello, world!";
                String string = "Hi Pk Prajapati";
                String s = Stream.of(str).map(word->new StringBuilder(word).substring(0,4))
                                .collect(Collectors.joining(" "));
                System.out.println(s);
                System.out.println("Reversed String is  :: " +reverse(str));
                String ty = Stream.of(string).map(ele-> new StringBuilder(ele).reverse())
                        .collect(Collectors.joining());

                List<String> stringList = Arrays.stream(string.split( " "))
                        .filter(ele->ele.length()>6)
                        .toList();

                System.out.println("list  :: " + stringList);

                String[] words = {"Hello", "world", "this", "is", "a", "StringBuilder", "example"};

                // Create a StringBuilder using the Stream API
                StringBuilder sb = new StringBuilder(Arrays.stream(words)
                        .collect(Collectors.joining(" ")));

                // Print the resulting StringBuilder
                System.out.println(sb);
                // Define the integer value
                int value = 100;
                NumberFormat usdFormat = NumberFormat.getCurrencyInstance(Locale.US);
                NumberFormat cnyFormat = NumberFormat.getCurrencyInstance(Locale.CHINA);
                NumberFormat eurFormat = NumberFormat.getCurrencyInstance(Locale.FRANCE);
                NumberFormat inrFormat = NumberFormat.getCurrencyInstance(new Locale("en", "IN"));
                // Format the value to different currencies and store them as strings
                String usdPrice = usdFormat.format(value);
                String cnyPrice = cnyFormat.format(value);
                String eurPrice = eurFormat.format(value);
                String inrPrice = inrFormat.format(value);

                // Print the prices
                System.out.println("The price of " + value + " in different currencies are:");
                System.out.println(usdPrice);
                System.out.println(cnyPrice);
                System.out.println(eurPrice);
                System.out.println(inrPrice);
        }
}
