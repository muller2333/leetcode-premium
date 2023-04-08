select mid2.task_id, n subtask_id
from Executed
         right join
     (select task_id, n
      from Tasks
               left join
           (WITH RECURSIVE cte_count (n)
                               AS (
                   SELECT 1
                   UNION ALL
                   SELECT n + 1
                   FROM cte_count
                   WHERE n < (select max(subtasks_count) from Tasks)
               )
            SELECT n
            FROM cte_count) mid on mid.n <= subtasks_count) mid2 on mid2.task_id = Executed.task_id and subtask_id = n
where subtask_id is null;