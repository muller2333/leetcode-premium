select Schools.school_id, ifnull(mid2.score, -1) score
from (
         select school_id, min(score) score
         from (
                  select school_id, score
                  from Schools,
                       Exam
                  where capacity >= student_count
              ) mid
         group by school_id
     ) mid2
         right join Schools
                    on Schools.school_id = mid2.school_id;