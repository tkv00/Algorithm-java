select
    b.user_id,
    b.nickname,
    sum(a.price) as total_sales
from
    used_goods_board as a
    inner join
    used_goods_user as b
    on 
    a.writer_id = b.user_id
where
    a.status = 'DONE'
group by
    b.user_id
having
    sum(a.price) >= 700000
order by
    total_sales asc;
    