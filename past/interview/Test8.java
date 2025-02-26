package past.interview;

import java.util.Arrays;
import java.util.List;

public class Test8 {

    public static int factorial (int num){
        int result  =1;
        if(num > 1){

            return result= num* factorial(num-1);

        }
        return result;
    }
    public static void main(String[] args) {
        int num = 5;
        System.out.println("::::::   "+factorial(num));
        List<Integer> list = Arrays.asList(2,4,6,7,8);
        boolean allEven = list.stream().allMatch(i->{
            System.out.println(i);
            return i%2 == 0;
        });
        System.out.println(allEven);
    }
}
