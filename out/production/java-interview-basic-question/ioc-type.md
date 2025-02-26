I'll explain the key differences between BeanFactory and ApplicationContext in Spring Framework.

```java
// 1. Basic BeanFactory Example
public class BeanFactoryExample {
    public static void main(String[] args) {
        // Creating a BeanFactory
        BeanFactory beanFactory = new XmlBeanFactory(
            new ClassPathResource("beanFactory-config.xml"));
        
        // Lazy loading - bean is created only when requested
        MyService service = beanFactory.getBean("myService", MyService.class);
        service.doSomething();
    }
}

// 2. ApplicationContext Example
public class ApplicationContextExample {
    public static void main(String[] args) {
        // Creating an ApplicationContext
        ApplicationContext context = 
            new ClassPathXmlApplicationContext("applicationContext-config.xml");
        
        // Beans are eagerly initialized by default
        MyService service = context.getBean("myService", MyService.class);
        service.doSomething();
    }
}

// 3. Event Handling in ApplicationContext
@Component
public class CustomEventPublisher {
    @Autowired
    private ApplicationEventPublisher eventPublisher;
    
    public void publishEvent() {
        CustomEvent event = new CustomEvent(this, "Custom event message");
        eventPublisher.publishEvent(event);
    }
}

@Component
public class CustomEventListener implements ApplicationListener<CustomEvent> {
    @Override
    public void onApplicationEvent(CustomEvent event) {
        System.out.println("Received event: " + event.getMessage());
    }
}

// 4. Internationalization Support
@Configuration
public class I18nConfig {
    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
}

// 5. Resource Loading
@Component
public class ResourceLoadingExample {
    @Autowired
    private ApplicationContext context;
    
    public void loadResource() throws IOException {
        Resource resource = context.getResource("classpath:data.txt");
        // Read file content
        String content = new String(resource.getInputStream().readAllBytes());
        System.out.println("Resource content: " + content);
    }
}

// 6. Annotation Support
@Configuration
@ComponentScan("com.example")
public class AppConfig {
    @Bean
    @Scope("prototype")
    public MyService myService() {
        return new MyService();
    }
}

// 7. AOP Support
@Aspect
@Component
public class LoggingAspect {
    @Around("execution(* com.example.service.*.*(..))")
    public Object logMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Before method execution");
        Object result = joinPoint.proceed();
        System.out.println("After method execution");
        return result;
    }
}

// 8. Environment Access
@Component
public class EnvironmentExample {
    @Autowired
    private Environment environment;
    
    public void printProperties() {
        String dbUrl = environment.getProperty("database.url");
        String serverPort = environment.getProperty("server.port");
        System.out.println("DB URL: " + dbUrl);
        System.out.println("Server Port: " + serverPort);
    }
}

// 9. Web Application Support
@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("/public/");
    }
}

```

Here are the key differences between BeanFactory and ApplicationContext:

1. Features:

   BeanFactory:
    - Basic IoC container
    - Lazy initialization of beans
    - Explicit bean instantiation
    - Minimal functionality
    - Lower memory footprint

   ApplicationContext:
    - Advanced container
    - Eager initialization by default
    - Automatic bean instantiation
    - Enterprise-specific features
    - More memory usage

2. Core Functionality:

   BeanFactory:
   ```java
   - Basic bean instantiation
   - Bean lifecycle management
   - Bean dependency injection
   ```

   ApplicationContext:
   ```java
   - All BeanFactory features
   - Event propagation
   - Resource loading
   - Internationalization
   - AOP integration
   ```

3. Key Differences:

   a) Initialization:
   ```java
   // BeanFactory - Lazy
   BeanFactory factory = new XmlBeanFactory(resource);
   MyBean bean = factory.getBean("myBean"); // Created here

   // ApplicationContext - Eager
   ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
   // Beans are created during context initialization
   ```

   b) Feature Support:
   ```java
   // BeanFactory - Limited
   - Basic DI
   - Bean lifecycle

   // ApplicationContext - Extended
   - Message source
   - Event publishing
   - Resource loading
   - AOP
   ```

4. Use Cases:

   BeanFactory:
    - Memory-constrained devices
    - Simple applications
    - When lazy loading is required
    - Limited resource availability

   ApplicationContext:
    - Enterprise applications
    - Web applications
    - Complex business logic
    - Need for advanced features

5. Additional Features in ApplicationContext:

   a) Event Handling:
   ```java
   context.publishEvent(new CustomEvent());
   ```

   b) Resource Access:
   ```java
   Resource resource = context.getResource("classpath:file.txt");
   ```

   c) Internationalization:
   ```java
   String message = context.getMessage("key", null, locale);
   ```

   d) Environment Properties:
   ```java
   String prop = context.getEnvironment().getProperty("key");
   ```

6. Performance Considerations:

   BeanFactory:
    - Lower memory footprint
    - Slower bean access (first time)
    - No startup overhead

   ApplicationContext:
    - Higher memory usage
    - Faster bean access
    - Initial startup overhead

7. When to Use Which:

   Use BeanFactory when:
    - Memory is critical
    - Simple IoC is needed
    - Lazy loading is required

   Use ApplicationContext when:
    - Building enterprise apps
    - Need advanced features
    - Memory is not constrained

Would you like me to elaborate on any of these aspects or provide more specific examples?