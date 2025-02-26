### Differences Between `Hashtable` and `HashMap` in Java

| **Aspect**            | **`Hashtable`**                                                                 | **`HashMap`**                                                      |
|------------------------|--------------------------------------------------------------------------------|-------------------------------------------------------------------|
| **Thread Safety**      | Thread-safe: Methods are synchronized, making it suitable for multithreaded environments. | Not thread-safe: Requires external synchronization if used in multithreaded environments. |
| **Performance**        | Slower due to synchronization overhead.                                        | Faster as it is not synchronized.                               |
| **Null Keys/Values**   | Does not allow `null` keys or `null` values.                                   | Allows one `null` key and multiple `null` values.               |
| **Inheritance**        | Extends the `Dictionary` class (an older class, now considered legacy).        | Implements the `Map` interface.                                 |
| **Introduced In**      | Java 1.0                                                                      | Java 1.2 (as part of the Java Collections Framework).           |
| **Iteration Order**    | Unordered, but typically consistent across runs.                              | Unordered; iteration order may vary based on hash and insertion. |
| **Usage**              | Suitable for legacy multithreaded applications.                               | Preferred in modern applications, especially when thread safety is not required. |
| **Fail-Fast Behavior** | Iterators are not fail-fast (legacy behavior).                                | Iterators are fail-fast (throw `ConcurrentModificationException` on modification during iteration). |
| **Concurrency Options**| Limited to basic synchronization.                                              | Use `ConcurrentHashMap` for thread-safe, modern alternatives.   |

---

### Key Code Differences:

#### **Hashtable Example**
```java
import java.util.Hashtable;

public class HashtableExample {
    public static void main(String[] args) {
        Hashtable<Integer, String> table = new Hashtable<>();
        table.put(1, "Apple");
        table.put(2, "Banana");
        
        // table.put(null, "NullKey"); // Throws NullPointerException
        // table.put(3, null); // Throws NullPointerException
        
        System.out.println(table);
    }
}
```

#### **HashMap Example**
```java
import java.util.HashMap;

public class HashMapExample {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "Apple");
        map.put(2, "Banana");
        map.put(null, "NullKey"); // Allows null key
        map.put(3, null); // Allows null value
        
        System.out.println(map);
    }
}
```

---

### Choosing Between `Hashtable` and `HashMap`
- Use **`HashMap`** for better performance in single-threaded or lightly concurrent scenarios.
- Use **`Hashtable`** only in legacy codebases; prefer **`ConcurrentHashMap`** for modern thread-safe needs.