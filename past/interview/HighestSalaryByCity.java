package past.interview;

import java.util.*;
import java.util.stream.Collectors;

public class HighestSalaryByCity {
    public static void main(String[] args) {
        List<EmployeeNew> employees = Arrays.asList(
                new EmployeeNew("John", "New York", 70000),
                new EmployeeNew("Jane", "New York", 80000),
                new EmployeeNew("Mike", "Los Angeles", 60000),
                new EmployeeNew("Sara", "Los Angeles", 95000),
                new EmployeeNew("Tom", "Chicago", 50000)
        );


        Map<String, EmployeeNew> highestSalaryByCity = employees.stream()
                .collect(Collectors.groupingBy(
                        EmployeeNew::getCity,
                        Collectors.reducing((e1, e2) -> e1.getSalary() > e2.getSalary() ? e1 : e2)
                ))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue().isPresent())
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().get()));

//        highestSalaryByCity.values().forEach(System.out::println);
        System.out.println(highestSalaryByCity);

        // Find the highest-salary employee in each city
        Map<String, Optional<EmployeeNew>> highestSalaryByCityNew = employees.stream()
                .collect(Collectors.groupingBy(
                        EmployeeNew::getCity,  // Group by city
                        Collectors.maxBy(Comparator.comparing(EmployeeNew::getSalary))  // Find the employee with max salary in each group
                ));

        System.out.println("In Case Of not tie ..............");
        // Print results
        highestSalaryByCityNew.forEach((city, employee) ->
                System.out.println("City: " + city + ", Highest Salary Employee: " + employee.orElse(null))
        );


        Map<String, List<EmployeeNew>> highestSalaryByCityTie = employees.stream()
                .collect(Collectors.groupingBy(
                        EmployeeNew::getCity,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparing(EmployeeNew::getSalary)),
                                maxSalaryEmployee -> employees.stream()
                                        .filter(e -> e.getCity().equals(maxSalaryEmployee.get().getCity()) &&
                                                e.getSalary() == maxSalaryEmployee.get().getSalary())
                                        .collect(Collectors.toList())
                        )
                ));

        System.out.println("In Case Of with tie ..............");
        System.out.println(highestSalaryByCityTie);

        //Find duplicate list object
        Map<EmployeeNew, Long> countMap = employees.stream()
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        // Filter out employees that appear more than once
        //return countMap.entrySet().stream()
                //.filter(entry -> entry.getValue() > 1)
                //.map(Map.Entry::getKey)
                //.collect(Collectors.toList());

        System.out.println("Duplicate object is ::  " + countMap);


    }

}
