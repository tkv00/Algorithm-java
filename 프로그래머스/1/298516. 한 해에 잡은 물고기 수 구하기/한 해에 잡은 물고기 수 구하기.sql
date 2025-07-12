select
    count(*) as FISH_COUNT
from    
    fish_info
where
    YEAR(TIME) = 2021
;