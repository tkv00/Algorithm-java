-- 코드를 작성해주세요
SELECT e1.ITEM_ID, e1.ITEM_NAME, e1.RARITY
FROM ITEM_INFO  AS e1
INNER JOIN ITEM_TREE AS e2
ON e1.ITEM_ID = e2.ITEM_ID
WHERE e2.PARENT_ITEM_ID IN (SELECT ITEM_ID FROM ITEM_INFO WHERE RARITY = 'RARE')
ORDER BY ITEM_ID DESC;