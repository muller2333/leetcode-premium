select
    name member_A,
    name2 member_B,
    student_name member_C
from
    (
        select
            SchoolA.student_id id,
            SchoolA.student_name name,
            SchoolB.student_id id2,
            SchoolB.student_name name2
        from
            SchoolA
            join SchoolB on SchoolA.student_id != SchoolB.student_id
            and SchoolA.student_name != SchoolB.student_name
    ) mid
    join SchoolC on id != SchoolC.student_id
    and id2 != SchoolC.student_id
    and name != SchoolC.student_name
    and name2 != SchoolC.student_name;