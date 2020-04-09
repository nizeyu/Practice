# Write your MySQL query statement below
SELECT C.Name as Customers
FROM Customers as C
WHERE C.Id not in (
    SELECT O.CustomerId
    FROM Orders as O
)
