 Write a query to print all prime numbers less than or equal to . Print your result on a single line, and use the ampersand () character as your separator (instead of a space).

For example, the output for all prime numbers  would be:

```roomsql
WITH RECURSIVE Numbers AS (
    SELECT 2 AS L
    UNION ALL
    SELECT L + 1
    FROM Numbers
    WHERE L < 1000
),
Primes AS (
    SELECT L
    FROM Numbers
    WHERE NOT EXISTS (
        SELECT 1
        FROM Numbers AS N2
        WHERE N2.L > 1 AND N2.L < Numbers.L AND Numbers.L % N2.L = 0
    )
)
SELECT GROUP_CONCAT(L SEPARATOR '&') AS PrimeNumbers
FROM Primes;
```