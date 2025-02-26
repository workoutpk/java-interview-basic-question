package string;

import java.util.Locale;

public class StringExample2 extends StringExample1{

//    @Override
//    public String modifiedString (String s){
//        System.out.println("This is child method");
//        return s.toUpperCase(Locale.ROOT);
//    }
    public Integer modifiedString (Integer s){
        System.out.println("This is child method");
        return 5;
    }

    public static void main(String[] args) {
        String str = "Hello, World!";
        System.out.println(str.charAt(10));
        String s1 = new String("ab");
        String s2 = new String("ab");
//        System.out.println(s1 == s2);
//        System.out.println(s1.equals(s2));
        StringExample2 stringExample2 =  new StringExample2();
        System.out.println(  stringExample2.modifiedString("Pk Prajapati"));
    }
}
