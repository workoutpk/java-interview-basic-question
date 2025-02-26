package past.interview;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ApicronInterview {
    public static void main(String[] args) {
        String str = "programming"; //output r=2,g=2,m=2

        Map<Character, Long> countString = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
                .entrySet().stream() // Stream the entry set
                .filter(entry -> entry.getValue() > 1) // Filter for duplicates
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        System.out.println(countString);


        Map<Character, Long> stringGrouping  = str.chars().mapToObj(c -> (char)c)
                .collect(Collectors.groupingBy(c-> c, Collectors.counting()));
        System.out.println(stringGrouping);

        String strWithSpace = "programming";
        Map<String, Long> ss= Arrays.stream(strWithSpace.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(fl -> fl.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println("Grouping of string is  :: "+ ss);
    }
}
