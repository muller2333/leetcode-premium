select member_A, member_B, SchoolC.student_name member_C
from SchoolC
         inner join (select SchoolA.student_name member_A,
                            SchoolB.student_name member_B,
                            SchoolA.student_id   id,
                            SchoolB.student_id   id2
                     from SchoolA
                              inner join SchoolB on SchoolA.student_id != SchoolB.student_id and
                                                    SchoolB.student_name != SchoolA.student_name) mid
                    on mid.id != SchoolC.student_id and mid.id2 != SchoolC.student_id and
                       member_A != SchoolC.student_name and member_B != SchoolC.student_name;