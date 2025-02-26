# Basic Index Creation:

```roomsql
-- Simple Index
CREATE INDEX idx_user_email ON users(email);

-- Composite Index
CREATE INDEX idx_user_name ON users(first_name, last_name);

-- Unique Index
CREATE UNIQUE INDEX idx_user_unique_email ON users(email);

-- Partial Index (PostgreSQL)
CREATE INDEX idx_active_users ON users(user_id) WHERE status = 'active';
```

# 2.Types of Indexes:

```roomsql
-- B-Tree Index (Default)
CREATE INDEX idx_btree ON users(age);

-- Hash Index (PostgreSQL)
CREATE INDEX idx_hash ON users USING HASH (email);

-- GiST Index (for geometric data)
CREATE INDEX idx_gist ON locations USING GIST (coordinates);

-- Full-Text Search Index
CREATE FULLTEXT INDEX idx_fulltext ON articles(title, content);
```

# 3.Index Analysis:

```roomsql
-- MySQL: Show indexes
SHOW INDEX FROM users;

-- PostgreSQL: Analyze query plan
EXPLAIN ANALYZE SELECT * FROM users WHERE email = 'test@example.com';

-- Check index usage
SELECT 
    index_name,
    index_type,
    column_name,
    cardinality
FROM information_schema.statistics
WHERE table_name = 'users';
```

# 4.Index Maintenance:
```roomsql
-- Rebuild Index
ALTER INDEX idx_user_email REBUILD;

-- Update Statistics
ANALYZE TABLE users;

-- Drop unused index
DROP INDEX idx_user_email ON users;
```
# 5.B-Tree Structure:

```java
public class BTreeNode {
    private boolean isLeaf;
    private int[] keys;
    private BTreeNode[] children;
    private int minDegree;
    private int currentKeys;

    public BTreeNode(int degree, boolean leaf) {
        this.minDegree = degree;
        this.isLeaf = leaf;
        this.keys = new int[2 * minDegree - 1];
        this.children = new BTreeNode[2 * minDegree];
        this.currentKeys = 0;
    }

    // Search operation in B-Tree
    public BTreeNode search(int key) {
        int i = 0;
        while (i < currentKeys && key > keys[i]) {
            i++;
        }

        if (keys[i] == key) {
            return this;
        }

        if (isLeaf) {
            return null;
        }

        return children[i].search(key);
    }
}
```

# 6.Index Selection:

```java
public class QueryOptimizer {
    public String selectBestIndex(String table, List<String> whereColumns) {
        Map<String, IndexInfo> availableIndexes = getTableIndexes(table);
        IndexInfo bestIndex = null;
        int bestScore = 0;

        for (IndexInfo index : availableIndexes.values()) {
            int score = calculateIndexScore(index, whereColumns);
            if (score > bestScore) {
                bestScore = score;
                bestIndex = index;
            }
        }

        return bestIndex != null ? bestIndex.getName() : null;
    }

    private int calculateIndexScore(IndexInfo index, List<String> whereColumns) {
        int score = 0;
        List<String> indexColumns = index.getColumns();
        
        for (int i = 0; i < indexColumns.size(); i++) {
            if (whereColumns.contains(indexColumns.get(i))) {
                // First column matches are worth more
                score += (indexColumns.size() - i) * 10;
            }
        }
        
        return score;
    }
}
```

# Index Statistics:

```java
public class IndexStatistics {
    private long totalRows;
    private long distinctValues;
    private double selectivity;

    public void calculateSelectivity() {
        selectivity = (double) distinctValues / totalRows;
    }

    public boolean isIndexEffective() {
        // Rule of thumb: index is effective if selectivity > 5%
        return selectivity > 0.05;
    }

    public void analyzeIndexUsage(String tableName, String indexName) {
        // Example query to analyze index usage
        String query = """
            SELECT 
                index_name,
                index_reads,
                index_writes
            FROM performance_schema.table_io_waits_summary_by_index_usage
            WHERE object_name = ?
            AND index_name = ?
        """;
    }
}
```

# Index Performance Monitoring:

```java
public class IndexMonitor {
    public void monitorIndexPerformance() {
        // Example monitoring query
        String monitoringQuery = """
            SELECT 
                t.table_name,
                i.index_name,
                i.column_name,
                t.table_rows,
                i.cardinality,
                ROUND(i.cardinality / t.table_rows * 100, 2) as selectivity
            FROM information_schema.tables t
            JOIN information_schema.statistics i 
                ON t.table_name = i.table_name
            WHERE t.table_schema = DATABASE()
            ORDER BY selectivity DESC
        """;
    }
}
```

# Best Practices:

## 1.Index Creation Guidelines:

```java
public class IndexingGuidelines {
    public boolean shouldCreateIndex(TableStats stats) {
        // Don't index small tables
        if (stats.getRowCount() < 100) return false;
        
        // Don't index columns with low cardinality
        if (stats.getColumnCardinality() / stats.getRowCount() < 0.01) return false;
        
        // Consider table write frequency
        if (stats.getWriteFrequency() > stats.getReadFrequency() * 3) return false;
        
        return true;
    }
}
```

## 2.Common Indexing Patterns:
```roomsql
-- Foreign Keys
CREATE INDEX idx_fk_user_id ON orders(user_id);

-- Sort Operations
CREATE INDEX idx_created_at ON logs(created_at DESC);

-- Range Queries
CREATE INDEX idx_age_gender ON users(age) INCLUDE (gender);

-- Pattern Matching
CREATE INDEX idx_email_pattern ON users(email text_pattern_ops);
```

## 3.Index Maintenance Schedule:

```java
@Scheduled(cron = "0 0 2 * * *") // Run at 2 AM daily
public void performIndexMaintenance() {
    // Rebuild fragmented indexes
    String rebuildQuery = """
        SELECT 
            DBMS_METADATA.GET_DDL('INDEX',i.index_name,i.table_owner) 
        FROM dba_indexes i 
        WHERE i.pct_free > 30
    """;
    
    // Update statistics
    String statsQuery = """
        ANALYZE TABLE users COMPUTE STATISTICS 
        FOR ALL INDEXED COLUMNS
    """;
}
```