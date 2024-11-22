-- 코드를 입력하세요
SELECT DATETIME as 시간 
from ANIMAL_INS 
where DATETIME in (select min(DATETIME) 
                  from ANIMAL_INS);