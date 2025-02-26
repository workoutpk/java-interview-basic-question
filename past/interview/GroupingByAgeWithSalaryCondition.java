package past.interview;

import java.util.*;
import java.util.stream.Collectors;

public class GroupingByAgeWithSalaryCondition {
    public static void main(String[] args) {
        List<EmployeeNew> employees = Arrays.asList(
                new EmployeeNew("John", "New York", 70000),
                new EmployeeNew("Jane", "New York", 80000),
                new EmployeeNew("Mike", "Los Angeles", 60000),
                new EmployeeNew("Sara", "Los Angeles", 95000),
                new EmployeeNew("Tom", "Chicago", 50000),
                new EmployeeNew("Tom", "Chicago", 50000)
        );
        Map<Object, List<EmployeeNew>> employeeNew = employees.stream()
                .collect(Collectors.groupingBy(empObj -> empObj.getSalary() > 70000 ? "Greater than 70000":"Less than or equal to 70000" ));

//        System.out.println(employeeNew);

        List<Employee> employeeList = Arrays.asList(
              new Employee(1,"pk1",21, 100001),
              new Employee(2,"pk2",21, 100002),
              new Employee(3,"pk3",22, 100003),
              new Employee(4,"pk4",23, 100003),
              new Employee(5,"pk5",24, 100004)
        );
        Map<Integer, Optional<Employee>> emp=  employeeList.stream().collect(
                Collectors.groupingBy(
                        Employee::getAge,
                        Collectors.maxBy(Comparator.comparing(Employee::getSalary))
                )
        );

        System.out.println(emp);
    }
}
