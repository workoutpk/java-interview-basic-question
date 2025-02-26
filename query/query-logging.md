I'll explain Liquibase, a database schema version control and migration tool, along with practical examples.

```yaml
# Example liquibase.properties
driver: com.mysql.cj.jdbc.Driver
url: jdbc:mysql://localhost:3306/mydb
username: myuser
password: mypassword
changeLogFile: db/changelog/db.changelog-master.yaml

# db.changelog-master.yaml
databaseChangeLog:
  - include:
      file: db/changelog/changes/v0001.create-tables.yaml
  - include:
      file: db/changelog/changes/v0002.add-indexes.yaml
  - include:
      file: db/changelog/changes/v0003.data-updates.yaml

# v0001.create-tables.yaml - Creating tables
databaseChangeLog:
  - changeSet:
      id: 1
      author: developer
      changes:
        - createTable:
            tableName: users
            columns:
              - column:
                  name: id
                  type: bigint
                  autoIncrement: true
                  constraints:
                    primaryKey: true
                    nullable: false
              - column:
                  name: username
                  type: varchar(50)
                  constraints:
                    nullable: false
                    unique: true
              - column:
                  name: email
                  type: varchar(100)
              - column:
                  name: created_at
                  type: timestamp
                  defaultValueComputed: CURRENT_TIMESTAMP
        - createTable:
            tableName: orders
            columns:
              - column:
                  name: id
                  type: bigint
                  autoIncrement: true
                  constraints:
                    primaryKey: true
              - column:
                  name: user_id
                  type: bigint
                  constraints:
                    nullable: false
                    foreignKeyName: fk_orders_users
                    references: users(id)
              - column:
                  name: status
                  type: varchar(20)
              - column:
                  name: order_date
                  type: timestamp
      rollback:
        - dropTable:
            tableName: orders
        - dropTable:
            tableName: users

# v0002.add-indexes.yaml - Adding indexes
databaseChangeLog:
  - changeSet:
      id: 2
      author: developer
      changes:
        - createIndex:
            indexName: idx_users_email
            tableName: users
            columns:
              - column:
                  name: email
        - createIndex:
            indexName: idx_orders_status
            tableName: orders
            columns:
              - column:
                  name: status
      rollback:
        - dropIndex:
            indexName: idx_orders_status
            tableName: orders
        - dropIndex:
            indexName: idx_users_email
            tableName: users

# v0003.data-updates.yaml - Inserting and updating data
databaseChangeLog:
  - changeSet:
      id: 3
      author: developer
      changes:
        - insert:
            tableName: users
            columns:
              - column:
                  name: username
                  value: admin
              - column:
                  name: email
                  value: admin@example.com
        - update:
            tableName: users
            columns:
              - column:
                  name: email
                  value: updated@example.com
            where: username = 'admin'
      rollback:
        - delete:
            tableName: users
            where: username = 'admin'

# Example Spring Boot application.properties configuration
spring:
  liquibase:
    change-log: classpath:db/changelog/db.changelog-master.yaml
    enabled: true
    drop-first: false

```

Let me explain the key concepts of Liquibase:

1. Core Concepts:
    - ChangeLog: Master file that tracks all database changes
    - ChangeSet: Individual set of changes
    - Changes: Specific database modifications
    - Rollback: Instructions to undo changes
    - Preconditions: Conditions that must be met before applying changes

2. Main Features:
    - Version Control: Tracks database schema changes
    - Rollback Support: Can undo changes
    - Multiple Formats: Supports XML, YAML, JSON, SQL
    - Database Independence: Works with multiple databases
    - Integration: Works with Spring Boot and other frameworks

3. Common Change Types:
    - createTable: Create new tables
    - addColumn: Add columns to existing tables
    - createIndex: Create database indexes
    - addForeignKeyConstraint: Add foreign keys
    - insert/update/delete: Manage data
    - sql: Execute custom SQL

4. Best Practices:
    - Use meaningful changeSet IDs
    - Include rollback instructions
    - Keep changesets small and focused
    - Use preconditions when necessary
    - Follow naming conventions
    - Version control your changelog files

5. Common Commands:
```bash
# Update database to latest version
liquibase update

# Generate SQL without executing
liquibase updateSQL

# Rollback to a specific version
liquibase rollback <tag>

# Validate changelog
liquibase validate

# Generate changelog from existing database
liquibase generateChangeLog

# Clear checksums
liquibase clearChecksums
```

6. Integration with Spring Boot:
```java
@SpringBootApplication
@EnableAutoConfiguration
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```

7. Key Benefits:
    - Version Control: Track all database changes
    - Collaboration: Multiple developers can work safely
    - Automation: Automate database deployments
    - Documentation: Self-documenting database changes
    - Testing: Test changes before production
    - Rollback: Safely undo changes if needed

Would you like me to explain any specific aspect of Liquibase in more detail?