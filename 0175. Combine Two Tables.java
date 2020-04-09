# Write your MySQL query statement below
SELECT P.FirstName, P.LastName, A.City, A.State
FROM Person as P Left Join Address as A
ON P.personId = A.personId
