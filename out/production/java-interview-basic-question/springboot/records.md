# Memory API
In Java, records are a special kind of class introduced in Java 14 (as a preview feature) and finalized in later versions, designed to simplify the creation of immutable data carrier classes. They provide a concise syntax for defining classes that primarily hold data without the boilerplate code typically associated with standard class definitions. Here’s a detailed overview of records in Java:

Here's a comprehensive guide to Java Records:

1. Basic Record Declaration
```java
public record Person(String name, int age) {
    // Compact constructor
}
```

2. Canonical Constructor
```java
public record Person(String name, int age) {
    // Explicit canonical constructor
    public Person {
        // Validation logic
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
    }
}
```

3. Custom Methods in Record
```java
public record Employee(
    String name, 
    double salary, 
    Department department
) {
    // Additional method
    public String getFullDetails() {
        return name + " works in " + department.getName();
    }
}
```

4. Static Methods and Fields
```java
public record Point(int x, int y) {
    // Static field
    public static Point ORIGIN = new Point(0, 0);
    
    // Static method
    public static double distance(Point p1, Point p2) {
        return Math.sqrt(
            Math.pow(p1.x() - p2.x(), 2) + 
            Math.pow(p1.y() - p2.y(), 2)
        );
    }
}
```

5. Implementing Interfaces
```java
public record User(String username, String email) 
    implements Serializable, Comparable<User> {
    
    @Override
    public int compareTo(User other) {
        return this.username.compareTo(other.username);
    }
}
```

Key Characteristics:
- Immutable by default
- Automatically generates:
    - Constructor
    - Getter methods
    - equals() method
    - hashCode() method
    - toString() method
- Compact and readable

6. Complex Record with Validation
```java
public record ComplexPerson(
    String name, 
    int age, 
    String email
) {
    // Compact constructor with comprehensive validation
    public ComplexPerson {
        Objects.requireNonNull(name, "Name cannot be null");
        Objects.requireNonNull(email, "Email cannot be null");
        
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        
        if (age < 0 || age > 150) {
            throw new IllegalArgumentException("Invalid age");
        }
        
        if (!email.contains("@")) {
            throw new IllegalArgumentException("Invalid email format");
        }
    }
    
    // Additional derived method
    public boolean isAdult() {
        return age >= 18;
    }
}
```

7. Generic Records
```java
public record Pair<T, U>(T first, U second) {
    public static <T, U> Pair<T, U> of(T first, U second) {
        return new Pair<>(first, second);
    }
}
```

8. Nested Records
```java
public class Company {
    public record Employee(
        String name, 
        double salary, 
        Department department
    ) {}
    
    public record Department(
        String name, 
        String location
    ) {}
}
```

Use Cases:
- Data Transfer Objects (DTOs)
- Immutable data containers
- Simple domain models
- Configuration holders

Advantages:
- Reduced boilerplate code
- Immutability by default
- Built-in methods
- Easy to read and maintain
- Null-safety support

Limitations:
- Cannot extend other classes
- All fields are final
- No mutable state

Best Practices:
- Use for simple data carriers
- Validate in compact constructor
- Keep records focused and single-purpose
- Use for immutable data
- Leverage for clean, concise code

Comparison with Traditional Classes:
```java
// Traditional Class
public class PersonClass {
    private final String name;
    private final int age;
    
    // Constructor, getters, equals, hashCode, toString
}

// Record
public record PersonRecord(String name, int age) {}
```

Performance Considerations:
- Minimal overhead
- Compiler-generated methods
- Efficient memory usage
- Good for small data structures

Compatibility:
- Introduced in Java 14
- Became standard in Java 16
- Fully supported in Java 17+

IDE Support:
- IntelliJ IDEA
- Eclipse
- NetBeans
- Visual Studio Code

Example in Real-world Scenario:
```java
public record ApiResponse<T>(
    int statusCode, 
    String message, 
    T data
) {
    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(200, "Success", data);
    }
    
    public static <T> ApiResponse<T> error(String message) {
        return new ApiResponse<>(400, message, null);
    }
}
```

Recommended Usage:
- Simple data structures
- Immutable objects
- Transfer objects
- Configuration parameters
- API responses