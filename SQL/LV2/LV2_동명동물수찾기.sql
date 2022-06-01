select name, count(*) as count
from ANIMAL_INS
where name is not null AND length(NAME)>=1
group by name
having count(*)>1
order by name;