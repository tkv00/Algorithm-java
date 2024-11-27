-- 코드를 입력하세요
SELECT b.BOOK_ID,a.AUTHOR_NAME,DATE_FORMAT(b.PUBLISHED_DATE,'%Y-%m-%d') as PUBLISHED_DATE
from BOOK as b
inner join AUTHOR as a
on a.AUTHOR_ID = b.AUTHOR_ID
where b.CATEGORY = "경제"
order by b.PUBLISHED_DATE asc;