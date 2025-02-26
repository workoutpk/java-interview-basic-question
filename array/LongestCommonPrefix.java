package array;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] str = {"flower", "flow", "flight"};
        List<String> stringSet = new LinkedList<>();
        List<String> stringList = new LinkedList<>();

        char[] firstCharArray = str[0].toCharArray();
        for (int j = 0; j < str[0].length(); j++) {
            stringList.add(String.valueOf(firstCharArray[j]));
        }

        for (int i = 0; i < str.length; i++) {

            for (int j = 0; j < str[i].length(); j++) {
                String a = String.valueOf(str[i].charAt(j));
                String b = stringList.get(j);
                if (a.equals(b)) {
                    stringSet.add(b);
                } else {
                    if (stringSet.contains(b)) {
                        stringSet.remove(b);
                    }
                }
            }

        }
        Map<String, Long> map1 = stringSet.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().filter(f -> f.getValue() > 1).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));


        System.out.println("Common String .... " + stringSet);
        System.out.println("Longest Prefix char....." + map1.keySet());
    }
}
