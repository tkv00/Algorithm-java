select 
    round(avg(daily_fee),0) as average_fee
from 
    car_rental_company_car
group by
    car_type
having car_type like 'SUV';