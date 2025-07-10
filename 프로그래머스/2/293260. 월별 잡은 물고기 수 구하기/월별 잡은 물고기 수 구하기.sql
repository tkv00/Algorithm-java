select
    count(*) as FISH_COUNT,
    month(TIME) as MONTH
from
    fish_info
group by
    month(TIME)
order by
    month(time);
