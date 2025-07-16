select
    year(DIFFERENTIATION_DATE) as year,
    (
        select
            max(SIZE_OF_COLONY)
        from
            ecoli_data
         WHERE YEAR(DIFFERENTIATION_DATE) = YEAR
    ) -SIZE_OF_COLONY as year_dev,
    id
from    
    ecoli_data
order by
    year(DIFFERENTIATION_DATE) asc,
    year_dev asc;
    