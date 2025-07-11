select
    i.item_id,
    i.item_name
from
    item_info as i
    inner join
    item_tree as t
    on i.item_id = t.item_id
where
    t.parent_item_id is null
order by 
    i.item_id asc;