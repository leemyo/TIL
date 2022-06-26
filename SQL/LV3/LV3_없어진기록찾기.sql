-- 코드를 입력하세요
select b.ANIMAL_ID, b.NAME
from animal_ins as a
right join animal_outs as b
on a.ANIMAL_ID = b.ANIMAL_ID
where a.ANIMAL_ID is null;