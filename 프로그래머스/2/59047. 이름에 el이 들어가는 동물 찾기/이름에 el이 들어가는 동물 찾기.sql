select
    animal_id as ANIMAL_ID,
    name as NAME
from 
    animal_ins
where
    name like '%EL%' and
    animal_type like 'Dog'
order by
    name asc;