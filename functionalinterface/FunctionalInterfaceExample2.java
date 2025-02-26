package functionalinterface;

import java.util.function.Function;

public class FunctionalInterfaceExample2 {
    public static void main(String[] args) {
        Power pow = (a, b) -> (int) Math.pow(a, b);
        System.out.println(pow.power(2,3));
    }
}
