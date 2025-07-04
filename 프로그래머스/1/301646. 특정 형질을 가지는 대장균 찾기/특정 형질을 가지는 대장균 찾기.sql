select
    count(*) as count
from
    ecoli_data
where 
    genotype & 2 = 0
and
(
    genotype & 3 = 3
or
    genotype & 1 = 1
or
    genotype & 4 = 4
)
;
    