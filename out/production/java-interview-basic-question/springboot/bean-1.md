The `@Bean` annotation in Spring is used to define a bean explicitly in a configuration class. This is typically done in a class annotated with `@Configuration`. Beans created using `@Bean` can be injected into other parts of the application.

Here’s an example that demonstrates how to use `@Bean` in a Spring Boot application.

---

### **Example: Defining and Using a Bean**

#### 1. **Configuration Class**
Create a `Configuration` class to define beans.

```java
package com.example.springbootexample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public String appMessage() {
        return "Hello from the @Bean-defined Bean!";
    }

    @Bean
    public int randomNumber() {
        return 42; // Example of a simple integer bean
    }
}
```

---

#### 2. **Service Class**
Inject the beans defined in the `AppConfig` into a service.

```java
package com.example.springbootexample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    private final String appMessage;
    private final int randomNumber;

    @Autowired
    public MessageService(String appMessage, int randomNumber) {
        this.appMessage = appMessage;
        this.randomNumber = randomNumber;
    }

    public String getMessage() {
        return appMessage;
    }

    public int getRandomNumber() {
        return randomNumber;
    }
}
```

---

#### 3. **Controller Class**
Expose the service's functionality through a REST API.

```java
package com.example.springbootexample.controller;

import com.example.springbootexample.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/message")
    public String getMessage() {
        return messageService.getMessage();
    }

    @GetMapping("/number")
    public int getRandomNumber() {
        return messageService.getRandomNumber();
    }
}
```

---

#### 4. **Main Application**
Run the Spring Boot application.

```java
package com.example.springbootexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootExampleApplication.class, args);
    }
}
```

---

### **Endpoints**
1. **Get Message**:  
   **URL**: `http://localhost:8080/message`  
   **Response**: `"Hello from the @Bean-defined Bean!"`

2. **Get Random Number**:  
   **URL**: `http://localhost:8080/number`  
   **Response**: `42`

---

### **Explanation**
1. **`@Bean` in `AppConfig`**:
    - `appMessage` bean returns a string message.
    - `randomNumber` bean returns a constant integer.

2. **`MessageService` Constructor Injection**:
   The beans are injected into `MessageService` using constructor-based dependency injection.

3. **`MessageController`**:
   Exposes REST endpoints to access the values provided by the beans.

This is a simple demonstration of `@Bean` usage in Spring Boot. You can define more complex beans, inject them, and even control their scope and initialization using additional configuration.