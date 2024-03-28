select
    max(ms) - min(ms) salary_difference
from
    (
        select
            department,
            max(salary) ms
        from
            Salaries
        where
            department = 'Engineering'
            or department = 'Marketing'
        group by
            department
    ) mid;