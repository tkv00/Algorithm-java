-- 코드를 작성해주세요
select count(*) as COUNT
from ECOLI_DATA
where (GENOTYPE & 2) = 0 
and ((GENOTYPE & 1) >0 or (GENOTYPE & 4)>0);