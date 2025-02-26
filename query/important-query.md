## over() example
```roomsql

WITH CumulativeWeights AS (
    SELECT 
        person_name,
        turn,
        weight,
        SUM(weight) OVER (ORDER BY turn) AS cumulative_weight 
    FROM 
        Queue
    ORDER BY 
        turn DESC 

    ),
    turn_list AS(
        SELECT 
        person_name,
        turn,
        cumulative_weight
        FROM 
            CumulativeWeights
        WHERE 
            cumulative_weight <= 1000 
        LIMIT 1
    )
    

SELECT 
    person_name
FROM 
    turn_list

```
Gain an Loss
```roomsql
SELECT 
    p.product_id,
    COALESCE(MAX(pp.new_price), 10) AS price
FROM 
    (SELECT DISTINCT product_id FROM Products) p
LEFT JOIN 
    Products pp ON p.product_id = pp.product_id AND pp.change_date <= '2019-08-16'
GROUP BY 
    p.product_id;
```


```roomsql

SELECT stock_name, SUM(CASE 
            WHEN operation = 'Sell' THEN price 
            WHEN operation = 'Buy' THEN - price 
            ELSE 0 
        END) 
    as capital_gain_loss FROM Stocks GROUP BY stock_name;

```


To swap the seat IDs of every two consecutive students in a SQL table while ensuring that if the number of students is odd, the last student's ID remains unchanged, you can use the following SQL query:

```roomsql
SELECT 
    CASE 
        WHEN id % 2 = 1 AND id + 1 IN (SELECT id FROM seat) THEN id + 1
        WHEN id % 2 = 0 AND id - 1 IN (SELECT id FROM seat) THEN id - 1
        ELSE id 
    END AS id,
    student
FROM seat
ORDER BY id;
```

### Explanation:
- **CASE Statement**: This checks whether the `id` is odd or even.
    - If the `id` is odd and the next ID (`id + 1`) exists in the table, it assigns the next ID to be the new ID.
    - If the `id` is even and the previous ID (`id - 1`) exists, it assigns the previous ID to be the new ID.
    - If neither condition is met (which will only happen for the last student in an odd-numbered list), it retains the original `id`.
- **ORDER BY**: Finally, it orders the results by `id` in ascending order to maintain a structured output.

This approach effectively swaps IDs for pairs of students while leaving the last student's ID unchanged when there is an odd number of students[2][4][5].

Citations:
[1] https://www.youtube.com/watch?v=_Jbd0J0YrMs
[2] https://leetcode-in-java.github.io/src/main/java/g0601_0700/s0626_exchange_seats/
[3] https://www.youtube.com/watch?v=Sq1kM3jVU68
[4] https://github.com/RachelPengmkt/SQL-Practice/blob/master/leetcode-626.%20Exchange%20Seats.sql
[5] https://stackoverflow.com/questions/48693166/sql-sub-queries-seat-exchange
[6] https://github.com/doocs/leetcode/blob/main/solution/0600-0699/0626.Exchange%20Seats/README_EN.md
[7] https://leetcode.com/problems/exchange-seats/
[8] https://www.linkedin.com/posts/abhishek-tripathi-493b751b0_dataengineer-databricks-activity-7166409727302729728-NXFK

```roomsql


SELECT visited_on, amount, amount as average_amount from customer 
WHERE visited_on = CASE 
    WHEN visited_on < DATE_FORMAT(visited_on, '%Y-%m-08') THEN DATE_FORMAT(visited_on, '%Y-%m-07') ELSE visited_on  
    END
GROUP BY visited_on; 
```

```roomsql
# Write your MySQL query statement below
SELECT
    a.visited_on,
    SUM(b.amount) AS amount,
    ROUND(SUM(b.amount) / 7, 2) AS average_amount
FROM
    (SELECT DISTINCT visited_on FROM customer) AS a
    JOIN customer AS b ON DATEDIFF(a.visited_on, b.visited_on) BETWEEN 0 AND 6
WHERE a.visited_on >= (SELECT MIN(visited_on) FROM customer) + 6
GROUP BY 1
ORDER BY 1;
```