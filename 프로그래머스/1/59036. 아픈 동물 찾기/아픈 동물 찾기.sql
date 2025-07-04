select
    animal_id,
    name
from
    animal_ins
where 
    intake_condition like 'Sick'
order by
    animal_id;