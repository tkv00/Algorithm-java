-- 1. 물고기 종류별 가장 큰 물고기
-- 2. 물고기 ID 오름차순
-- 3. 가장 큰 물고기 10cm이면 포함x
SELECT I.ID,N.FISH_NAME,I.LENGTH
FROM FISH_INFO AS I
     INNER JOIN FISH_NAME_INFO AS N ON I.FISH_TYPE = N.FISH_TYPE
WHERE LENGTH >= 10 AND
      (I.FISH_TYPE,I.LENGTH) IN (
        SELECT FISH_TYPE,MAX(LENGTH)
        FROM FISH_INFO
        GROUP BY FISH_TYPE
      )
ORDER BY I.ID ASC;