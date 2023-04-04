select user_id, max(datediff(ifnull(after_date, '2021-01-01'), visit_date)) biggest_window
from (select user_id,
             visit_date,
             (select visit_date
              from UserVisits
              where user_id = uv.user_id
                and visit_date > uv.visit_date
              order by visit_date
              limit 1) after_date
      from UserVisits uv) mid
group by user_id
order by user_id;