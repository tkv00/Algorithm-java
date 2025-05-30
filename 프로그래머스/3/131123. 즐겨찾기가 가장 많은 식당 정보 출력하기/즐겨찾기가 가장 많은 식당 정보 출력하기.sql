-- 1. 음식종류별 즐겨찾기가 가장 많은 식당
-- 2. 음식 종류,ID,식당 이름, 즐겨찾기 수
SELECT FOOD_TYPE,REST_ID,REST_NAME,FAVORITES
FROM REST_INFO
WHERE (FOOD_TYPE,FAVORITES) IN (
    SELECT FOOD_TYPE,MAX(FAVORITES)
    FROM REST_INFO
    GROUP BY FOOD_TYPE
)
ORDER BY FOOD_TYPE DESC;