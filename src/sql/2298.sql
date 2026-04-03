select
  *
from
  (
    select
      count(task_id) weekend_cnt
    from
      Tasks
    where
      DAYOFWEEK(submit_date) = 1
      or DAYOFWEEK(submit_date) = 7
  ) mid
  inner join (
    select
      count(task_id) working_cnt
    from
      Tasks
    where
      DAYOFWEEK(submit_date) >= 2
      and DAYOFWEEK(submit_date) <= 6
  ) mid2;