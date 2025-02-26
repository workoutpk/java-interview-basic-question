package past.interview;

import java.util.Arrays;
import java.util.List;

public class Infosys {
    public static boolean isPalindrome(int x){
//        case1 121
//        x = -121
        int a = x;
        int b = 0;
        String c = String.valueOf(x);
        String d = Arrays.toString(c.split(""));
        for (int i = d.length()-1 ; i > 0; i--) {
        }
        return a ==b;
    }
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }
}
