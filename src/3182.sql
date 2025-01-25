select
    student_id
from
    (
        select
            mid.student_id,
            sum(if(grade = 'A', 1, 0)) sum,
            count(mid.student_id) cnt
        from
            (
                select
                    student_id,
                    course_id
                from
                    students
                    inner join courses on students.major = courses.major
            ) mid
            left join enrollments on enrollments.student_id = mid.student_id
            and enrollments.course_id = mid.course_id
        group by
            mid.student_id
    ) mid2
where
    sum = cnt
order by
    student_id