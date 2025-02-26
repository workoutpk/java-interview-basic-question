I'll help you write a code example demonstrating how to access private variables in Mockito for Java unit testing.



```java
import org.junit.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import java.lang.reflect.Field;

public class PrivateVariableAccessExample {

    // Example class with a private variable
    private static class PrivateFieldClass {
        private String secretValue = "Original Secret";
        
        public String getSecretValue() {
            return secretValue;
        }
    }

    @Test
    public void testAccessPrivateVariableUsingReflection() throws Exception {
        // Create an instance of the class
        PrivateFieldClass instance = new PrivateFieldClass();
        
        // Use Reflection to access and modify the private field
        Field secretField = PrivateFieldClass.class.getDeclaredField("secretValue");
        secretField.setAccessible(true); // Make the private field accessible
        
        // Get the current value
        String originalValue = (String) secretField.get(instance);
        System.out.println("Original Value: " + originalValue);
        
        // Set a new value
        secretField.set(instance, "Modified Secret");
        
        // Verify the new value
        String modifiedValue = instance.getSecretValue();
        System.out.println("Modified Value: " + modifiedValue);
    }

    @Test
    public void testAccessPrivateVariableUsingMockito() throws Exception {
        // Create a spy of the class to allow partial mocking
        PrivateFieldClass spyInstance = Mockito.spy(new PrivateFieldClass());
        
        // Use Mockito's ReflectionTestUtils (requires spring-test dependency)
        // Alternatively, use Java Reflection as shown in the previous method
        org.springframework.test.util.ReflectionTestUtils.setField(
            spyInstance, "secretValue", "Mocked Secret"
        );
        
        // Verify the mocked value
        String mockedValue = spyInstance.getSecretValue();
        System.out.println("Mocked Value: " + mockedValue);
    }

    @Test
    public void testAccessPrivateStaticVariableUsingMockedStatic() {
        // Example of a class with a private static variable
        class PrivateStaticFieldClass {
            private static String staticSecretValue = "Original Static Secret";
            
            public static String getStaticSecretValue() {
                return staticSecretValue;
            }
        }
        
        // Use MockedStatic to mock the static context
        try (MockedStatic<PrivateStaticFieldClass> mockedStatic = 
                Mockito.mockStatic(PrivateStaticFieldClass.class)) {
            
            // Configure the mocked static method to return a specific value
            mockedStatic.when(PrivateStaticFieldClass::getStaticSecretValue)
                        .thenReturn("Mocked Static Secret");
            
            // Verify the mocked static value
            String mockedStaticValue = PrivateStaticFieldClass.getStaticSecretValue();
            System.out.println("Mocked Static Value: " + mockedStaticValue);
        }
    }
}

```

This code demonstrates three approaches to accessing private variables in Java using Mockito and Reflection:

1. **Reflection Method**:
    - Uses Java Reflection to directly access and modify private fields
    - Makes the private field accessible using `setAccessible(true)`
    - Allows getting and setting private variable values

2. **Mockito with Spring's ReflectionTestUtils**:
    - Requires the Spring Test dependency
    - Provides a convenient way to set private field values
    - Works well with Mockito spies

3. **Mocking Static Context**:
    - Demonstrates how to mock static methods and potentially access private static variables
    - Uses Mockito's `MockedStatic` to intercept static method calls

**Dependencies Required:**
- JUnit
- Mockito
- Spring Test (for ReflectionTestUtils, optional)

**Notes:**
- Be cautious when using reflection to access private variables
- This approach should primarily be used for testing
- In production code, consider refactoring if you find yourself frequently needing to access private variables

Would you like me to elaborate on any of these approaches or explain how to set up the dependencies?


```java
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(PowerMockRunner.class)
@PrepareForTest(MyService.class)
public class MyServiceTest {

    @Test
    public void testPrivateMethodMocking() throws Exception {
        MyService myService = PowerMockito.spy(new MyService());

        // Mock the private method
        PowerMockito.doReturn("Mocked Private Method").when(myService, "callPrivateMethod");

        // Call the public method that uses the private method
        String result = myService.process();

        // Verify the result
        assertEquals("Mocked Private Method", result);
    }
}
```