select extra report_reason, count(distinct post_id) report_count
from Actions
where action_date = '2019-07-04'
  and action = 'report'
  and extra is not null
group by extra;