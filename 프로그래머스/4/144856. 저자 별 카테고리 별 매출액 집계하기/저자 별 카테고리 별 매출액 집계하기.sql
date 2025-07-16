select
    a.author_id as AUTHOR_ID,
    a.author_name as AUTHOR_NAME,
    b.category as CATEGORY,
    sum(s.sales*b.price) as TOTAL_SALES
from 
    book as b
    inner join author as a
    on
        b.author_id = a.author_id
    inner join book_sales as s
    on
        s.book_id = b.book_id
where
    year(s.SALES_DATE)=2022
    and
    month(s.SALES_DATE)=1
group by
    a.author_id,b.category
order by
    a.author_id asc,b.category desc;
    