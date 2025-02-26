package string;

import java.util.Arrays;

public class StringExample4 {
    public static void main(String[] args) {
        String input  = "(()))";
        long length  = Arrays.stream(input.split("")).map(ele-> new
                   StringBuffer(ele).reverse()).count();

        System.out.println(length);
        long openCount = input.chars().filter(ch -> ch == '(').count();
        long closeCount = input.chars().filter(ch -> ch == ')').count();

        System.out.println("Number of '(': " + openCount);
        System.out.println("Number of ')': " + closeCount);
        System.out.println("Total parentheses: " + (openCount + closeCount));


    }
}
