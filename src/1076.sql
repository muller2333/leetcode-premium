select
       project_id
from
       Project
group by
       project_id
having
       count(employee_id) = (
              select
                     max(cnt) cnt
              from
                     (
                            select
                                   count(employee_id) cnt
                            from
                                   Project
                            group by
                                   project_id
                     ) mid
       );