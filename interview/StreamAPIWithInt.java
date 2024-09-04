package interview;

import java.util.*;
import java.util.stream.Collectors;

public class StreamAPIWithInt {
        public static void main(String[] args) {
                int[] number ={4,1,13,90,16,20};
                Integer numberList[] = {5,null,6,8,9,null};
                int sum1 = Arrays.stream(number).sum();
                Optional<Integer> max1 = Arrays.stream(number).boxed().reduce(Integer::max);
                OptionalInt min1= Arrays.stream(number).reduce(Integer::min);
                System.out.println(sum1);
                System.out.println(max1.get());
                System.out.println(min1.getAsInt());
                List<Integer> notNull =  Arrays.stream(numberList).filter(Objects::nonNull).toList();
                System.out.println(notNull);
                List<Integer> evenNumbers = Arrays.stream(number).boxed()
                        .filter(num -> num % 2 == 0).collect(Collectors.toList());
                List<Integer> addNumber = Arrays.stream(number).boxed()
                        .map(num-> num+2)
                        .toList();

                System.out.println(evenNumbers);
                System.out.println(addNumber);



                Integer s3[] ={7,6,8,2,9};

                int secondHighestNumer = Arrays.stream(s3).sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
                System.out.println(secondHighestNumer);
        }
}
