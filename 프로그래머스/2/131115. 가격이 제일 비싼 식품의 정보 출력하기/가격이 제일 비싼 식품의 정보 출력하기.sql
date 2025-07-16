select
    product_id,
    product_name,
    product_cd,
    category,
    price
from
    food_product
where
    product_id = (
        select product_id
        from food_product
        order by price desc
        limit 1
    );