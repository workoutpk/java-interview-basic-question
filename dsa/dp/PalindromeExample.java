package dsa.dp;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PalindromeExample {
    public static boolean isPalindrome(String s){
        String normalString = String.valueOf(s.toLowerCase());
        StringBuffer stringBuffer = new StringBuffer(normalString);
        String reverseString = String.valueOf(stringBuffer.reverse());
        return normalString.equals(reverseString);
    }
    public static void main(String[] args) {
        System.out.println(" isPalindrome ::: " + isPalindrome("Radar"));
        System.out.println(" isPalindrome ::: " + isPalindrome("Hello"));
    }
}
