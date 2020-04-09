# Write your MySQL query statement below
SELECT W2.Id
FROM Weather as W1, Weather as W2
WHERE TO_DAYS(W2.RecordDate) - TO_DAYS(W1.RecordDate) = 1 and W2.Temperature > W1.Temperature
