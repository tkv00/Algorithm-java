select 
    f.flavor
from
    first_half as f
inner join
    icecream_info as i
on
    f.flavor = i.flavor
where
    f.total_order > 3000
    and
    i.flavor in ('strawberry','peach','strawberry','melon','mango','watermelon','orange','pineapple')
order by
    f.total_order desc;