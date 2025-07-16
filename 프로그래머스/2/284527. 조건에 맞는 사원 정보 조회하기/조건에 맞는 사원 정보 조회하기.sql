select
    sum(c.score) as score,
    c.emp_no,
    b.emp_name,
    b.position,
    b.email
from
    hr_grade as c
    inner join
    hr_employees as b
    on c.emp_no = b.emp_no
where
    c.year=2022
group by
    c.emp_no
order by score desc
limit 1;
    