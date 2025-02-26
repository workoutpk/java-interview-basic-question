package past.interview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class WeCpTest {
    public static void main(String[] args) {
        Optional<String> optionalS = Optional.empty();
        System.out.println(optionalS);
        Map<Integer, String> integerStringMap = new HashMap<>();

        String[] str = {"a","b","cd","ef","ghij"};
        Map<Integer, String> stringMap = Arrays.stream(str).collect(Collectors.groupingBy(String::length,Collectors.joining()));
        integerStringMap.put(1,"a");
        integerStringMap.put(1,"b");
        integerStringMap.put(2,"cd");
        integerStringMap.put(2,"ef");
        integerStringMap.put(4,"ghij");
        System.out.println(integerStringMap.values());

        System.out.println(stringMap.values());
    }
}
