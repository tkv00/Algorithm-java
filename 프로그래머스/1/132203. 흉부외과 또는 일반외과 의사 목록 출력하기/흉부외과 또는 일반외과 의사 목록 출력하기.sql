select
    dr_name,
    dr_id,
    mcdp_cd,
    date_format(hire_ymd,'%Y-%m-%d')
from
    doctor
where
    mcdp_cd regexp 'CS|GS'
order by
    hire_ymd desc,dr_name asc;