package functionalinterface;
@FunctionalInterface
interface Addition {
    int add(int a, int b);
}
public class FunctionalInterfaceExample {
    public static void main(String[] args) {

        // Using method reference to implement the add method
        //Addition addition = Integer::sum;
        // Using lambda expression to implement the add method
        Addition addition = (a, b) -> a + b;
        addition.add(4,5);
        // Using the lambda expression
        int result = addition.add(5, 3);
        System.out.println("Result: " + result);

    }
}
