-- 코드를 작성해주세요
select i.ITEM_ID,i.ITEM_NAME
from ITEM_INFO as i
INNER JOIN  ITEM_TREE as t
ON i.ITEM_ID = t.ITEM_ID
where t.PARENT_ITEM_ID is null;