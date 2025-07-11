select
    count(*) as USERS
from
    user_info
where
    year(joined) = 2021 
    and
    (age >= 20 and age<=29)
;