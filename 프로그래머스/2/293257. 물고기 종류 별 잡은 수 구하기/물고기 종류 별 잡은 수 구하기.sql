select
    count(*) as fish_count,
    b.fish_name
from
    fish_info as a
    inner join
    fish_name_info as b
    on a.fish_type = b.fish_type
group by
    b.fish_name
order by
    fish_count desc;
    