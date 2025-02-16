-- 코드를 작성해주세요
SELECT E.EMP_NO AS EMP_NO,E.EMP_NAME AS EMP_NAME,
        CASE
            WHEN SUM(G.SCORE)/2 >= 96 THEN 'S'
            WHEN SUM(G.SCORE)/2 >= 90 THEN 'A'
            WHEN SUM(G.SCORE)/2 >= 80 THEN 'B'
            ELSE 'C'
            END
        AS GRADE,

        CASE
            WHEN SUM(G.SCORE)/2 >= 96 THEN E.SAL * 0.2
            WHEN SUM(G.SCORE)/2 >= 90 THEN E.SAL * 0.15
            WHEN SUM(G.SCORE)/2 >= 80 THEN E.SAL * 0.1
            ELSE E.SAL * 0
            END
        AS BONUS
FROM HR_EMPLOYEES AS E
INNER JOIN HR_GRADE AS G
        ON E.EMP_NO = G.EMP_NO
GROUP BY EMP_NO
ORDER BY E.EMP_NO ASC;