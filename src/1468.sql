select Salaries.company_id, employee_id, employee_name, round(salary * rate, 0) salary
from Salaries
         inner join
     (select case
                 when m_salary < 1000 then 1
                 when m_salary <= 10000 then 0.76
                 else 0.51
                 end rate,
             company_id
      from (select company_id, max(salary) m_salary from Salaries group by company_id) mid) mid2
     on mid2.company_id = Salaries.company_id;