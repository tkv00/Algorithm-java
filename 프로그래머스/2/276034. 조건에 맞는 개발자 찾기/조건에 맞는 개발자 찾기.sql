select
    d.id,
    d.email,
    d.first_name,
    d.last_name
from
    developers as d
where
    d.skill_code & (
        select 
            code
        from
            skillcodes
        where
            name like 'Python'
    ) OR
    d.skill_code & (
        select
            code
        from
            skillcodes
        where
            name like 'C#'
    )
order by
    id asc;