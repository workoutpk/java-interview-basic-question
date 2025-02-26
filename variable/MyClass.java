package variable;

public class MyClass {
    // Static variable
    private static int staticCounter = 0;

    // Instance variable
    private int instanceCounter;

    public MyClass() {
        staticCounter++;
        instanceCounter++;
    }

    public static int getStaticCounter() {
        return staticCounter;
    }

    public int getInstanceCounter() {
        return instanceCounter;

    }

    public static void main(String[] args) {
        MyClass object1 = new MyClass();
        MyClass object2 = new MyClass();

        // Accessing static variable
        System.out.println("Static counter: " + MyClass.getStaticCounter());

        // Accessing instance variables
        System.out.println("Object 1 instance counter: " + object1.getInstanceCounter());
        System.out.println("Object 2 instance counter: " + object2.getInstanceCounter());
    }
}
