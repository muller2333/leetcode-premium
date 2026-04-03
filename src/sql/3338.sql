select
    emp_id,
    dept
from
    (
        select
            emp_id,
            dept,
            dense_rank() over(
                partition by dept
                order by
                    salary desc
            ) rk
        from
            employees
    ) mid
where
    rk = 2
order by
    emp_id