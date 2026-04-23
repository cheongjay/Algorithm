SELECT TO_CHAR(trans_date, 'YYYY-MM') AS month, country, count(id) AS trans_count, count(
    CASE
        WHEN state = 'approved' THEN 1
        ELSE NULL
    END
) AS approved_count,
sum(amount) AS trans_total_amount,
sum(
    CASE
        WHEN state = 'approved' THEN amount
        ELSE 0
    END
) AS approved_total_amount
FROM Transactions
GROUP BY TO_CHAR(trans_date, 'YYYY-MM'), country