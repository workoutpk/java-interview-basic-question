package dsa.dp;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StringReverse {
    public static void main(String[] args) {
        String s = "a good   example";
        String[] normalOrder = s.trim().split("\\s+");
        List<String> stringList = Arrays.asList(normalOrder);
        String reverstring = stringList.reversed().stream().collect(Collectors.joining(" "));
        System.out.println(reverstring);
        List<Integer> i = Arrays.asList(1,2,3,4,5,6);
        Optional<Integer> sum = i.stream().reduce((a,b)->a+b);
    }
}
