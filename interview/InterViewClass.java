package interview;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InterViewClass {

        public static void main(String[] args) {
                String s1 = "thisispkprajapati";

                Map<String, Long> stringList1 = Arrays.stream(s1.split(""))
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

                Map<String, List<String>> stringList2 = Arrays.stream(s1.split(""))
                        .collect(Collectors.groupingBy(ele -> ele));

                Map<String,Long> stringLongMap = Arrays.stream(s1.split(""))
                        .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                        .entrySet()
                        .stream().
                        filter(ele->ele.getValue() >2)
                        .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));


                System.out.println(stringList1);
                System.out.println(stringList2);
                System.out.println("filter :  "+stringLongMap);

                Map<String, Integer> books = new HashMap<>();
                books.put("Design Patterns", 1);
                books.put("Java 8 in Action", 2);
                books.put("Effective Java", 3);

                Map<String,Integer> stringIntegerMap= books.entrySet()
                        .stream()
                        .map(ele->{
                                int value = ele.getValue();
                                return new AbstractMap.SimpleEntry<>(ele.getKey(),value*2);
                        })
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

                System.out.println("Modified map ::: " + stringIntegerMap);


                Map<String, Integer> stringIntegerMap1 = books.entrySet().stream().map(mm->{
                        return new AbstractMap.SimpleEntry<>(mm.getKey(),mm.getValue()*2);
                }).collect(Collectors.toMap(Map.Entry ::getKey, Map.Entry::getValue));

                StringBuilder stringBuilder = new StringBuilder(s1);
                stringBuilder.reverse();
                System.out.println("stringBuilder :: "+ stringBuilder);
                String string=  Arrays.stream(s1.split("")).map(tt->new StringBuilder(tt).reverse()).toString();
                System.out.println("string ::: " + string.toString());
        }
}
