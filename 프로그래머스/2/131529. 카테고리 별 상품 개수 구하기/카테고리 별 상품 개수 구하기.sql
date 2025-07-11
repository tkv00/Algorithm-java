select
    SUBSTR(PRODUCT_CODE,1,2) as CATEGORY,
    COUNT(*) as PRODUCTS
from
    product
group by
    SUBSTR(PRODUCT_CODE,1,2)
order by
    CATEGORY;
    