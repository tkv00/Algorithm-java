select
    i.ingredient_type,
    sum(h.total_order) as total_order
from
    first_half as h
    inner join
    icecream_info as i
    on h.flavor = i.flavor
group by
    i.ingredient_type
order by
    total_order asc;