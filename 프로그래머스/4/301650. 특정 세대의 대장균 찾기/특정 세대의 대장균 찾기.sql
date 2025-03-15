-- 코드를 작성해주세요
-- 1. 3세대 대장균 ID
-- 2. ID 오름차순
-- id parent id parent  id parent ID PARENT
-- 1  null        
-- 2  null   4  2       6   4     8  6
-- 2  null.  5. 2       NULL    5

SELECT D3.ID
FROM ECOLI_DATA AS D1
    INNER JOIN ECOLI_DATA AS D2 ON D1.ID=D2.PARENT_ID
    INNER JOIN ECOLI_DATA AS D3 ON D2.ID=D3.PARENT_ID
WHERE D1.PARENT_ID IS NULL
ORDER BY D3.ID ASC;