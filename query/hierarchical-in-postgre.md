Here are different ways to create hierarchical data structures in PostgreSQL:

1. **Using a Self-Referencing Foreign Key (Adjacency List Model)**:
```sql
CREATE TABLE categories (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100),
    parent_id INTEGER,
    FOREIGN KEY (parent_id) REFERENCES categories(id)
);

-- Insert sample data
INSERT INTO categories (name, parent_id) VALUES
    ('Electronics', NULL),                    -- Top level
    ('Computers', 1),                         -- Child of Electronics
    ('Laptops', 2),                          -- Child of Computers
    ('Gaming Laptops', 3);                   -- Child of Laptops
```

2. **Using Path Enumeration**:
```sql
CREATE TABLE categories (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100),
    path VARCHAR(255)
);

-- Insert with path that shows hierarchy
INSERT INTO categories (name, path) VALUES
    ('Electronics', '1'),
    ('Computers', '1.2'),
    ('Laptops', '1.2.3'),
    ('Gaming Laptops', '1.2.3.4');
```

3. **Using Nested Sets**:
```sql
CREATE TABLE categories (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100),
    left_value INTEGER,
    right_value INTEGER
);

-- Insert nested set values
INSERT INTO categories (name, left_value, right_value) VALUES
    ('Electronics', 1, 8),
    ('Computers', 2, 7),
    ('Laptops', 3, 6),
    ('Gaming Laptops', 4, 5);
```

4. **Using ltree Extension (Most Recommended)**:
```sql
-- Enable ltree extension
CREATE EXTENSION IF NOT EXISTS ltree;

CREATE TABLE categories (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100),
    path ltree
);

-- Insert hierarchical data
INSERT INTO categories (name, path) VALUES
    ('Electronics', 'electronics'),
    ('Computers', 'electronics.computers'),
    ('Laptops', 'electronics.computers.laptops'),
    ('Gaming Laptops', 'electronics.computers.laptops.gaming');

-- Query examples with ltree
-- Get all descendants of electronics
SELECT * FROM categories WHERE path <@ 'electronics';

-- Get all ancestors of gaming laptops
SELECT * FROM categories WHERE path @> 'electronics.computers.laptops.gaming';
```

5. **Using Recursive CTEs for Querying**:
```sql
-- Using the self-referencing table structure
WITH RECURSIVE category_tree AS (
    -- Base case: top-level categories
    SELECT id, name, parent_id, 1 as level, ARRAY[name] as path
    FROM categories
    WHERE parent_id IS NULL
    
    UNION ALL
    
    -- Recursive case: child categories
    SELECT c.id, c.name, c.parent_id, ct.level + 1, ct.path || c.name
    FROM categories c
    JOIN category_tree ct ON c.parent_id = ct.id
)
SELECT * FROM category_tree;
```

6. **Using Materialized Path**:
```sql
CREATE TABLE categories (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100),
    path TEXT[],
    level INTEGER
);

-- Insert with array path
INSERT INTO categories (name, path, level) VALUES
    ('Electronics', ARRAY['Electronics'], 1),
    ('Computers', ARRAY['Electronics', 'Computers'], 2),
    ('Laptops', ARRAY['Electronics', 'Computers', 'Laptops'], 3);
```

Useful Queries for Hierarchical Data:

```sql
-- Find all children of a specific node (using ltree)
SELECT * FROM categories 
WHERE path ~ 'electronics.*';

-- Find depth of each node
SELECT name, nlevel(path) as depth 
FROM categories;

-- Find immediate children
SELECT child.* 
FROM categories parent
JOIN categories child ON child.parent_id = parent.id
WHERE parent.name = 'Electronics';

-- Find leaf nodes (using nested sets)
SELECT * 
FROM categories 
WHERE right_value = left_value + 1;

-- Find all ancestors (using materialized path)
SELECT * 
FROM categories 
WHERE 'Electronics.Computers.Laptops' LIKE path || '%';
```

Each approach has its advantages:

- **Self-referencing**: Simple but requires recursive queries
- **Path Enumeration**: Easy to query ancestors/descendants but needs careful string handling
- **Nested Sets**: Fast reads but complex updates
- **ltree**: Best built-in solution with good performance and easy querying
- **Materialized Path**: Good balance but needs array handling

The ltree extension is often the best choice as it provides:
- Built-in operators for tree traversal
- Efficient indexing
- Easy maintenance
- Native PostgreSQL support for hierarchical queries