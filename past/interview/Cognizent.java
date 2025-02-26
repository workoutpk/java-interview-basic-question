package past.interview;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Cognizent {
    public static void main(String[] args) {
        String number = "29849289";
        Map<String, Long> map1 = Arrays.stream(number.split(""))
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

        System.out.println(map1);
        Arrays.stream(number.split("")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).forEach((string, numbers ) -> {
            System.out.println("Count of :: "+string +" is " + numbers);
        });
        int[] arr1= {1,4,5,6,7,8};
        Map<Integer, Long> s2= Arrays.stream(arr1).boxed()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(s2);
    }
}
