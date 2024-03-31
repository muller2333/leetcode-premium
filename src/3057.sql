select
    employee_id,
    project_id,
    name employee_name,
    workload project_workload
from
    (
        select
            avg(workload) avg,
            team
        from
            (
                select
                    workload,
                    team,
                    Project.employee_id,
                    project_id
                from
                    Project
                    left join Employees on Project.employee_id = Employees.employee_id
            ) mid
        group by
            team
    ) mid2
    left join (
        select
            workload,
            team,
            Project.employee_id,
            project_id,
            name
        from
            Project
            left join Employees on Project.employee_id = Employees.employee_id
    ) mid on mid.team = mid2.team
where
    avg < workload
order by
    employee_id,
    project_id;