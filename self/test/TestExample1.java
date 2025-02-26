package self.test;

import interview.Employee;

import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;

public class TestExample1 {

    public static void main(String[] args) throws ParseException {
        List<Employee> employees = new LinkedList<>();
        employees.add(new Employee(1, "pk1",80880));
        employees.add(new Employee(1, "pk2",80450));
        employees.add(new Employee(1, "pk3",4560));

        Map<Integer, List<Employee>> integerListMap =
                employees.stream()
                        .sorted(Comparator.comparing(Employee::getSalary))
                        .filter(sal -> sal.getSalary() > 5000)
                        .collect(Collectors.groupingBy(ele -> ele.getSalary()));

        System.out.println(integerListMap);

        OptionalDouble sal = employees.stream().map(emp -> emp.getSalary())
                .mapToDouble(i->i)
                .average();
        System.out.println(sal.getAsDouble());


    }
}
