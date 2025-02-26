Let me explain what is stored in these variables with examples:

```java
class ClassOne {
    private String name;
    private int age;
    
    // Constructor
    public ClassOne(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

class ExampleClass {
    public ClassOne abc;   // Stores reference/address of ClassOne object
    public String data;    // Stores reference to String object
    
    public void example() {
        // Creating object
        abc = new ClassOne("John", 25);
        // abc now stores memory address/reference of the ClassOne object
        
        data = "Hello";
        // data stores reference to String object "Hello"
    }
}
```

Key points about variable storage:

1. **ClassOne abc**:
    - Stores a reference (memory address) to a ClassOne object
    - Default value is null if not initialized
    - Not the actual object, just points to where object is stored in heap memory

2. **String data**:
    - Stores a reference to a String object
    - Also null by default if not initialized
    - String is also a class in Java, so it stores reference like ClassOne

Example of reference behavior:
```java
ExampleClass ex1 = new ExampleClass();
ExampleClass ex2 = new ExampleClass();

ex1.abc = new ClassOne("John", 25);
ex2.abc = ex1.abc;  // Both abc variables now point to same ClassOne object

ex1.data = "Hello";
ex2.data = ex1.data;  // Both data variables point to same String object
```

Understanding References:
- Variables of class types store memory addresses/references
- Multiple variables can reference same object
- Changing object through one reference affects all references
- When object has no references, it becomes eligible for garbage collection

Would you like me to elaborate on any aspect of reference variables or provide more examples?