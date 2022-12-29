select name, bonus
from Employee
         left join Bonus on Employee.empId = Bonus.empId
where bonus is null
   or bonus < 1000;

# select name, bonus
# from (select empId, name from Employee where empId not in (select empId from Bonus where bonus >= 1000)) mid
#          left join (select * from Bonus where bonus < 1000) Bonus on Bonus.EmpId = mid.EmpId;