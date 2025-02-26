I'll explain the differences between @RequestParam, @PathParam, and @PathVariable in Spring MVC, along with their use cases.

```java
// 1. @RequestParam Examples
@RestController
@RequestMapping("/api")
public class RequestParamController {
    
    // Simple @RequestParam usage
    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers(
            @RequestParam(required = false, defaultValue = "1") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer size) {
        return ResponseEntity.ok(userService.getUsers(page, size));
    }
    
    // Multiple request parameters with different types
    @GetMapping("/search")
    public ResponseEntity<List<User>> searchUsers(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer age,
            @RequestParam(required = false) List<String> roles,
            @RequestParam(name = "active", defaultValue = "true") Boolean isActive) {
        return ResponseEntity.ok(userService.searchUsers(name, age, roles, isActive));
    }
    
    // Handling all request parameters as a Map
    @GetMapping("/filter")
    public ResponseEntity<List<User>> filterUsers(
            @RequestParam MultiValueMap<String, String> allParams) {
        return ResponseEntity.ok(userService.filterUsers(allParams));
    }
    
    // Required request parameter
    @GetMapping("/validate")
    public ResponseEntity<User> validateUser(
            @RequestParam(required = true) String email) {
        return ResponseEntity.ok(userService.validateUser(email));
    }
}

// 2. @PathVariable Examples
@RestController
@RequestMapping("/api")
public class PathVariableController {
    
    // Simple @PathVariable usage
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUser(id));
    }
    
    // Multiple path variables
    @GetMapping("/organizations/{orgId}/departments/{deptId}/employees/{empId}")
    public ResponseEntity<Employee> getEmployeeDetails(
            @PathVariable Long orgId,
            @PathVariable Long deptId,
            @PathVariable Long empId) {
        return ResponseEntity.ok(employeeService.getEmployeeDetails(orgId, deptId, empId));
    }
    
    // Optional path variable with regex pattern
    @GetMapping({"/products/{category}", "/products"})
    public ResponseEntity<List<Product>> getProducts(
            @PathVariable(required = false) @Pattern(regexp = "^[a-zA-Z]+$") String category) {
        return ResponseEntity.ok(productService.getProducts(category));
    }
    
    // Custom name for path variable
    @GetMapping("/orders/{orderId}/items/{itemId}")
    public ResponseEntity<OrderItem> getOrderItem(
            @PathVariable("orderId") Long orderIdentifier,
            @PathVariable("itemId") Long itemIdentifier) {
        return ResponseEntity.ok(orderService.getOrderItem(orderIdentifier, itemIdentifier));
    }
}

// 3. @PathParam Examples (JAX-RS Style)
@Path("/api")
public class PathParamResource {
    
    // Simple @PathParam usage
    @GET
    @Path("/users/{id}")
    public Response getUser(@PathParam("id") Long id) {
        return Response.ok(userService.getUser(id)).build();
    }
    
    // Multiple path parameters
    @GET
    @Path("/reports/{year}/{month}/{day}")
    public Response getDailyReport(
            @PathParam("year") Integer year,
            @PathParam("month") Integer month,
            @PathParam("day") Integer day) {
        return Response.ok(reportService.getDailyReport(year, month, day)).build();
    }
}

// 4. Combined Usage Example
@RestController
@RequestMapping("/api/v1")
public class CombinedController {
    
    // Combining @PathVariable and @RequestParam
    @GetMapping("/organizations/{orgId}/employees")
    public ResponseEntity<List<Employee>> getEmployeesByOrganization(
            @PathVariable Long orgId,
            @RequestParam(required = false) String department,
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size) {
        return ResponseEntity.ok(
            employeeService.getEmployeesByOrganization(orgId, department, page, size));
    }
    
    // Complex URL mapping with both types
    @GetMapping("/users/{userId}/orders/{orderId}/items")
    public ResponseEntity<List<OrderItem>> getUserOrderItems(
            @PathVariable Long userId,
            @PathVariable Long orderId,
            @RequestParam(required = false) String status,
            @RequestParam(defaultValue = "date") String sortBy) {
        return ResponseEntity.ok(
            orderService.getUserOrderItems(userId, orderId, status, sortBy));
    }
    
    // Example with validation
    @PostMapping("/departments/{deptId}/employees")
    public ResponseEntity<Employee> createEmployee(
            @PathVariable @Min(1) Long deptId,
            @RequestParam @Email String email,
            @RequestParam @NotBlank String name,
            @RequestParam @Min(18) @Max(100) Integer age) {
        return ResponseEntity.ok(
            employeeService.createEmployee(deptId, email, name, age));
    }
}

// 5. Exception Handling for Parameter Errors
@ControllerAdvice
public class ParameterExceptionHandler {
    
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<Error> handleMissingParams(MissingServletRequestParameterException ex) {
        String name = ex.getParameterName();
        return ResponseEntity
            .badRequest()
            .body(new Error("Required parameter '" + name + "' is missing"));
    }
    
    @ExceptionHandler(MissingPathVariableException.class)
    public ResponseEntity<Error> handleMissingPathVariable(MissingPathVariableException ex) {
        String name = ex.getVariableName();
        return ResponseEntity
            .badRequest()
            .body(new Error("Required path variable '" + name + "' is missing"));
    }
}

```

Here's a detailed breakdown of each annotation:

1. @RequestParam:
```java
// Used for query parameters in URL
// Example URL: /api/users?page=1&size=10

Key Features:
- Optional parameters
- Default values
- Type conversion
- Multiple values
- Map binding
```

2. @PathVariable:
```java
// Used for URL path segments
// Example URL: /api/users/123

Key Features:
- Required by default
- Part of URL path
- Type conversion
- Regular expression matching
- Multiple variables
```

3. @PathParam:
```java
// JAX-RS equivalent of @PathVariable
// Example URL: /api/users/123

Key Features:
- Similar to @PathVariable
- Used in JAX-RS
- Part of Jakarta EE
```

4. Key Differences:

a) Usage Context:
```java
@RequestParam: Query parameters (?param=value)
@PathVariable: URL path segments (/value)
@PathParam: JAX-RS path parameters
```

b) Default Behavior:
```java
@RequestParam: Optional by default
@PathVariable: Required by default
@PathParam: Required by default
```

5. Common Use Cases:

a) @RequestParam:
```java
- Filtering
- Pagination
- Sorting
- Optional parameters
- Multiple values
```

b) @PathVariable:
```java
- Resource identifiers
- Hierarchical data
- RESTful URLs
- Required values
```

6. Examples of URL Patterns:

```java
// @RequestParam
/search?name=John&age=25
/users?page=1&size=10&sort=name

// @PathVariable
/users/123/orders/456
/organizations/789/departments/101

// Combined
/users/123/orders?status=pending&sort=date
```

7. Best Practices:

a) Use @RequestParam when:
```java
- Parameter is optional
- Multiple values are possible
- Parameter is not part of resource identifier
```

b) Use @PathVariable when:
```java
- Value is part of resource identifier
- Parameter is required
- Building RESTful APIs
```

c) Use @PathParam when:
```java
- Working with JAX-RS
- Need Jakarta EE compatibility
```

Would you like me to explain any specific aspect in more detail or provide additional examples?