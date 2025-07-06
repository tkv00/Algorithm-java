select 
    i.item_id,
    i.item_name,
    i.rarity
from
    item_info as i
    inner join
    item_tree as t
    on i.item_id = t.item_id
where 
    t.parent_item_id in (
        select item_id
        from item_info
        where rarity = 'RARE'
    )
order by
    i.item_id desc;
    
    