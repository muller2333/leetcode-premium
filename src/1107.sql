select activity_date login_date, count(user_id) user_count
from (select min(activity_date) activity_date, user_id from Traffic where activity = 'login' group by user_id) mid
where datediff('2019-06-30', activity_date) <= 90
group by activity_date;