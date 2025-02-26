package string;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DuplicateString {
    public static void main(String[] args) {
        String s1 = "Pk Prajapati";
        Map<String, Long> stringCount = Arrays.stream(s1.split(""))
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

        List<String> duplicateString = stringCount.entrySet().stream().filter(ele -> ele.getValue() > 1)
                .map(Map.Entry::getKey).toList();

        System.out.println("Duplicate String is ::: " + duplicateString);
        System.out.println("stringCount String is ::: " + stringCount);
    }
}
