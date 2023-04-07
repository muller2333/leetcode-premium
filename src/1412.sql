select student_id, student_name
from Student
where student_id not in (select distinct student_id
                         from (select exam_id, min(score) min_score, max(score) max_score
                               from Exam
                               group by exam_id) mid
                                  inner join Exam on
                             Exam.exam_id = mid.exam_id and (min_score = score or max_score = score))
  and student_id in (select distinct student_id from Exam)
order by student_id;