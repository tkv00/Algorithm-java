select
    d.dept_id,
    d.dept_name_en,
    round(avg(e.sal),0) as avg_sal
from
    hr_department as d
    inner join
    hr_employees as e
    on
    d.dept_id = e.dept_id
group by
    d.dept_id
order by
    avg_sal desc;