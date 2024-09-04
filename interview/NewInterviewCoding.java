package interview;

import java.util.*;
import java.util.stream.Collectors;

public class NewInterviewCoding {
        public static void main(String[] args) {
                // Create a list of People objects with some duplicates
                List<People> peopleList = new ArrayList<>();
                peopleList.add(new People("Alice", 20));
                peopleList.add(new People("Bob", 25));
                peopleList.add(new People("Charlie", 30));
                peopleList.add(new People("Alice", 20));
                peopleList.add(new People("David", 35));
                peopleList.add(new People("Bob", 25));

                // Print the original list
                System.out.println("Original list:");
                for (People p : peopleList) {
                        System.out.println(p);
                }

                // Create a set of People objects to remove the duplicates
                Set<People> peopleSet = new HashSet<>(peopleList);

                // Print the set after removing the duplicates
                System.out.println("Set after removing duplicates:");
                for (People p : peopleSet) {
                        System.out.println(p);
                }

                Map<Integer,People> integerPeopleMap = new HashMap<>();
                integerPeopleMap.put(1,new People("A1",20));
                integerPeopleMap.put(2,new People("A2",40));
                integerPeopleMap.put(3,new People("A3",50));
                integerPeopleMap.put(4,new People("A4",20));

               People  people1 = new People("P1",40);
               People  people2 = new People("P1",40);
                System.out.println("hasCode of people 1 " + people1.hashCode());
                System.out.println("hasCode of people 2 " + people2.hashCode());

                List<People> people = peopleList.stream()
                        .sorted(Comparator.comparing(People::getAge).reversed())
                        .toList();

                List<People> modifiedList = peopleList.stream()
                        .map(p -> new People(p.getName(), p.getAge() * 2))
                        .toList();
                System.out.println("Modified Age :::  "+modifiedList);
                List<People> people3 = peopleList.stream().filter(p->p.getAge()>20).toList();
                System.out.println("Filter  Age  :::  "+people3);
                Map<Integer,List<People>> people4 = peopleList.stream()
                        .collect(Collectors.groupingBy(People::getAge));
                System.out.println("Grouping By  :::  " + people4);




        }
}
