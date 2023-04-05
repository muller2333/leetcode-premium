select mid.id, mid.month, sum(mid2.salary) Salary
from (select Employee.id, Employee.month, salary
      from Employee
               left join(
          select max(month) month, id
          from Employee
          group by id) mid on mid.id = Employee.id and Employee.month = mid.month
      where mid.id is null) mid
         inner join (select Employee.id, Employee.month, salary
                     from Employee
                              left join(
                         select max(month) month, id
                         from Employee
                         group by id) mid on mid.id = Employee.id and Employee.month = mid.month
                     where mid.id is null) mid2
                    on mid.id = mid2.id and mid.month - mid2.month <= 2 and mid.month - mid2.month >= 0
group by mid.id, mid.month
order by mid.id, mid.month desc;