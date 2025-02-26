package pojo;

public class JavaString {
    public static void main(String[] args) {
        String s1 = new String("Java");
        String s2 = new String("Java");
        //s1 and s2 refer to different objects

        System.out.println(s1.equals(s2)); // check reference
        System.out.println(s1 == s2);     //check Object
    }
}
