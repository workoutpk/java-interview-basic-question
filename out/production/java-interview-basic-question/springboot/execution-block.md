### Execution of Java Class

* `Static block`,
* `instance block`,
* `constructor`,
* and `method`


In Java, the execution order of a class with a **static block**, **instance block**, **constructor**, and a **method** is well-defined. The order depends on when the class is loaded and when an object is created. Here's the breakdown:

---

### **Execution Order**

1. **Static Block**:
    - Executes when the class is loaded into memory (only once during the lifetime of the program).
    - Executes before any instance of the class is created or any method is called.

2. **Instance Block**:
    - Executes each time an instance of the class is created.
    - Executes just before the constructor is called.

3. **Constructor**:
    - Executes after the instance block.
    - Constructs the object.

4. **Method**:
    - Executes when explicitly called after the object is created.

---

### **Example Code**

```java
public class ExecutionOrder {

    // Static block
    static {
        System.out.println("Static block executed");
    }

    // Instance block
    {
        System.out.println("Instance block executed");
    }

    // Constructor
    public ExecutionOrder() {
        System.out.println("Constructor executed");
    }

    // Method
    public void display() {
        System.out.println("Method executed");
    }

    // Main method
    public static void main(String[] args) {
        System.out.println("Main method starts");

        // Create the first object
        ExecutionOrder obj1 = new ExecutionOrder();
        obj1.display();

        System.out.println("Create another object");

        // Create the second object
        ExecutionOrder obj2 = new ExecutionOrder();
        obj2.display();

        System.out.println("Main method ends");
    }
}
```

---

### **Output**
```plaintext
Static block executed
Main method starts
Instance block executed
Constructor executed
Method executed
Create another object
Instance block executed
Constructor executed
Method executed
Main method ends
```

---

### **Explanation**
1. **Static block**: Runs when the class is loaded into memory. It executes only once.
2. **Main method**: Starts executing after the static block.
3. **Instance block**: Runs before the constructor every time a new object is created.
4. **Constructor**: Runs after the instance block to initialize the object.
5. **Method**: Executes when explicitly called.

---

### **Key Notes**
- Static blocks are executed only once, regardless of how many objects are created.
- Instance blocks and constructors execute each time an object is instantiated.
- Methods must be explicitly invoked and don't execute unless called.