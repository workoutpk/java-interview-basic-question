When a String is created using a new operator, it always created in the heap memory. Whereas when we create a string using double quotes, it will check for the same value as of the string in the string constant pool. If it is found, returns a reference of it else create a new string in the string constant pool.

When we create a String using the `new` operator in Java, it follows this memory allocation pattern:

1. The String object itself is stored in the Heap Memory
2. The String literal (actual text content) is stored in the String Pool (which is part of the Heap)

Here's a detailed explanation with examples:

```java
String str1 = "Hello";                    // Goes directly to String Pool
String str2 = new String("Hello");        // Creates object in Heap

// Memory breakdown for str2:
// 1. "Hello" literal goes to String Pool
// 2. new String object created in Heap
// 3. This Heap object references the literal in String Pool
```

Key points to understand:

1. Using `new` operator always creates a new object in the Heap, even if identical String content exists
```java
String str1 = new String("Hello");
String str2 = new String("Hello");
System.out.println(str1 == str2);         // false (different heap objects)
System.out.println(str1.equals(str2));    // true (same content)
```

2. String Pool optimization:
```java
String str1 = "Hello";                    // String Pool
String str2 = "Hello";                    // Reuses same Pool reference
System.out.println(str1 == str2);         // true (same reference)
```

3. Forcing a String to Pool:
```java
String str = new String("Hello").intern(); // Forces string to use Pool
```

This memory management approach helps Java optimize string storage while maintaining object-oriented principles. Understanding this is crucial for memory-efficient string handling in Java applications.