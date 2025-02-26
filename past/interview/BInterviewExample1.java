package past.interview;

import java.util.*;
import java.util.stream.Collectors;

public class BInterviewExample1 {
    public static void main(String[] args) {
        List<Employee> empList = List.of(new Employee(101,"emp1",25, 10000),
                new Employee(102,"emp2", 20,20000),
                new Employee(103,"emp3", 35,30000),
                new Employee(104,"emp4", 40,40000)
        );

        List<Employee> updatedEmpList = empList.stream()
                .map(employee -> {
                    if (employee.getAge() > 30) {
                        long increasedSalary = employee.getSalary() + (int) (employee.getSalary() * 0.3);
                        return new Employee(employee.getId(), employee.getName(), employee.getAge(), increasedSalary);
                    }
                    return employee;
                })
                .toList();

        System.out.println("UpdatedEmpList ::: "+updatedEmpList);

        List<Employee> employeeListSorted = empList.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed()).toList();
        System.out.println("EmployeeListSorted :::  "+ employeeListSorted);

        Map<Integer, List<Employee>> employeesByAge =  empList.stream().collect(Collectors.groupingBy(Employee::getAge));

        System.out.println("employeesByAge ::: " + employeesByAge);

        Map<Integer, List<Employee>> gropingByAge =  empList.stream()
                .map(employee -> {
                    long increasedSalary = 0;
                    if(employee.getAge() > 30){
                        increasedSalary = (long) (employee.getSalary() + employee.getSalary() * 0.3);
                    }else {
                        increasedSalary = (long) (employee.getSalary() + employee.getSalary() * 0.1);
                    }
                    return new Employee(employee.getId(), employee.getName(), employee.getAge(), increasedSalary);
                }).collect(Collectors.groupingBy(Employee::getAge));
        System.out.println("gropingByAge ::: " + gropingByAge);


        int n = 2; // Replace with the nth highest you want to find

        Optional<Employee> nthHighestSalaryEmployee = empList.stream()
                .sorted(Comparator.comparingLong(Employee::getSalary).reversed()) // Sort by salary in descending order
                .skip(n - 1)  // Skip n-1 employees to get the nth one
                .findFirst();  // Get the nth employee

        if (nthHighestSalaryEmployee.isPresent()) {
            System.out.println("The " + n + "th highest salary is: " + nthHighestSalaryEmployee.get());
        } else {
            System.out.println("No such employee with " + n + "th highest salary");
        }
    }
}
