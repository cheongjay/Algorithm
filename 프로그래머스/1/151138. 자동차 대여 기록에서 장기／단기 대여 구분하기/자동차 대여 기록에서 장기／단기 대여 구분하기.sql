SELECT c.HISTORY_ID, c.CAR_ID, DATE_FORMAT(c.start_date, '%Y-%m-%d') START_DATE, DATE_FORMAT(c.end_date, '%Y-%m-%d') END_DATE,
    CASE
        WHEN DATEDIFF(c.end_date, c.start_date) >= 29 THEN '장기 대여'
    ELSE '단기 대여'
    END AS RENT_TYPE
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY c
WHERE DATE_FORMAT(c.start_date,'%m') = 9
ORDER BY history_id DESC
