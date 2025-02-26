package past.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Test6 {
    public static boolean isPrimeNumber(int number){
        if(number < 1){
            return false;
        }
        if(number ==2 || number ==3 || number == 5 || number==7){
            return true;
        }else{
            return number % 2 !=0 && number % 3 !=0  && number % 5 !=0 && number % 7 !=0;
        }


    }

    public static boolean isPrime(int number){
        if(number < 1){
            return false;
        }

        return IntStream.rangeClosed(2, (int) Math.sqrt(number)) // Check divisibility from 2 to sqrt(number)
                .noneMatch(divisor -> number % divisor == 0); // If any
    }
    public static void main(String[] args) {

        int n =100;
        List<Integer> integerList = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            integerList.add(i);
        }
        List<Integer> listOfPrime  = integerList.stream().filter(Test6::isPrime)
                .toList();
        List<Integer> listOfPrimeNumber  = integerList.stream().filter(Test6::isPrimeNumber)
                .toList();
        List<Integer> listOfPrimeFilter  = integerList.stream().filter(number->number % 2 !=0 && number % 3 !=0  && number % 5 !=0 && number % 7 !=0)
                .toList();

        System.out.println("listOfPrime ::: " +listOfPrime);
        System.out.println("ListOfPrime ::: " +listOfPrimeNumber);
        System.out.println("ListOfPrime ::: " +listOfPrimeFilter);

    }


}
