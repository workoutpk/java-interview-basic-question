 # LEAD & LAG Used In SubQuery
 
```roomsql
SELECT DISTINCT num
FROM (
    SELECT 
        num, 
        LEAD(num) OVER (ORDER BY id) AS next_num,
        LAG(num) OVER (ORDER BY id) AS prev_num
    FROM your_table
) AS temp
WHERE num = next_num AND num = prev_num;

```

Explanation:
### LEAD(num) OVER (ORDER BY id):

The `LEAD` function looks at the next row in the order of `id` and returns the value of `num` in that row. This is used to check if the current row is part of a consecutive sequence.
### LAG(num) OVER (ORDER BY id):

The `LAG` function looks at the previous row in the order of `id` and returns the value of `num` in that row. This is also used to check if the current row is part of a consecutive sequence.
### WHERE num = next_num AND num = prev_num:

This condition ensures that the number appears in three consecutive rows: in the current row (num), the previous row (prev_num), and the next row (next_num).
### `DISTINCT` num:

`DISTINCT` ensures that each number is only returned once, even if it appears in multiple consecutive sequences of three or more.