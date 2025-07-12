select
    concat(quarter(DIFFERENTIATION_DATE),'Q') as QUARTER,
    count(distinct id) as ECOLI_COUNT
from
    ecoli_data
group by
    QUARTER
order by
    QUARTER asc
;