## 1.Query for find duplicate records of usertabel
```roomsql
SELECT username, email, COUNT(*) AS count
FROM users
GROUP BY username, email
HAVING COUNT(*) > 1;
```

## 2.Query for delete duplicate records 

```roomsql
DELETE FROM users
WHERE id NOT IN (
    SELECT MIN(id)
    FROM users
    GROUP BY username, email
);
```
```roomsql
WITH CTE AS (
    SELECT 
        id,
        ROW_NUMBER() OVER (PARTITION BY username, email ORDER BY id) AS row_num
    FROM users
)
DELETE FROM CTE WHERE row_num > 1;
```