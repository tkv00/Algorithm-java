select
    month(start_date) as month,
    car_id,
    count(history_id) as records
from 
    CAR_RENTAL_COMPANY_RENTAL_HISTORY
where
    year(start_date) = 2022
    and
    (month(start_date)>=8 and month(start_date)<=10)
    and
    car_id in (
        select 
            car_id
        from
            CAR_RENTAL_COMPANY_RENTAL_HISTORY
        where
             year(start_date) = 2022
        and
            (month(start_date)>=8 and month(start_date)<=10)
        group by
            car_id
        having
            count(history_id) >= 5
    )
group by
    month,car_id
having 
    records > 0
order by
    month asc,car_id desc;