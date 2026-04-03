select
  round(ifnull(sum(cnt) / count(cnt), 0), 2) average_sessions_per_user
from
  (
    select
      count(distinct session_id) cnt,
      user_id
    from
      Activity
    where
      activity_date <= '2019-07-27'
      and activity_date >= '2019-06-28'
    group by
      user_id
  ) mid;