select employee_id, name, reports_count, average_age
from Employees
         right join (select round(sum(age) / count(age), 0) average_age, count(age) reports_count, reports_to
                     from Employees
                     where reports_to is not null
                     group by reports_to) mid on mid.reports_to = Employees.employee_id
order by employee_id;