I'll help you write a SQL query to find high earners in each department. A high earner can be defined in multiple ways, so I'll show different approaches.



```roomsql
-- Solution 1: Employees earning more than average salary in their department
WITH dept_avg AS (
    SELECT 
        department_id,
        AVG(salary) as avg_dept_salary
    FROM employees
    GROUP BY department_id
)
SELECT 
    e.employee_id,
    e.first_name,
    e.last_name,
    e.salary,
    e.department_id,
    d.department_name,
    da.avg_dept_salary
FROM employees e
JOIN departments d ON e.department_id = d.department_id
JOIN dept_avg da ON e.department_id = da.department_id
WHERE e.salary > da.avg_dept_salary
ORDER BY e.department_id, e.salary DESC;

-- Solution 2: Top 3 earners in each department using DENSE_RANK
WITH ranked_salaries AS (
    SELECT 
        e.employee_id,
        e.first_name,
        e.last_name,
        e.salary,
        e.department_id,
        d.department_name,
        DENSE_RANK() OVER (PARTITION BY e.department_id ORDER BY e.salary DESC) as salary_rank
    FROM employees e
    JOIN departments d ON e.department_id = d.department_id
)
SELECT *
FROM ranked_salaries
WHERE salary_rank <= 3
ORDER BY department_id, salary_rank;

-- Solution 3: Employees earning more than 1.5 times the department median
WITH dept_stats AS (
    SELECT 
        department_id,
        PERCENTILE_CONT(0.5) WITHIN GROUP (ORDER BY salary) as median_salary
    FROM employees
    GROUP BY department_id
)
SELECT 
    e.employee_id,
    e.first_name,
    e.last_name,
    e.salary,
    e.department_id,
    d.department_name,
    ds.median_salary,
    ROUND((e.salary / ds.median_salary), 2) as salary_to_median_ratio
FROM employees e
JOIN departments d ON e.department_id = d.department_id
JOIN dept_stats ds ON e.department_id = ds.department_id
WHERE e.salary > (ds.median_salary * 1.5)
ORDER BY e.department_id, e.salary DESC;

-- Solution 4: Employees in top 10% of their department by salary
WITH salary_percentiles AS (
    SELECT 
        employee_id,
        first_name,
        last_name,
        salary,
        department_id,
        PERCENT_RANK() OVER (PARTITION BY department_id ORDER BY salary DESC) as salary_percentile
    FROM employees
)
SELECT 
    sp.*,
    d.department_name
FROM salary_percentiles sp
JOIN departments d ON sp.department_id = d.department_id
WHERE salary_percentile <= 0.1
ORDER BY department_id, salary DESC;

-- Solution 5: Employees earning more than department average + 1 standard deviation
WITH dept_stats AS (
    SELECT 
        department_id,
        AVG(salary) as avg_salary,
        STDDEV(salary) as salary_stddev
    FROM employees
    GROUP BY department_id
)
SELECT 
    e.employee_id,
    e.first_name,
    e.last_name,
    e.salary,
    e.department_id,
    d.department_name,
    ds.avg_salary,
    ds.salary_stddev,
    ROUND((e.salary - ds.avg_salary) / ds.salary_stddev, 2) as standard_deviations_from_mean
FROM employees e
JOIN departments d ON e.department_id = d.department_id
JOIN dept_stats ds ON e.department_id = ds.department_id
WHERE e.salary > (ds.avg_salary + ds.salary_stddev)
ORDER BY e.department_id, e.salary DESC;

```

Here's what each solution does:

1. **Solution 1: Above Average Earners**
    - Finds employees earning more than their department's average salary
    - Good for identifying all above-average performers
    - Shows the comparison between individual salary and department average

2. **Solution 2: Top 3 Earners**
    - Uses DENSE_RANK to find the top 3 highest-paid employees in each department
    - Good for small, fixed number of high performers
    - Handles ties appropriately using DENSE_RANK

3. **Solution 3: Above 1.5× Median**
    - Identifies employees earning more than 1.5 times their department's median salary
    - More robust against outliers than using mean
    - Shows the ratio of individual salary to department median

4. **Solution 4: Top 10% Earners**
    - Uses PERCENT_RANK to find employees in the top 10% of their department
    - Scales with department size
    - Good for large departments with many salary levels

5. **Solution 5: Statistical Approach**
    - Finds employees earning more than one standard deviation above the mean
    - More statistically rigorous approach
    - Shows how many standard deviations above mean each employee is

To use these queries:

1. Make sure you have an `employees` table with:
    - employee_id
    - first_name
    - last_name
    - salary
    - department_id

2. Make sure you have a `departments` table with:
    - department_id
    - department_name

Choose the solution based on your needs:
- For a simple approach: Use Solution 1 (above average)
- For a fixed number of top earners: Use Solution 2 (top 3)
- For a robust approach: Use Solution 3 (above median)
- For percentage-based selection: Use Solution 4 (top 10%)
- For statistical analysis: Use Solution 5 (standard deviation)

Would you like me to explain any of these solutions in more detail or help you adapt them to your specific needs?