select month(start_date) as MONTH,CAR_ID,count(history_id) as RECORDS
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where car_id in (
    select car_id 
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY
    where (date_format(start_date,'%Y-%m') between '2022-08' and '2022-10')
    group by car_id
    having count(car_id) >= 5
) and (date_format(start_date,'%Y-%m') between '2022-08' and '2022-10') 
group by MONTH,CAR_ID
having RECORDS>0
order by MONTH ASC,CAR_ID DESC;