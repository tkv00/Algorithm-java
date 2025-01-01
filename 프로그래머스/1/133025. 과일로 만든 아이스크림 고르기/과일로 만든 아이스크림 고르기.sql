select i.FLAVOR
from FIRST_HALF as f 
inner join ICECREAM_INFO as i
on f.FLAVOR = i.FLAVOR
where f.TOTAL_ORDER >= 3000 
and i.INGREDIENT_TYPE Like 'fruit_based'
order by f.TOTAL_ORDER DESC;