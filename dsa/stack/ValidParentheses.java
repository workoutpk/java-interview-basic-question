package dsa.stack;

import java.util.Stack;

public class ValidParentheses {
    public static boolean isValid(String s) {
        Stack<Character>  stack = new Stack<>();
        for (char c : s.toCharArray()) {
            // Push opening brackets onto the stack
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            // Handle closing brackets
            else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    return false; // No matching opening bracket
                }

                char top = stack.pop();

                // Check if the current closing bracket matches the top opening bracket
                if ((c == ')' && top != '(') ||
                        (c == '}' && top != '{') ||
                        (c == ']' && top != '[')) {
                    return false;
                }
            }
        }

        // If stack is empty at the end, parentheses are balanced
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        String s = "(())){{}}";
        System.out.println("Is the string valid? " + isValid(s));
    }
}
