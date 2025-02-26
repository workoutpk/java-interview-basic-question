package past.interview;


import java.util.*;
import java.util.stream.Collectors;

public class Test11 {
    public static void main(String[] args) {

        List<EmployeeNew> employeeNewList = Arrays.asList(
                new EmployeeNew("pk1", "city1", 10001 ),
                new EmployeeNew("pk2", "city2", 10002 ),
                new EmployeeNew("p31", "city1", 10003 )
        );
        Map<String, Double> salarySumByCity  = employeeNewList.stream().collect(Collectors.groupingBy(
                EmployeeNew::getCity,
                Collectors.summingDouble(EmployeeNew::getSalary)
        ));

        Map<String, Optional<EmployeeNew>> stringListMap = employeeNewList.stream()
                .collect(Collectors.groupingBy(
                        EmployeeNew::getCity,
                        Collectors.maxBy(Comparator.comparing(EmployeeNew::getSalary))
                ));

        System.out.println(stringListMap);



        Map<String, EmployeeNew> highestSalaryByCity1 = employeeNewList.stream()
                .collect(Collectors.groupingBy(
                        EmployeeNew::getCity,
                        Collectors.reducing((a,b) -> a.getSalary() > b.getSalary() ?a:b)

                )).entrySet().stream()
                .filter(entry -> entry.getValue().isPresent())
                .collect(Collectors.toMap(Map.Entry::getKey, entry->entry.getValue().get()));

        Map<String, EmployeeNew> highestSalaryByCity = employeeNewList.stream()
                .collect(Collectors.groupingBy(
                        EmployeeNew::getCity,
                        Collectors.reducing((e1, e2) -> e1.getSalary() > e2.getSalary() ? e1 : e2)
                ))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue().isPresent())
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().get()));
    }
}
