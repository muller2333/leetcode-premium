select
    mid2.month pay_month,
    department_id,
    if(
        dept_avg > com_avg,
        'higher',
        if(dept_avg = com_avg, 'same', 'lower')
    ) comparison
from
    (
        select
            avg(amount) com_avg,
            month
        from
            (
                select
                    substring(pay_date, 1, 7) month,
                    amount
                from
                    Salary
            ) mid
        group by
            month
    ) mid
    right join (
        select
            avg(amount) dept_avg,
            department_id,
            month
        from
            Employee
            right join (
                select
                    substring(pay_date, 1, 7) month,
                    amount,
                    employee_id
                from
                    Salary
            ) mid on mid.employee_id = Employee.employee_id
        group by
            month,
            department_id
    ) mid2 on mid.month = mid2.month;