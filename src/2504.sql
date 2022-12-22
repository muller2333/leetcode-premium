select person_id, concat(name, '(', substring(profession, 1, 1), ')') name
from Person
order by person_id desc;
