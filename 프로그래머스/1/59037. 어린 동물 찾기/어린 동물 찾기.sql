select 
    animal_id,
    name
from
    animal_ins
where
    INTAKE_CONDITION not like 'Aged%'
order by
    animal_id asc;