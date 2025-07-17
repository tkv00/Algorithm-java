select
    distinct c.car_id as CAR_ID
from
    CAR_RENTAL_COMPANY_CAR as c
    inner join
    CAR_RENTAL_COMPANY_RENTAL_HISTORY as h
    on c.car_id = h.car_id
where
    c.car_type like '세단'
    and
    year(h.start_date)=2022 and month(h.start_date)=10
order by
    c.car_id desc;