package advanced;

public class ExampleClass {
    public ClassOne abc;   // Stores reference/address of ClassOne object
    public String data;    // Stores reference to String object

    public void example() {
        // Creating object
        abc = new ClassOne("John", 25);
        // abc now stores memory address/reference of the ClassOne object

        data = "Hello";
        // data stores reference to String object "Hello"
    }

    public static void main(String[] args) {
        ExampleClass ex1 = new ExampleClass();
        ExampleClass ex2 = new ExampleClass();

        ex1.abc = new ClassOne("John", 25);
        ex2.abc = ex1.abc;  // Both abc variables now point to same ClassOne object
        System.out.println("ClassOne :::  "+ ex1.abc);
        ex1.data = "Hello";
        ex2.data = ex1.data;  // Both data variables point to same String object
        System.out.println("String class ::: "+ ex2.data);
    }
}
