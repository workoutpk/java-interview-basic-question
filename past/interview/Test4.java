package past.interview;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test4 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,9,10);
        List<Integer> oddNumbers = numbers.stream()
                .filter(f-> f % 2 !=0).toList();
        System.out.println("Odd Number List " +  oddNumbers);

        List<Employee> employees =  Arrays.asList(
                new Employee(1, "pk1", 31, 10001),
                new Employee(2, "pk2", 32, 10002),
                new Employee(3, "pk3", 33, 10003)

        );
        Map<Integer, Employee> employeeMap = employees.stream().map(m->{
            return new AbstractMap.SimpleEntry<>(m.id, m);
        }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));


        System.out.println("Employee list with Map" +  employeeMap);
        List<Employee> employeeList = employeeMap.entrySet()
                .stream().map(m->m.getValue())
                        .filter(f-> f.getId() % 2 ==0)
                                .map(m-> new Employee(m.getId(),m.getName(), m.getAge(),m.getSalary()))
                                        .toList();

        System.out.println("After incremented salary "+employeeList);
    }
}
