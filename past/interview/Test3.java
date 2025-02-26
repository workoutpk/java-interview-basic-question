package past.interview;


import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.Stack;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test3 {
    public static int longestValidParenthesis(String s ){
        int count = 0;
        String[] sArray = s.split("");
        Stack<String> stringStack = new Stack<>();
        if(s.isEmpty()){
            return 0;
        }
        for (int i = 0; i < sArray.length; i++) {
          if(sArray[i].equals("(")){
              stringStack.push(sArray[i]);
          }else {
              if(!stringStack.isEmpty()){
                  stringStack.pop();
                  count = count+2;
              }
          }

        }
        return count;
    }
    public static void main(String[] args) {
        String s = "";
        System.out.println(longestValidParenthesis(s));

        // Test Cases
        String[] testCases = {
                "(()",
                ")()())",
                "",
                ")(",
                "()(())",
                "()(()"
        };

        for (String testCase : testCases) {
            System.out.println("Input: " + testCase);
            System.out.println("DP Solution: " +
                    longestValidParenthesis(testCase));

            System.out.println();
        }
    }
}
