package interview;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class InterviewTest2 {


        public static void main(String[] args) {

                List<People> peopleList = new LinkedList<>();
                peopleList.add(new People("Alice", 21));
                peopleList.add(new People("Max", 20));
                peopleList.add(new People("Jhon", 20));

                System.out.println(peopleList);

                Map<Integer,List<People>> people = peopleList.stream()

                        .collect(Collectors.groupingBy(ele->ele.getAge()));

                System.out.println(people);

                List<People> people1 = peopleList.stream()
                        .sorted(Comparator.comparing(People::getName))
                        .toList();
                System.out.println("Sorted People"+people1);

                List<String>  stringList = Arrays.asList("ab","ab","abc");
                List<String> queries =Arrays.asList("ab","abc","bc");

        }
}
