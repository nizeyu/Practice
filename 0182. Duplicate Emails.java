# Write your MySQL query statement below
SELECT Email
FROM Person
Group By Email
having count(Email) > 1
