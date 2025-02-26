package string;

public class StringExample3 {
    public static void main(String[] args) {
        String quote = "The only impossible journey is the one you never begin.";
        System.out.println(quote.toUpperCase());
        int a = 10;
        int b = a++ + ++a;
        System.out.println(b);
        String str = "Hello World";
        System.out.println(str.matches("[A-Za-z0-9 ]*"));
        int x = 5;
        if (x++ > 5 && ++x < 10) {
            System.out.println(x);
        } else {
            System.out.println(++x);
        }

        int c = 5;
        int d = 7;
        System.out.println(c | d);

    }
}
