package string;

import java.util.Locale;

public class StringExample1 {

    public String modifiedString (String s){
        System.out.println("This is parent method");
        return s.toUpperCase(Locale.ROOT);
    }
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("123");
        StringBuffer sb1 = new StringBuffer(sb);
        sb.append("4");
        System.out.println(sb1.toString());
        System.out.println("Division ");
        int num1 = 45;
        int num2 = 35;
        double res = num1 / num2;
        System.out.println(res);

        int x = 10;
        double y = 5.5;
        System.out.println(x * y);

        int a = 5, b = 20;
        a += ++b;
        System.out.println(a);
    }
}
