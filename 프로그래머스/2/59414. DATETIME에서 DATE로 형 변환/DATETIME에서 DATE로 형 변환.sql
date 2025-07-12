select
    animal_id,
    name,
    DATE_FORMAT(DATETIME,'%Y-%m-%d') as '날짜'
from
    animal_ins
order by
    animal_id;