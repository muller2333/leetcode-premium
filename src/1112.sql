select
      mid3.student_id,
      course_id,
      grade
from
      Enrollments
      right join (
            select
                  student_id,
                  min(course_id) min_course_id
            from
                  (
                        select
                              mid.student_id,
                              course_id,
                              grade
                        from
                              Enrollments
                              right join (
                                    select
                                          max(grade) max_grade,
                                          student_id
                                    from
                                          Enrollments
                                    group by
                                          student_id
                              ) mid on mid.student_id = Enrollments.student_id
                              and Enrollments.grade = mid.max_grade
                  ) mid2
            group by
                  student_id
      ) mid3 on mid3.student_id = Enrollments.student_id
      and min_course_id = course_id
order by
      mid3.student_id;