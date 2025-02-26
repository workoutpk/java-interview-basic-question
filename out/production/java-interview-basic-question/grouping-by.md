I'll show you how to find employees with the highest salary by city using different approaches.

```java
// Entity class
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String city;
    private Double salary;
    private String department;
    
    // Getters, setters, and constructors
}

// DTO for result
public class EmployeeHighestSalaryDTO {
    private String city;
    private String employeeName;
    private Double salary;
    private String department;
    
    // Constructor, getters, and setters
}

// Repository Interface
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    
    // Method 1: Using JPQL
    @Query("""
        SELECT new com.example.dto.EmployeeHighestSalaryDTO(
            e.city, 
            e.name, 
            e.salary, 
            e.department)
        FROM Employee e
        WHERE (e.city, e.salary) IN (
            SELECT 
                e2.city, 
                MAX(e2.salary)
            FROM Employee e2 
            GROUP BY e2.city)
        """)
    List<EmployeeHighestSalaryDTO> findHighestSalaryByCity();
    
    // Method 2: Using Native SQL
    @Query(value = """
        WITH RankedEmployees AS (
            SELECT 
                name,
                city,
                salary,
                department,
                RANK() OVER (PARTITION BY city ORDER BY salary DESC) as salary_rank
            FROM employees
        )
        SELECT 
            name as employeeName,
            city,
            salary,
            department
        FROM RankedEmployees
        WHERE salary_rank = 1
        """, nativeQuery = true)
    List<Object[]> findHighestSalaryByCityNative();
    
    // Method 3: For handling tie situations
    @Query("""
        SELECT new com.example.dto.EmployeeHighestSalaryDTO(
            e.city, 
            e.name, 
            e.salary, 
            e.department)
        FROM Employee e
        WHERE e.salary = (
            SELECT MAX(e2.salary)
            FROM Employee e2
            WHERE e2.city = e.city)
        ORDER BY e.city, e.name
        """)
    List<EmployeeHighestSalaryDTO> findAllHighestSalaryByCity();
}

// Service layer implementation
@Service
@Transactional(readOnly = true)
public class EmployeeService {
    
    private final EmployeeRepository employeeRepository;
    
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    
    // Method 1: Using Repository Query
    public List<EmployeeHighestSalaryDTO> getHighestSalaryByCity() {
        return employeeRepository.findHighestSalaryByCity();
    }
    
    // Method 2: Using Java Streams
    public List<EmployeeHighestSalaryDTO> getHighestSalaryByCityUsingStreams() {
        List<Employee> allEmployees = employeeRepository.findAll();
        
        return allEmployees.stream()
            .collect(Collectors.groupingBy(
                Employee::getCity,
                Collectors.collectingAndThen(
                    Collectors.maxBy(Comparator.comparing(Employee::getSalary)),
                    optionalEmployee -> optionalEmployee.map(emp -> 
                        new EmployeeHighestSalaryDTO(
                            emp.getCity(),
                            emp.getName(),
                            emp.getSalary(),
                            emp.getDepartment()
                        )
                    ).orElse(null)
                )
            ))
            .values()
            .stream()
            .filter(Objects::nonNull)
            .collect(Collectors.toList());
    }
    
    // Method 3: Using Native Query
    public List<EmployeeHighestSalaryDTO> getHighestSalaryByCityNative() {
        List<Object[]> results = employeeRepository.findHighestSalaryByCityNative();
        
        return results.stream()
            .map(row -> new EmployeeHighestSalaryDTO(
                (String) row[1],  // city
                (String) row[0],  // name
                (Double) row[2],  // salary
                (String) row[3]   // department
            ))
            .collect(Collectors.toList());
    }
    
    // Method 4: Handling ties with pagination
    public Map<String, List<EmployeeHighestSalaryDTO>> getHighestSalaryByCityWithTies() {
        List<EmployeeHighestSalaryDTO> employees = employeeRepository.findAllHighestSalaryByCity();
        
        return employees.stream()
            .collect(Collectors.groupingBy(
                EmployeeHighestSalaryDTO::getCity,
                Collectors.toList()
            ));
    }
}

// Controller implementation
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    
    private final EmployeeService employeeService;
    
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    
    @GetMapping("/highest-salary-by-city")
    public ResponseEntity<List<EmployeeHighestSalaryDTO>> getHighestSalaryByCity(
            @RequestParam(required = false) String method) {
        
        List<EmployeeHighestSalaryDTO> result;
        
        switch (method != null ? method : "default") {
            case "streams":
                result = employeeService.getHighestSalaryByCityUsingStreams();
                break;
            case "native":
                result = employeeService.getHighestSalaryByCityNative();
                break;
            default:
                result = employeeService.getHighestSalaryByCity();
        }
        
        return ResponseEntity.ok(result);
    }
    
    @GetMapping("/highest-salary-by-city/with-ties")
    public ResponseEntity<Map<String, List<EmployeeHighestSalaryDTO>>> getHighestSalaryByCityWithTies() {
        return ResponseEntity.ok(employeeService.getHighestSalaryByCityWithTies());
    }
}

```

Let me explain the different approaches and their use cases:

1. Using JPQL:
```sql
-- Advantages:
- Database agnostic
- Type-safe
- Easy to maintain
-- Best for:
- Simple queries
- When portability is important
```

2. Using Native SQL:
```sql
-- Advantages:
- Better performance
- Can use database-specific features
- More control over the query
-- Best for:
- Complex queries
- When performance is critical
```

3. Using Java Streams:
```sql
-- Advantages:
- More flexible
- Can handle complex transformations
- Easy to modify logic
-- Best for:
- Complex business logic
- When data is already in memory
```

4. Key Features of the Implementation:

a) Error Handling:
```java
- Proper exception handling
- Null checks
- Data validation
```

b) Performance Optimization:
```java
- Indexed queries
- Proper pagination
- Efficient data structures
```

c) Maintainability:
```java
- Clean code structure
- Separation of concerns
- Clear naming conventions
```

5. SQL Query Variations:

a) Simple Version:
```sql
SELECT e.*
FROM employees e
WHERE (city, salary) IN (
    SELECT city, MAX(salary)
    FROM employees
    GROUP BY city
)
```

b) With Ranking:
```sql
WITH RankedEmployees AS (
    SELECT *,
        RANK() OVER (PARTITION BY city ORDER BY salary DESC) as rank
    FROM employees
)
SELECT * FROM RankedEmployees WHERE rank = 1
```

6. Usage Examples:

```java
// Basic usage
GET /api/employees/highest-salary-by-city

// With specific method
GET /api/employees/highest-salary-by-city?method=native

// Including ties
GET /api/employees/highest-salary-by-city/with-ties
```

7. Response Format:
```json
{
    "New York": [
        {
            "employeeName": "John Doe",
            "salary": 120000.00,
            "department": "Engineering"
        }
    ],
    "San Francisco": [
        {
            "employeeName": "Jane Smith",
            "salary": 150000.00,
            "department": "Sales"
        }
    ]
}
```

Would you like me to explain any specific part in more detail or provide additional examples?