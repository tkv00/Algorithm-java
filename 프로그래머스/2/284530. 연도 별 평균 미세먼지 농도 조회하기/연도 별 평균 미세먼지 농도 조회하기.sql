select
    YEAR(ym)
    as YEAR,
    round(avg(pm_val1),2)
    as 'PM10',
    round(avg(pm_val2),2)
    as 'PM2.5'
from
    AIR_POLLUTION
where
    location2 like '수원'
group by
    YEAR(ym)
order by
    YEAR(ym) asc;