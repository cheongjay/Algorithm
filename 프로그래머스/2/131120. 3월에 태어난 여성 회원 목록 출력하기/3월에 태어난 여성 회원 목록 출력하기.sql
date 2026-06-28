SELECT
    member_id,
    member_name,
    gender,
    TO_CHAR(date_of_birth, 'YYYY-MM-DD') AS date_of_birth
FROM MEMBER_PROFILE
WHERE TO_CHAR(date_of_birth, 'MM') = '03' AND tlno IS NOT NULL AND gender = 'W'
ORDER BY member_id