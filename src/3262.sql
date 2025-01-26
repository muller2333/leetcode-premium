select
    emps.employee_id,
    count(emps.employee_id) overlapping_shifts
from
    Employeeshifts
    join Employeeshifts emps on Employeeshifts.employee_id = emps.employee_id
    and Employeeshifts.end_time >= emps.start_time
    and emps.start_time >= Employeeshifts.start_time
    and Employeeshifts.start_time != emps.start_time
group by
    emps.employee_id