select 
    i.rest_id as REST_ID,
    i.rest_name as REST_NAME,
    i.food_type as FOOD_TYPE,
    i.favorites as FAVORITES,
    i.address as ADDRESS,
    round(avg(r.REVIEW_SCORE),2) as SCORE
from
    rest_info as i
    join
    rest_review as r on i.rest_id = r.rest_id
where
    i.address like '서울%'
group by
    i.rest_id,i.rest_name
order by
    score desc, favorites desc;

    