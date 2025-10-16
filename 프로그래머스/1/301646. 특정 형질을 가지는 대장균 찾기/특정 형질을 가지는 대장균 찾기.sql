# 1번 형질 - 1 -> & 연산 시 1이어야 함
# 2번 형질 - 10 -> & 연산 시 0이어야 함
# 3번 형질 - 100 -> & 연산 시 1이어야 함
SELECT COUNT(*) COUNT
FROM ECOLI_DATA e
WHERE ((e.GENOTYPE & 1 = 1)
    OR (e.GENOTYPE & 4 = 4))
    AND (e.GENOTYPE & 2 = 0)