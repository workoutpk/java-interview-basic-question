I'll help you understand the different types of queries in Java, particularly in the context of database operations and JPA (Java Persistence API).



```java
// Entity class for examples
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String department;
    private Double salary;
    
    // Getters and setters...
}

// 1. JPQL (Java Persistence Query Language) Queries
public class JPQLQueries {
    @PersistenceContext
    private EntityManager entityManager;
    
    // Simple SELECT query
    public List<Employee> findAllEmployees() {
        return entityManager.createQuery(
            "SELECT e FROM Employee e", Employee.class)
            .getResultList();
    }
    
    // Query with WHERE clause
    public List<Employee> findEmployeesByDepartment(String department) {
        return entityManager.createQuery(
            "SELECT e FROM Employee e WHERE e.department = :dept", 
            Employee.class)
            .setParameter("dept", department)
            .getResultList();
    }
    
    // Aggregate query
    public Double getAverageSalary() {
        return entityManager.createQuery(
            "SELECT AVG(e.salary) FROM Employee e", 
            Double.class)
            .getSingleResult();
    }
}

// 2. Criteria API Queries
public class CriteriaQueries {
    @PersistenceContext
    private EntityManager entityManager;
    
    public List<Employee> findEmployeesByCriteria(String department, Double minSalary) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> query = cb.createQuery(Employee.class);
        Root<Employee> employee = query.from(Employee.class);
        
        List<Predicate> predicates = new ArrayList<>();
        
        if (department != null) {
            predicates.add(cb.equal(employee.get("department"), department));
        }
        if (minSalary != null) {
            predicates.add(cb.greaterThan(employee.get("salary"), minSalary));
        }
        
        query.where(predicates.toArray(new Predicate[0]));
        return entityManager.createQuery(query).getResultList();
    }
}

// 3. Native SQL Queries
public class NativeSQLQueries {
    @PersistenceContext
    private EntityManager entityManager;
    
    public List<Employee> findEmployeesWithNativeQuery() {
        return entityManager.createNativeQuery(
            "SELECT * FROM employee WHERE salary > ?", 
            Employee.class)
            .setParameter(1, 50000.0)
            .getResultList();
    }
}

// 4. Named Queries
@Entity
@NamedQueries({
    @NamedQuery(
        name = "Employee.findByDepartment",
        query = "SELECT e FROM Employee e WHERE e.department = :department"
    ),
    @NamedQuery(
        name = "Employee.findHighEarners",
        query = "SELECT e FROM Employee e WHERE e.salary > :minSalary"
    )
})
public class EmployeeWithNamedQueries {
    // Entity fields...
    
    public List<Employee> findByNamedQuery(EntityManager em) {
        return em.createNamedQuery("Employee.findByDepartment", Employee.class)
            .setParameter("department", "IT")
            .getResultList();
    }
}

// 5. Spring Data JPA Queries
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // Method name query
    List<Employee> findByDepartmentAndSalaryGreaterThan(
        String department, Double salary);
    
    // Custom query using @Query annotation
    @Query("SELECT e FROM Employee e WHERE e.salary BETWEEN :min AND :max")
    List<Employee> findEmployeesInSalaryRange(
        @Param("min") Double min, 
        @Param("max") Double max);
    
    // Native query example
    @Query(
        value = "SELECT * FROM employee WHERE YEAR(hire_date) = :year",
        nativeQuery = true)
    List<Employee> findEmployeesHiredInYear(@Param("year") int year);
    
    // Query with Pageable
    Page<Employee> findByDepartment(String department, Pageable pageable);
}

// 6. Stored Procedure Query
@NamedStoredProcedureQuery(
    name = "Employee.calculateBonus",
    procedureName = "CALC_EMPLOYEE_BONUS",
    parameters = {
        @StoredProcedureParameter(
            mode = ParameterMode.IN, 
            name = "emp_id", 
            type = Long.class),
        @StoredProcedureParameter(
            mode = ParameterMode.OUT, 
            name = "bonus", 
            type = Double.class)
    }
)
public class StoredProcedureExample {
    public Double calculateBonus(EntityManager em, Long employeeId) {
        StoredProcedureQuery query = em.createNamedStoredProcedureQuery(
            "Employee.calculateBonus")
            .setParameter("emp_id", employeeId);
            
        query.execute();
        return (Double) query.getOutputParameterValue("bonus");
    }
}

```

Here's a breakdown of the different types of queries demonstrated:

1. JPQL (Java Persistence Query Language) Queries:
    - Similar to SQL but works with Java objects
    - Platform-independent
    - Supports object-oriented queries
    - Can include parameters

2. Criteria API Queries:
    - Type-safe way to write queries
    - Good for dynamic queries
    - Better compile-time checking
    - More verbose but more maintainable

3. Native SQL Queries:
    - Direct SQL statements
    - Database-specific
    - Useful for complex queries
    - Can leverage database-specific features

4. Named Queries:
    - Defined at entity level
    - Precompiled for better performance
    - Reusable across application
    - Can be validated at startup

5. Spring Data JPA Queries:
    - Method name queries (derived queries)
    - @Query annotation for custom queries
    - Support for native queries
    - Pagination support
    - Dynamic projections

6. Stored Procedure Queries:
    - Call database stored procedures
    - Support for IN/OUT parameters
    - Can be named or anonymous
    - Good for complex business logic

Each type has its use cases:
- Use JPQL for simple to moderate queries
- Use Criteria API for dynamic queries
- Use Native SQL for complex database-specific queries
- Use Named Queries for frequently used queries
- Use Spring Data JPA for standard CRUD operations
- Use Stored Procedures for complex database operations

Would you like me to explain any specific type in more detail?