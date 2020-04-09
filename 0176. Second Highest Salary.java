# Write your MySQL query statement below
SELECT MAX(E1.Salary) as SecondHighestSalary
FROM Employee as E1
WHERE E1.salary < (
    SELECT MAX(E2.Salary)
    FROM Employee as E2
)
