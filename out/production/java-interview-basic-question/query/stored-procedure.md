Using stored procedures in Spring Boot can be accomplished by leveraging the `@Procedure` annotation in Spring Data JPA or using the `EntityManager` for more customized use cases. Here's an example illustrating both approaches.

---

### **1. Using `@Procedure` Annotation**

This is the simplest way to call a stored procedure using Spring Data JPA.

#### Stored Procedure
Let's assume you have a stored procedure named `GET_EMPLOYEE_COUNT` in your database:

```sql
CREATE PROCEDURE GET_EMPLOYEE_COUNT (OUT emp_count INT)
BEGIN
    SELECT COUNT(*) INTO emp_count FROM employees;
END;
```

#### Spring Boot Code
##### Entity Class
```java
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employee {
    @Id
    private Long id;
    private String name;
    private String department;

    // Getters and setters
}
```

##### Repository Interface
```java
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Procedure(name = "GET_EMPLOYEE_COUNT")
    Integer getEmployeeCount();
}
```

##### Service Class
```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Integer fetchEmployeeCount() {
        return employeeRepository.getEmployeeCount();
    }
}
```

##### Main Application
```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StoredProcedureExampleApplication implements CommandLineRunner {

    @Autowired
    private EmployeeService employeeService;

    public static void main(String[] args) {
        SpringApplication.run(StoredProcedureExampleApplication.class, args);
    }

    @Override
    public void run(String... args) {
        Integer count = employeeService.fetchEmployeeCount();
        System.out.println("Employee Count: " + count);
    }
}
```

---

### **2. Using `EntityManager`**

For more complex use cases, `EntityManager` allows you to execute stored procedures.

#### Stored Procedure
Let's assume you have a stored procedure named `GET_EMPLOYEES_BY_DEPARTMENT`:

```sql
CREATE PROCEDURE GET_EMPLOYEES_BY_DEPARTMENT (IN dept_name VARCHAR(50))
BEGIN
    SELECT * FROM employees WHERE department = dept_name;
END;
```

#### Spring Boot Code
##### Repository Interface
No need for a custom method in the repository for this approach.

##### Service Class
```java
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EntityManager entityManager;

    public List<Object[]> getEmployeesByDepartment(String department) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("GET_EMPLOYEES_BY_DEPARTMENT");
        query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
        query.setParameter(1, department);

        return query.getResultList();
    }
}
```

##### Main Application
```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class StoredProcedureExampleApplication implements CommandLineRunner {

    @Autowired
    private EmployeeService employeeService;

    public static void main(String[] args) {
        SpringApplication.run(StoredProcedureExampleApplication.class, args);
    }

    @Override
    public void run(String... args) {
        List<Object[]> employees = employeeService.getEmployeesByDepartment("IT");
        for (Object[] employee : employees) {
            System.out.println("Employee ID: " + employee[0] + ", Name: " + employee[1]);
        }
    }
}
```

---

### **Summary**
- Use `@Procedure` for simple stored procedure calls.
- Use `EntityManager` for more flexibility with input/output parameters and handling complex results.

Let me know if you need help with a specific database like MySQL, PostgreSQL, or Oracle!