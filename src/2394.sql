select Employees.employee_id
from Employees
         left join(
    select employee_id, sum(ceil(TIMESTAMPDIFF(second, in_time, out_time) / 60)) minutes
    from Logs
    group by employee_id) mid on mid.employee_id = Employees.employee_id
where minutes is null
   or needed_hours * 60 > minutes;