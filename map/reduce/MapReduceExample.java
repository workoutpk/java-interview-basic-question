package map.reduce;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MapReduceExample {

        public static void main(String[] args) {

                List<Integer> numbers = Arrays.asList(3, 7, 8, 1, 5, 9);

                List<String> words = Arrays.asList("corejava", "spring", "hibernate");

                int sum = 0;
                for (int no : numbers) {
                        sum = sum + no;
                }
                System.out.println("Sum By for Loop  :: "+sum);

                int sum1 = numbers.stream().mapToInt(i -> i).sum();
                System.out.println("Sum By for mapToInt  ::  "+sum1);

                Integer reduceSum = numbers.stream().reduce(0, (a, b) -> a + b);
                System.out.println("Sum By for mapToInt  ::  "+ reduceSum);

                Optional<Integer> reduceSumWithMethodReference = numbers.stream().reduce(Integer::sum);
                System.out.println(reduceSumWithMethodReference.get());

                Integer mulResult = numbers.stream().reduce(1, (a, b) -> a * b);
                System.out.println(mulResult);

                Integer maxvalue = numbers.stream().reduce(0, (a, b) -> a > b ? a : b);
                System.out.println("Maxvalue by Reduce ::  "+maxvalue);

                Integer maxvalueWithMethodReference = numbers.stream().reduce(Integer::max).get();
                System.out.println(maxvalueWithMethodReference);


                String longestString = words.stream()
                        .reduce((word1, word2) -> word1.length() > word2.length() ? word1 : word2)
                        .get();
                System.out.println("LongestString ::  "+longestString);

                //get employee whose grade A
                //get salary
                double avgSalary = EmployeeDatabase.getEmployees().stream()
                        .filter(employee -> employee.getGrade().equalsIgnoreCase("A"))
                        .map(employee -> employee.getSalary())
                        .mapToDouble(i -> i)
                        .average().getAsDouble();

                System.out.println("avgSalar ::  "+avgSalary);

                double sumSalary = EmployeeDatabase.getEmployees().stream()
                        .filter(employee -> employee.getGrade().equalsIgnoreCase("A"))
                        .map(employee -> employee.getSalary())
                        .mapToDouble(i -> i)
                        .sum();
                System.out.println("sumSalary :: "+sumSalary);
        }


}
