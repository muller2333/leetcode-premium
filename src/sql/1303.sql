select
    size team_size,
    employee_id
from
    Employee
    inner join (
        select
            team_id,
            count(employee_id) size
        from
            Employee
        group by
            team_id
    ) mid on mid.team_id = Employee.team_id;