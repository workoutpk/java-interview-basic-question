package interview;

import java.util.*;

import java.util.function.Function;
import java.util.stream.Collectors;

public class SelFTestClass  {

        public static Optional<Employee> getSecondHighestSalary(List<Employee> employees) {
                // Sort the employees by salary in descending order.
                List<Employee> sortedEmployees = employees.stream()
                        .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                        .toList();

                // Get the second employee in the list.
                return sortedEmployees.size() >= 2 ? Optional.of(sortedEmployees.get(1)) : Optional.empty();
        }

        public static void main(String[] args) {
                String s = "this*is*pk*right";
                Map<String,Long> map1 = Arrays.stream(s.split(""))
                        .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
                System.out.println("Map 1 :: " +map1);

                Map<String,Long> map2 = Arrays.stream(s.split(""))
                        .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                        .entrySet()
                        .stream().map(ele->{
                                return new AbstractMap.SimpleEntry<>(ele.getKey(),ele.getValue()*2);
                        })
                        .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));

                System.out.println("Map 2 :: " +map2);
                Map<String,Long> map3 = Arrays.stream(s.split(""))
                        .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                        .entrySet()
                        .stream()
                        .map(ele->{
                                return new AbstractMap.SimpleEntry<>(ele.getKey(),ele.getValue()*2);
                        })
                        .filter(el -> el.getValue()>2)
                        .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));

                System.out.println("Map 3 :: " +map3);

                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(s);
                String s1 = String.valueOf(stringBuilder.reverse());
                System.out.println("String Example  :::  "+s1 );

                ArrayList<String> arrayList = new ArrayList<>();
                arrayList.add("cat");
                arrayList.add("dog");
                arrayList.add("cat");
                arrayList.add("ox");
                arrayList.add("dog");
                arrayList.add("monkey");
                arrayList.add("dog");

                Map<String,Long> map4 =  arrayList.stream()
                        .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                        .entrySet()
                        .stream()
                        .filter(ele->ele.getValue()>1)
                        .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));

                System.out.println("Duplicate String is " +  map4);

                List<Employee> employeeMap = new LinkedList<>();
                employeeMap.add(new Employee(1,"pk",10000));
                employeeMap.add(new Employee(2,"pl",20000));
                employeeMap.add(new Employee(3,"pk",20000));
                employeeMap.add(new Employee(4,"pu",50000));
                employeeMap.add(new Employee(5,"pt",90000));

                // Sort the employees by salary in ascending order
                List<Employee> sortedEmployees = employeeMap.stream()
                        .sorted(Comparator.comparing(Employee::getSalary).reversed())
                        .toList();

                System.out.println("Sorted Employee :: "+sortedEmployees);



              // Get the second employee in the list.

                Optional<Employee> secondHighestSalary = getSecondHighestSalary(employeeMap);
                if (secondHighestSalary.isPresent()) {
                        System.out.println("The second highest salary is: " + secondHighestSalary.get().getSalary());
                } else {
                        System.out.println("There is no second highest salary.");
                }

                HashSet<String> employeeHashSet = new HashSet<>();
                // Iterate over the employees and add their names to the set
                for (Employee employee : employeeMap) {
                        employeeHashSet.add(employee.getName());
                }
                System.out.println("Unique Employee :: " +employeeHashSet);
        }
}
