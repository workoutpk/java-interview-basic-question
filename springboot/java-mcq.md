 ## ** Java MCQ
1. What are the valid statements for static keyword in Java?
   - * A. We can have static block in a class.
   - * B. The static block in a class is executed every time an object of class is created.
   - * C. We can have static method implementations in interface.
   - * D. We can define static block inside a method.
   \
   \
   `Answer` :-  We can have static block in a class, it gets executed only once when class loads. From java 8 onwards, we can have static method implementations in interfaces.
2. Which of the following statements are true for inheritance in Java?
      - * A. The “extend” keyword is used to extend a class in java.
      - * B. You can extend multiple classes in java.
      - * C. Private members of the superclass are accessible to the subclass.
      - * D. We can’t extend Final classes in java.
    \
   \
   `Answer` : -
          **Correct Answer: D
          **
          Inheritance is one of the core concepts in Java. You should be familiar with it. Please read the following articles to learn more about the answer choices - Inheritance in Java, Multiple Inheritance in Java.
3. What will happen if we try to compile and run below program?
   interface Foo{ int x = 10;}

```java 
interface Foo{ int x = 10;}
public class Test {
    public static void main(String[] args) {
    Foo.x = 20;
    System.out.println(Foo.x);
    }
}
```
- * A. Prints 10
- * B. Prints 20
- * C. Compile Time Error
- * D. Runtime error because Foo.x is final.


`Answer`:-  **Correct Answer: C
**
By default, any field of the interface is public, static, and final. So we can’t change is, hence compile-time error at the statement Foo.x = 20;.
4. What will be output of below program?

```java
public class Test {
    public void main(String[] args) {
        int x = 10*20-20;
        System.out.println(x);
    }
}
```

5. What will be the output of below program?
```java

package com.journaldev.java;

public class Test {
	public static void main(String[] args) {
		Super s = new Subclass();
		s.foo();
	}
}

class Super {
	void foo() {
		System.out.println("Super");
	}
}

class Subclass extends Super {
	static void foo() {
		System.out.println("Subclass");
	}
}
```
- * A. Compile time error
- * B. Super
- * C. Subclass
- * D. Runtime error
\
\
**Correct `Answer`: A
**
Subclass foo() method can’t be static, it will give compile time error This static method cannot hide the instance method from Super.


6. What will be the output of below program?
```java

package com.journaldev.java;

public class Test {
	public static void main(String[] args) {
		Subclass s1 = new Subclass();
		s1.foo(); // line 6
		Super s = new Subclass();
		s.foo(); // line 8
	}
}

class Super {
	private void foo() {
		System.out.println("Super");
	}
}

class Subclass extends Super {
	public void foo() {
		System.out.println("Subclass");
	}
}
```

- * A. Compile time error at line 6
- * B. Compile time error at line 8
- * C. Compile time error at both line 6 and 8
- * D. Works fine and prints “Subclass” two times.

\
\
**Correct `Answer`: B
**
Compile time error at line 8 because Super class foo() method is private. The error message is The method foo() from the type Super is not visible.

7. What will be the output of below program?
```java

import java.io.IOException;

public class Test {
	public static void main(String[] args) {
		try {
			throw new IOException("Hello");
		} catch (IOException | Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
```
- * A. Compile-time error
- * B. Prints “Hello”
- * C. Runtime Error

Correct `Answer`: A

Compile-time error as The exception IOException is already caught by the alternative Exception.

8. 12. What will be the output of below program?
```java

public class Test {
	public static void main(String[] args) {
		String x = "abc";
		String y = "abc";
		x.concat(y);
		System.out.print(x);
	}
}
```

- * A. abcabc
- * B. abc
- * C. null

**Correct `Answer`: B
**
x.concat(y); will create a new string but it’s not assigned to x, so the value of x is not changed.

9. Which of the following statement(s) are true for java?
   - * A. JVM is responsible for converting Byte code to the machine-specific code.
   - * B. We only need JRE to run java programs.
   - * C. JDK is required to compile java programs.
   - * D. JRE doesn’t contain JVM

Correct `Answer`: A, B, C

For a complete explanation, read JDK, JRE, and JVM.


10. What will be the output of below code snippet?
   ```java
String s1 = "abc";
String s2 = new String("abc");
s2.intern();
System.out.println(s1 == s2);
```
- * A. false
- * B. true
- * C. null

\
\
    It’s a tricky question and output will be false. We know that intern() method will return the String object reference from the string pool, but since we didn’t assign it back to s2, there is no change in s2. Hence both s1 and s2 are having a different reference.

If we change the code in line 3 to s2 = s2.intern(); then the output will be true.

11. What will be the output of below code snippet?

```java
String s1 = new String("java");
String s2 = new String("JAVA");
System.out.println(s1 = s2);
```

- * A. JAVA
- * B.java
- * C. true
- * D. false

`Answer` : -  It will print “JAVA” because the argument inside the println() method is an assignment. So it will be treated as System.out.println("JAVA").


12. What will be the output of below statements?

```java
String s1 = "abc";
String s2 = new String("abc");
System.out.print(s1==s2);
System.out.println(s1==s2.intern());
```
\
\
Correct `Answer`: A

The s1 is in the string pool whereas s2 is created in heap memory.

Hence s1==s2 will return false.

When s2.intern() method is called, it checks if there is any string with value “abc” in the pool. So it returns the reference of s1. So both s1 and s2 are pointing to the same string instance now.

Hence s1==s2.intern() will return true.