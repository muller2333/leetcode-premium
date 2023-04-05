select student_id,
       mid.department_id,
       round((r - 1) / (if(cnt = 1, 2, cnt) - 1) * 100, 2) percentage
from (SELECT student_id,
             department_id,
             RANK() OVER (PARTITION BY
                 department_id
                 ORDER BY
                     mark DESC
                 ) r
      FROM Students) mid
         inner join
     (select department_id, count(mark) cnt from Students group by department_id) mid2
     on mid2.department_id = mid.department_id;