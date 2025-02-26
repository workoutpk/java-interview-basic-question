In **Spring Framework**, the `@Transactional` annotation is used to define transactional boundaries for methods. When a method annotated with `@Transactional` executes, the transaction can either **commit** (if the method completes successfully) or **rollback** (if an exception occurs under certain conditions).

Here’s how **rollback conditions** work with `@Transactional`:

---

### **Default Rollback Behavior**
1. **Runtime Exceptions (Unchecked Exceptions)**:
    - By default, a transaction will be rolled back if the method throws a `RuntimeException` (unchecked exception) or its subclass, e.g., `IllegalArgumentException`, `NullPointerException`.
    - **Example**:
      ```java
      @Transactional
      public void performTransaction() {
          // Some database operations
          throw new RuntimeException("Error occurred"); // Transaction will roll back
      }
      ```

2. **Checked Exceptions**:
    - Checked exceptions (e.g., `IOException`, `SQLException`) **do not trigger rollback by default**.
    - To make the transaction roll back for a checked exception, you need to explicitly specify it using the `rollbackFor` attribute in `@Transactional`.

---

### **Custom Rollback Conditions**
#### **1. Using `rollbackFor`**
- Specifies the exceptions for which the transaction should roll back.
- **Example**:
  ```java
  @Transactional(rollbackFor = IOException.class)
  public void performTransaction() throws IOException {
      // Some database operations
      throw new IOException("I/O error occurred"); // Transaction will roll back
  }
  ```

#### **2. Using `noRollbackFor`**
- Specifies exceptions for which the transaction **should not roll back**, even if they are `RuntimeException`s.
- **Example**:
  ```java
  @Transactional(noRollbackFor = NullPointerException.class)
  public void performTransaction() {
      // Some database operations
      throw new NullPointerException("No rollback for this exception");
  }
  ```

---

### **Fine-Grained Rollback Management**
- You can use programmatic transaction management to have more control over rollback behavior:
   ```java
   import org.springframework.transaction.TransactionStatus;
   import org.springframework.transaction.annotation.Transactional;
   import org.springframework.transaction.PlatformTransactionManager;
   import org.springframework.transaction.support.TransactionCallbackWithoutResult;
   import org.springframework.transaction.support.TransactionTemplate;

   @Service
   public class TransactionService {

       private final TransactionTemplate transactionTemplate;

       public TransactionService(PlatformTransactionManager transactionManager) {
           this.transactionTemplate = new TransactionTemplate(transactionManager);
       }

       public void performTransaction() {
           transactionTemplate.execute(new TransactionCallbackWithoutResult() {
               @Override
               protected void doInTransactionWithoutResult(TransactionStatus status) {
                   try {
                       // Database operations
                   } catch (Exception e) {
                       status.setRollbackOnly(); // Explicit rollback
                   }
               }
           });
       }
   }
   ```

---

### **Key Points to Remember**
1. **Default Behavior**:
    - Rollback occurs for `RuntimeException` and `Error`.
    - Checked exceptions don’t trigger rollback unless specified using `rollbackFor`.

2. **Custom Conditions**:
    - Use `rollbackFor` for checked exceptions.
    - Use `noRollbackFor` to exclude exceptions from rollback.

3. **Propagation and Isolation**:
    - Transaction behavior can also depend on **transaction propagation** and **isolation levels** defined in `@Transactional`.

---

### **Example with Multiple Rollback Rules**
```java
@Transactional(rollbackFor = {IOException.class, SQLException.class}, noRollbackFor = IllegalArgumentException.class)
public void performComplexTransaction() throws IOException, SQLException {
    // Some database operations
    if (condition1) throw new IOException("I/O error");
    if (condition2) throw new IllegalArgumentException("No rollback for this exception");
    if (condition3) throw new SQLException("SQL error occurred");
}
```
- Rolls back for `IOException` and `SQLException`.
- Does not roll back for `IllegalArgumentException`.

---

Would you like additional examples or deeper insights into a specific rollback scenario?