select mid2.project_id, employee_id
from (select project_id, max(experience_years) max_exp
      from (select experience_years, project_id
            from Project
                     left join Employee on Project.employee_id = Employee.employee_id) mid
      group by project_id) mid2
         left join(
    select Project.employee_id, experience_years, project_id
    from Project
             left join Employee on Project.employee_id = Employee.employee_id) mid3
                  on mid3.experience_years = mid2.max_exp and mid3.project_id = mid2.project_id;