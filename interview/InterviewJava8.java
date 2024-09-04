package interview;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class InterviewJava8 {
        public static void main(String[] args) {
                String s = "ilovejavateche";

                Map<String, List<String>> stringListMap1  = Arrays.stream(s.split(""))
                        .collect(Collectors.groupingBy(se->se));

                Map<String, Long> stringListMap2  = Arrays.stream(s.split(""))
                        .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

                List<String> stringListMap3  = Arrays.stream(s.split(""))
                        .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                        .entrySet().stream()
                        .filter(em->em.getValue()>1)
                        .map(Map.Entry::getKey)
                        .toList();
                List<String> stringListMap4  = Arrays.stream(s.split(""))
                        .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                        .entrySet().stream()
                        .filter(em->em.getValue()==1)
                        .map(Map.Entry::getKey)
                        .toList();
                List<String> stringListMap5  = Collections.singletonList(Arrays.stream(s.split(""))
                        .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new, Collectors.counting()))
                        .entrySet().stream()
                        .filter(em -> em.getValue() == 1)
                        .map(Map.Entry::getKey)
                        .findFirst().get());



                System.out.println("String Array :: "+stringListMap1);
                System.out.println("String Count :: "+stringListMap2);
                System.out.println("String Duplt :: "+stringListMap3);
                System.out.println("String Uniqu :: "+stringListMap4);
                System.out.println("String UFirs :: "+stringListMap5);
        }
}
