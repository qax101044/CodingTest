-- 코드를 작성해주세요
SELECT COUNT(*) AS COUNT
FROM ECOLI_DATA A
-- 2번 형질 보유 x + 1 or 3번 형질 보유
WHERE (GENOTYPE & 2) != 2 
    AND ((GENOTYPE & 1) = 1 OR (GENOTYPE & 4) = 4)