-- 코드를 입력하세요
-- 1.판매일 기준 오름차순,상품 ID 오름차순, 유저ID 오름차순
-- 2. 2022/03 판매 날짜,상품,유저,판매량
SELECT date_format(SALES_DATE,'%Y-%m-%d') as SALES_DATE,PRODUCT_ID,USER_ID,sales_amount as SALES_AMOUNT
from ONLINE_SALE 
where month(sales_date)=3
union all
select date_format(SALES_DATE,'%Y-%m-%d') as SALES_DATE,PRODUCT_ID,NULL as USER_ID,sales_amount as SALES_AMOUNT
from offline_sale
where month(sales_date)=3

order by sales_date asc,product_id asc,user_id asc;

