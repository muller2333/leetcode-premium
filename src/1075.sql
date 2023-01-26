select project_id, round(sum(experience_years) / count(experience_years), 2) average_years
from Project
         left join Employee on Project.employee_id = Employee.employee_id
group by project_id;