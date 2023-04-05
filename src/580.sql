select dept_name, sum(num) student_number
from (
         select dept_name, if(student_id is null, 0, 1) num
         from Student
                  right join Department on Department.dept_id = Student.dept_id
     ) mid
group by dept_name
order by student_number desc, dept_name;