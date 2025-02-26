package past.interview;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class InterviewExample3 {
    public static void main(String[] args) {
        List<Employee> employeeList = List.of(
                new Employee(1, "pk1", 21, 10001),
                new Employee(2, "pk2", 22, 10002),
                new Employee(3, "pk3", 23, 10003),
                new Employee(4, "pk4", 24, 10004),
                new Employee(5, "pk5", 25, 10005)
        );
        int n =2;
        Optional<Employee> optional = employeeList.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .skip(n-1)
                .findFirst();
        Optional<Long>  optionalEmployee = employeeList.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .map(emp -> emp.getSalary())
                .skip(n-1)
                .findFirst();

        System.out.println(optional.get());
        System.out.println(optionalEmployee.get());
    }
}
