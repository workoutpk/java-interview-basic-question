The contract between hashCode() and equals() methods in Java is a fundamental concept that ensures proper behavior of hash-based collections. Here are the key rules of this contract:

1. **If two objects are equal according to equals(), they MUST have the same hashCode()**:
```java
public class Person {
    private String name;
    private int age;
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return age == person.age && Objects.equals(name, person.name);
    }
    
    @Override
    public int hashCode() {
        // Must return same hash for equal objects
        return Objects.hash(name, age);
    }
}
```

2. **If two objects have the same hashCode(), they are NOT required to be equal**:
```java
public class BadExample {
    private int id;
    
    @Override
    public int hashCode() {
        return 42; // Bad practice: all objects return same hash
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        BadExample other = (BadExample) obj;
        return id == other.id;
    }
}
```

3. **Multiple invocations of hashCode() must consistently return the same value**:
```java
public class ImmutablePerson {
    private final String name;
    private final int age;
    
    // Cached hashCode for consistent return value
    private final int hashCode;
    
    public ImmutablePerson(String name, int age) {
        this.name = name;
        this.age = age;
        this.hashCode = Objects.hash(name, age);
    }
    
    @Override
    public int hashCode() {
        return hashCode;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ImmutablePerson person = (ImmutablePerson) obj;
        return age == person.age && Objects.equals(name, person.name);
    }
}
```

4. **A complete example showing proper implementation**:
```java
public class Student {
    private String name;
    private int id;
    private String email;
    
    // Constructor
    public Student(String name, int id, String email) {
        this.name = name;
        this.id = id;
        this.email = email;
    }
    
    @Override
    public boolean equals(Object obj) {
        // 1. Reference check
        if (this == obj) return true;
        
        // 2. Null check and class check
        if (obj == null || getClass() != obj.getClass()) return false;
        
        // 3. Cast to correct type
        Student student = (Student) obj;
        
        // 4. Compare significant fields
        return id == student.id && 
               Objects.equals(name, student.name) && 
               Objects.equals(email, student.email);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(name, id, email);
    }
}
```

5. **Example showing the impact in HashSet**:
```java
public class HashSetExample {
    public static void main(String[] args) {
        Set<Student> students = new HashSet<>();
        
        Student student1 = new Student("John", 1, "john@email.com");
        Student student2 = new Student("John", 1, "john@email.com");
        
        students.add(student1);
        students.add(student2);
        
        // Will print 1 because equals() and hashCode() are properly implemented
        System.out.println(students.size());
        
        // Will return true because equals() is properly implemented
        System.out.println(student1.equals(student2));
        
        // Will return true because hashCode() is properly implemented
        System.out.println(student1.hashCode() == student2.hashCode());
    }
}
```

6. **Common pitfalls to avoid**:
```java
public class CommonPitfalls {
    private String name;
    private List<String> attributes;
    
    // BAD: Using mutable field directly in hashCode
    @Override
    public int hashCode() {
        return attributes.hashCode(); // Don't do this!
    }
    
    // GOOD: Create a defensive copy or use immutable fields
    @Override
    public int hashCode() {
        return Objects.hash(name, attributes == null ? null : new ArrayList<>(attributes));
    }
    
    // BAD: Inconsistent equals and hashCode
    @Override
    public boolean equals(Object obj) {
        // ... compares name and attributes
    }
    @Override
    public int hashCode() {
        return Objects.hash(name); // Only uses name! Don't do this!
    }
}
```

Key points to remember:
1. Always override both methods together
2. Use the same fields in both methods
3. Ensure hashCode() is consistent
4. Consider caching hashCode() for immutable objects
5. Be careful with mutable fields
6. Use Objects.hash() and Objects.equals() for clean implementations
7. Test both methods together using hash-based collections

This contract is crucial for:
- Proper functioning of HashSet, HashMap, and other hash-based collections
- Maintaining consistency in collections
- Ensuring proper object comparison and equality checks

The consequences of breaking this contract include:
- Duplicate entries in hash-based collections
- Inability to find objects in collections
- Inconsistent behavior in applications
- Performance degradation in hash-based collections