Here are the key AOP (Aspect-Oriented Programming) methods in Java:

1. Proxy-based AOP
- Uses JDK dynamic proxy or CGLIB
- Intercepts method calls
- Lightweight and built into Spring Framework

2. AspectJ Method
- Compile-time weaving
- More powerful and precise
- Requires AspectJ compiler

3. Spring AOP Annotations
- @Aspect: Defines an aspect
- @Before: Executes before method
- @After: Executes after method
- @Around: Wraps method execution
- @AfterReturning: Executes after method returns
- @AfterThrowing: Executes if method throws exception

4. Programmatic AOP
- Manually create proxy objects
- More control but less maintainable
- Used in complex scenarios

Example of Spring AOP Annotation:
```java
@Aspect
@Component
public class LoggingAspect {
    @Before("execution(* com.example.service.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        // Logging logic
    }
}
```

Key Use Cases:
- Logging
- Transaction management
- Security
- Performance monitoring

Cross-Cutting Concerns in AOP:

1. Logging
- Track method entry/exit
- Record method parameters
- Performance monitoring

2. Security
- Authentication checks
- Authorization validation
- Role-based access control

3. Transaction Management
- Begin/commit transactions
- Rollback on exceptions
- Manage database operations

4. Error Handling
- Global exception handling
- Centralized error logging
- Uniform error response mechanism

5. Caching
- Cache method results
- Manage cache invalidation
- Optimize performance

6. Validation
- Input parameter validation
- Business rule enforcement
- Data integrity checks

7. Performance Monitoring
- Execution time tracking
- Resource utilization
- Method performance metrics

8. Audit Logging
- Track user actions
- Record system events
- Compliance and forensic purposes

9. Retry Mechanism
- Automatic retry on failures
- Handle transient errors
- Configurable retry strategies

10. Instrumentation
- Collect runtime metrics
- Application performance insights
- Diagnostic information gathering

Example Implementation:
```java
@Aspect
public class LoggingAspect {
    @Around("execution(* com.example.service.*.*(..))")
    public Object logMethodExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        // Pre-method logging
        Object result = joinPoint.proceed();
        // Post-method logging
        return result;
    }
}
```