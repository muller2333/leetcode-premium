select mid.student_id, student_name, mid.subject_name, ifnull(cnt, 0) attended_exams
from (select student_id, student_name, subject_name
      from Students,
           Subjects) mid
         left join
     (select student_id, subject_name, count(student_id) cnt from Examinations group by student_id, subject_name) mid2
     on mid2.student_id = mid.student_id and mid.subject_name = mid2.subject_name
order by student_id, subject_name;