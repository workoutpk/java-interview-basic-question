In Spring Data JPA, the **`PagingAndSortingRepository`** interface (an extension of `CrudRepository`) provides convenient methods for pagination and sorting of query results. By using pagination, you can limit the number of records returned in each query result, which is particularly useful when dealing with large datasets.

### How to Use `PagingAndSortingRepository`

1. **Define a Repository Interface**

   Start by creating a repository interface that extends `PagingAndSortingRepository`. For example:

   ```java
   import org.springframework.data.repository.PagingAndSortingRepository;

   public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {
       // Additional query methods, if needed
   }
   ```

   Here, `Employee` is the entity class, and `Long` is the type of its primary key.

2. **Paging and Sorting Methods**

   `PagingAndSortingRepository` provides several methods for pagination and sorting:
    - **`findAll(Pageable pageable)`**: Returns a paginated list of entities.
    - **`findAll(Sort sort)`**: Returns a sorted list of entities.
    - **`findAll(Pageable pageable, Sort sort)`**: Allows combining pagination with sorting.

   For example:
   ```java
   import org.springframework.beans.factory.annotation.Autowired;
   import org.springframework.data.domain.Page;
   import org.springframework.data.domain.PageRequest;
   import org.springframework.data.domain.Pageable;
   import org.springframework.stereotype.Service;

   @Service
   public class EmployeeService {

       @Autowired
       private EmployeeRepository employeeRepository;

       public Page<Employee> getEmployeesPaged(int page, int size) {
           Pageable pageable = PageRequest.of(page, size);
           return employeeRepository.findAll(pageable);
       }
   }
   ```

3. **Creating a `PageRequest`**

   Use `PageRequest.of(int page, int size, Sort sort)` to create a pageable request with sorting options:

   ```java
   Pageable pageable = PageRequest.of(0, 10, Sort.by("name").ascending());
   Page<Employee> employeePage = employeeRepository.findAll(pageable);
   ```

    - **`page`**: The page number, starting from `0`.
    - **`size`**: The number of records per page.
    - **`Sort`**: Defines the sorting order, e.g., `Sort.by("name").ascending()`.

4. **Accessing the Results**

   The `Page` object returned by `findAll(Pageable pageable)` includes methods to get the total number of elements, the total number of pages, and whether there are more pages available.

   ```java
   List<Employee> employees = employeePage.getContent();
   long totalElements = employeePage.getTotalElements();
   int totalPages = employeePage.getTotalPages();
   boolean hasNext = employeePage.hasNext();
   ```

### Example with Custom Queries

You can also use pagination with custom query methods by specifying the `Pageable` parameter:

```java
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {
    
    @Query("SELECT e FROM Employee e WHERE e.department = :department")
    Page<Employee> findByDepartment(String department, Pageable pageable);
}
```

Then you can call `findByDepartment("IT", pageable)` to get paged results for a specific department.

### Summary
- **`PagingAndSortingRepository`** provides built-in pagination and sorting for JPA repositories.
- Use **`PageRequest`** to specify page number, size, and sorting.
- The **`Page`** object contains metadata like total elements, total pages, and the current page content.
- You can use pagination with custom queries by including a `Pageable` parameter.

This helps improve performance by loading manageable chunks of data and is especially useful in applications that display data on multiple pages.

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public ResponseEntity<Page<Book>> getBooks(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        
        Pageable pageable = PageRequest.of(page, size);
        Page<Book> bookPage = bookRepository.findAll(pageable);
        return ResponseEntity.ok(bookPage);
    }
}