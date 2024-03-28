select
    emp_id,
    firstname,
    lastname,
    max(salary) salary,
    department_id
from
    Salary salary
group by
    emp_id
order by
    emp_id;