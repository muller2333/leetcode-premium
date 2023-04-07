select employee_id
from (select employee_id,
             salary,
             (select sum(salary)
              from (select * from Candidates where experience = 'Senior' order by salary) mid2
              where salary <= mid.salary) total
      from (select * from Candidates where experience = 'Senior' order by salary) mid) mid2
where total <= 70000
union all
select employee_id
from (select employee_id,
             salary,
             (select sum(salary)
              from (select * from Candidates where experience = 'Junior' order by salary) mid2
              where salary <= mid.salary) total
      from (select * from Candidates where experience = 'Junior' order by salary) mid) mid2
where total <= (select if(employee_id is null, 70000, 70000 - max(total))
                from (select employee_id,
                             salary,
                             (select sum(salary)
                              from (select * from Candidates where experience = 'Senior' order by salary) mid2
                              where salary <= mid.salary) total
                      from (select * from Candidates where experience = 'Senior' order by salary) mid) mid2
                where total <= 70000);