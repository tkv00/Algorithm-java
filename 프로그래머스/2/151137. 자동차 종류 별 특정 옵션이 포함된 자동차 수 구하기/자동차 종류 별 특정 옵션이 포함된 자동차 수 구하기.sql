select
    car_type,
    count(*) as CARS
from
    CAR_RENTAL_COMPANY_CAR
where
    options regexp '통풍시트|열선시트|가죽시트'
group by
    car_type
order by
    car_type asc;
    