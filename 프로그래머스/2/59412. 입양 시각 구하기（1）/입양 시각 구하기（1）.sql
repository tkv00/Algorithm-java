select
    hour(datetime) as hour,
    count(*) as 'count'
from
    animal_outs
where
    hour(datetime) >= 9 
    and 
    (hour(datetime) <= 19 and minute(datetime)<=59)
group by
    hour
order by
    hour asc;