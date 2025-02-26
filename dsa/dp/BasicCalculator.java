package dsa.dp;

import java.util.Stack;

public class BasicCalculator {

    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int currentNumber = 0;
        int result = 0;
        int sign = 1; // 1 means positive, -1 means negative

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                currentNumber = currentNumber * 10 + (ch - '0'); // Build the current number
            } else if (ch == '+') {
                result += sign * currentNumber; // Update result with the current number
                currentNumber = 0; // Reset current number
                sign = 1; // Set sign to positive
            } else if (ch == '-') {
                result += sign * currentNumber; // Update result with the current number
                currentNumber = 0; // Reset current number
                sign = -1; // Set sign to negative
            } else if (ch == '(') {
                // Push the result and sign onto the stack
                stack.push(result);
                stack.push(sign);
                result = 0; // Reset result for the new expression
                sign = 1; // Reset sign to positive
            } else if (ch == ')') {
                result += sign * currentNumber; // Update result with the last number
                currentNumber = 0; // Reset current number
                result *= stack.pop(); // Multiply by the last sign
                result += stack.pop(); // Add the last result
            }
        }

        // Final update for the last number in case there's no operator after it
        result += sign * currentNumber;

        return result;
    }

    public static void main(String[] args) {
        BasicCalculator calculator = new BasicCalculator();

        String expression1 = "1 + 1";
        System.out.println("Result of '" + expression1 + "': " + calculator.calculate(expression1)); // Outputs: 2

        String expression2 = " 2-1 + 2 ";
        System.out.println("Result of '" + expression2 + "': " + calculator.calculate(expression2)); // Outputs: 3

        String expression3 = "(1+(4+5+2)-3)+(6+8)";
        System.out.println("Result of '" + expression3 + "': " + calculator.calculate(expression3)); // Outputs: 23
    }
}

