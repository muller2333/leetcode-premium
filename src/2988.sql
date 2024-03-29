select
    emp_name manager_name,
    mid3.dep_id
from
    Employees
    right join (
        select
            dep_id
        from
            (
                select
                    dep_id,
                    rank() over(
                        order by
                            cnt desc
                    ) rk
                from
                    (
                        select
                            count(emp_id) cnt,
                            dep_id
                        from
                            Employees
                        group by
                            dep_id
                    ) mid
            ) mid2
        where
            rk = 1
    ) mid3 on mid3.dep_id = Employees.dep_id
where
    position = 'Manager'
order by
    dep_id;